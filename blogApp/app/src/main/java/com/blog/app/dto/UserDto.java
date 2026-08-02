package com.blog.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto  {
    private Integer id;
    @NotEmpty
    @Size(min = 3, max =125, message =  "User name must be min 3  max 125, characters !!")
    private String name;
   @Email(message = "Email address is not valid !!")
    private String email;
   @NotEmpty
   @Size(min = 3, max = 20, message = "password must be min 3 chars and max 20 !!")
    private String password;
   @NotEmpty
    private  String about;
}
