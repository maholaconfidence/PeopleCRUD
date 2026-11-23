package org.example.springpeople.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PeopleRequest(
        @NotBlank(message = "name is required")
        @Size(max = 100, message = "Name cannot exceed 100 characters")
        String Name,

        @NotBlank(message = "Email is required")
        @Email(message = "Enter a valid email address")
        @Size(max = 255, message = "Email must not exceed 255 characters")
        String email



) {
}
