package org.NSoft.studentinformationsystem.repository;

import java.util.Optional;
import org.NSoft.studentinformationsystem.domain.PersonalImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonalImageRepository extends JpaRepository<PersonalImageEntity, Long> {

    Optional<PersonalImageEntity> findByImageName(String imageName);

}
