package org.example.springpeople.controller;

import org.example.springpeople.services.PeopleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {
    private final PeopleService peopleService;
    public  PeopleController(PeopleService peopleService){
        this.peopleService =peopleService;
    }


}
