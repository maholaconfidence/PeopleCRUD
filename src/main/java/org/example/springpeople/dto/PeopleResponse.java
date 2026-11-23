package org.example.springpeople.dto;

public record PeopleResponse(
        long id,
        String Name,
        String Email
) {
}
