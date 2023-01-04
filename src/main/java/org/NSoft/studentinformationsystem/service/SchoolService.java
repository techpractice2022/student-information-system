package org.NSoft.studentinformationsystem.service;


import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.NSoft.studentinformationsystem.domain.PersonalEntity;
import org.NSoft.studentinformationsystem.domain.SchoolEntity;
import org.NSoft.studentinformationsystem.repository.SchoolRepository;
import org.NSoft.studentinformationsystem.service.mapper.SchoolMapper;
import org.NSoft.studentinformationsystem.web.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SchoolService {

    private final SchoolMapper schoolMapper;

    private final SchoolRepository schoolRepository;


    public List<SchoolEntity> findAllPersonalInformation() {
        List<SchoolEntity> paramPersonal = schoolRepository.findAll(); //(Note:.findAll() is auto generated from JPA to fetch all data in DB)

        if (paramPersonal.isEmpty() || paramPersonal == null) {
            throw new ResourceNotFoundException("Data not found.");
        }
        return paramPersonal;
    }



}


