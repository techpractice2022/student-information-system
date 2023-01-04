package org.NSoft.studentinformationsystem.repository;


import org.NSoft.studentinformationsystem.domain.PersonalEntity;
import org.NSoft.studentinformationsystem.domain.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository <T extends PersonalEntity>  extends JpaRepository<SchoolEntity, Long> {
}


