package org.example.springpeople.dto;

import jakarta.validation.constraints.Email;

public record StudentResponse(
        long id,
        String Name,
        String Email
) {
}
