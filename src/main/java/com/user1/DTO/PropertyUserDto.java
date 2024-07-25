package com.user1.DTO;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.lang.NonNull;

public class PropertyUserDto {


    private Long id;

   @NotNull
   @Size(min=2,message = "shoul be atleast 2 characters")
    private String name;


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Size(min=10,max=10,message = "mobile number should be atleast 10 digits")
    private String mobile;

    @Email
    private String emailId;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}

