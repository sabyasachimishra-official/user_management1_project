package com.user1.Service;

import com.user1.DTO.PropertyUserDto;
import com.user1.Entity.PropertyUser;
import com.user1.Repository.PropertyUserRepository;
import org.hibernate.mapping.Property;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyUserService {

  private final PropertyUserRepository propertyUserRepository;

    public PropertyUserService(PropertyUserRepository propertyUserRepository) {
        this.propertyUserRepository = propertyUserRepository;
    }




    public PropertyUserDto addProperty(PropertyUserDto dto) {

        PropertyUser entity=new PropertyUser();

        entity.setName(dto.getName());
        entity.setEmailId(dto.getEmailId());
        entity.setMobile(dto.getMobile());

       PropertyUser savedEntity= propertyUserRepository.save(entity);

       PropertyUserDto pd=new PropertyUserDto();

       pd.setId(savedEntity.getId());
       pd.setName(savedEntity.getName());
       pd.setEmailId(savedEntity.getEmailId());
       pd.setMobile(savedEntity.getMobile());

       return pd;
    }
//----------------------------------------------------------------------------------------------

    public void deletePropertyUser(long propertyUserId) {

        propertyUserRepository.deleteById(propertyUserId);
    }
//--------------------------------------------------------------------------------------------------
    public PropertyUser updatePropertyUser(long propertyUserId,PropertyUserDto dto) {

        Optional<PropertyUser> byId = propertyUserRepository.findById(propertyUserId);

        PropertyUser entityData=byId.get();

        entityData.setMobile(dto.getMobile());
        entityData.setEmailId(dto.getEmailId());
        entityData.setName(dto.getName());

      return   propertyUserRepository.save(entityData);
    }
//-----------------------------------------------------------------------------------------------------
public  List<PropertyUser> readPropertyUser() {

    return propertyUserRepository.findAll();
}



}
