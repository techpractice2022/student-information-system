/*
package org.NSoft.studentinformationsystem.service.mapper;


import org.NSoft.studentinformationsystem.domain.PersonalEntity;
import org.NSoft.studentinformationsystem.repository.PersonalRepository;
import org.NSoft.studentinformationsystem.web.request.PersonalRequestDetailsDto;
import org.NSoft.studentinformationsystem.web.response.PersonalResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PersonalMapperDecorator implements PersonalMapper {

    private PersonalRepository personalRepository;

    private PersonalMapper delegate;

    @Autowired
    @Qualifier("delegate")
    public void setDelegate(PersonalMapper mapper) {
        this.delegate = mapper;
    }


    @Override
    public PersonalEntity toEntity(PersonalRequestDetailsDto personalRequestDetailsDto) {
        if (personalRequestDetailsDto == null) {
            return null;
        }

        PersonalEntity entity = delegate.toEntity(personalRequestDetailsDto);
        PersonalEntity saveInfo = personalRepository.save(entity);
        return entity;
    }

    @Override
    public PersonalResponseDto toDto(PersonalEntity personalEntity){
        if (personalEntity == null) {
            return null;
        }
        PersonalResponseDto dto = delegate.toDto(personalEntity);
        return dto;

    }




}
*/
