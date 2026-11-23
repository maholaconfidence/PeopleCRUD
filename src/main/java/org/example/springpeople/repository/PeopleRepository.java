package org.example.springpeople.repository;

import org.example.springpeople.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<People, Long> {
    boolean existsByEmail(String email);

    static boolean existsByEmailAndIdNot(String email, Long id) {
        return false;
    }

    Optional<People> findByEmail(String email);

}
