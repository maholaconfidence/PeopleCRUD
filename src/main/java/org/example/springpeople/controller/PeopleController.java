package org.example.springpeople.controller;

import jakarta.validation.Valid;
import org.example.springpeople.dto.PeopleRequest;
import org.example.springpeople.dto.PeopleResponse;
import org.example.springpeople.services.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {
    private final PeopleService peopleService;
    public  PeopleController(PeopleService peopleService){
        this.peopleService =peopleService;
    }
//CREATE
    @PostMapping
    public ResponseEntity<PeopleResponse> createPerson(@Valid @RequestBody PeopleRequest request){
        PeopleResponse response = PeopleService.createPerson(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
//READ ALL
    @GetMapping
    public  ResponseEntity<List<PeopleResponse>> getAllPeople(){
        return ResponseEntity.ok(peopleService.getAllPeople());
    }
    //READ ONE
    @GetMapping("/{id}")
    public  ResponseEntity<PeopleResponse> getPersonById(@PathVariable Long id){
        return ResponseEntity.ok(peopleService.getPersonById(id));
    }
    //UPDATE
    @PutMapping("/{id}")
    public  ResponseEntity<PeopleResponse> updatePerson(@PathVariable Long id, @Valid @RequestBody PeopleRequest request){
        return  ResponseEntity.ok(peopleService.updatePerson(id, request));
    }
    //DELETE
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deletePerson(@PathVariable Long id){
        peopleService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
