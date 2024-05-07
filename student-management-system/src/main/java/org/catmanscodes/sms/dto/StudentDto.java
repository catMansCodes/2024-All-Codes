package org.catmanscodes.sms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDto {

    private Long id;

    @NotEmpty(message = "Student First name should not be empty.")
    private String firstName;

    @NotEmpty(message = "Student Last name should not be empty.")
    private String lastName;

    @NotEmpty(message = "Student Email Id should not be empty.")
    @Email
    private String email;

}
