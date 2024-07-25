package com.user1.Controller;

import com.user1.DTO.PropertyUserDto;
import com.user1.Entity.PropertyUser;
import com.user1.Service.PropertyUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/PropertyUser")
public class PropertyController {

    private final PropertyUserService propertyUserService;

    public PropertyController(PropertyUserService propertyUserService) {
        this.propertyUserService = propertyUserService;
    }

    @PostMapping("/addProperty")
    public ResponseEntity<?> addProperty( @Valid @RequestBody PropertyUserDto dto,BindingResult result)
    {
        if(result.hasErrors())
        {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.OK);
        }
          PropertyUserDto res= propertyUserService.addProperty(dto);

           return new ResponseEntity<>(res, HttpStatus.CREATED);

    }

    @DeleteMapping
    public ResponseEntity<String> deletePropertyUser(
            @RequestParam long propertyUserId
    )
    {
          propertyUserService.deletePropertyUser(propertyUserId);

          return new ResponseEntity<>("record deleted!!!",HttpStatus.OK);
    }

    @PutMapping("/{propertyUserId}")
    public ResponseEntity<?> updatePropertyUser(

            @PathVariable long propertyUserId,
          @Valid @RequestBody PropertyUserDto dto,
            BindingResult result
    )
    {
        if(result.hasErrors())
        {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.OK);
        }
          PropertyUser updatedProperty=propertyUserService.updatePropertyUser(propertyUserId,dto);

          return new ResponseEntity<>(updatedProperty,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PropertyUser>> readPropertyUser()
    {
      List<PropertyUser>  listOfProperties= propertyUserService.readPropertyUser();

      return new ResponseEntity<>(listOfProperties,HttpStatus.OK);
    }

    
}
