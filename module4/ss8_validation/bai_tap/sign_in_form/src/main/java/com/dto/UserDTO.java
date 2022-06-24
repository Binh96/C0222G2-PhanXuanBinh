package com.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDTO implements Validator {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    private String firstName;

    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 20)
    private String lastName;

    @NotEmpty
    @Min(18)
    private String age;

    @Pattern(regexp = "^(090)\\d{7}$", message = "invalid number phone")
    private String numberPhone;

    @NotEmpty
    @NotBlank
    @Email
    private String email;


    public UserDTO() {
    }

    public UserDTO(@NotNull @NotBlank @Size(min = 2, max = 20) String firstName,
                   @NotEmpty @NotBlank @Size(min = 2, max = 20) String lastName,
                   @NotEmpty @Min(18) String age, @Pattern(regexp = "^(090)\\d{7}$",
            message = "invalid number phone") String numberPhone,
                   @NotEmpty @NotBlank @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
