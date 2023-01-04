package org.NSoft.studentinformationsystem.repository;

import java.util.Optional;
import org.NSoft.studentinformationsystem.domain.PersonalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<PersonalEntity, Long> {

        Optional<PersonalEntity> findByLastname(String lastname);



        /*This is not required JPA got an auto findByID process
        Optional<PersonalEntity> findById (Long id);*/

}


