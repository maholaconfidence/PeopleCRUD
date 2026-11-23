package org.example.springpeople.services;

import org.example.springpeople.dto.PeopleRequest;
import org.example.springpeople.dto.PeopleResponse;
import org.example.springpeople.entity.People;
import org.example.springpeople.exceptions.DuplicateResourceException;
import org.example.springpeople.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {
    private  PeopleService peopleService;
    public PeopleService(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    //CREATE
    public static PeopleResponse createPerson(PeopleRequest request){
        People person = new People();
        person.setName(request.Name());
        person.setEmail(request.email());
        People savedPerson = PeopleRepository.save(person);
        return  mapToResponse(savedPerson);
    }
    //READ ALL
    public List<PeopleResponse> getAllPeople(){
        return  PeopleRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    //READ ONE
    public  PeopleResponse getPersonById(Long id){
        People person = findPersonOrThrow(id);
        return  mapToResponse(person);

    }
//UPDATE
    public PeopleResponse updatePerson(Long id, PeopleRequest request){
        People person = findPersonOrThrow(id);

        boolean emeailUsedByAnotherPerson = PeopleRepository.existsByEmailAndIdNot(request.email(), id);

        if (emailUsedByAnotherStudent) {
            throw new DuplicateResourceException(
                    "Another person is already using this email"
            );
        }

        person.setName(request.Name());
        person.setEmail(request.email());

        People updatedPerson = PeopleRepository.save(person);

        return  mapToResponse(updatedPerson);
    }

    //DELETE
    public  void  deletePerson(Long id){
        People person = findPersonOrThrow(id);

        PeopleRepository.delete(person);
    }
    private People findStudentOrThrow(Long id) {

        return PeopleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Person not found with ID: " + id
                ));
}
private  PeopleResponse mapToResponse(People person){
    return new PeopleResponse(
            person.getId(),
            person.getName(),
            person.getEmail()
    );
    }
}
