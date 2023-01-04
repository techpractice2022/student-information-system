package org.NSoft.studentinformationsystem.service.mapper;


import org.NSoft.studentinformationsystem.domain.PersonalEntity;
import org.NSoft.studentinformationsystem.web.request.PersonalRequestDetailsDto;
import org.NSoft.studentinformationsystem.web.response.PersonalResponseDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
/*@DecoratedWith(PersonalMapperDecorator.class)*/
public interface PersonalMapper {

    //@Mapping(target = "name", source = "name")
    PersonalResponseDto toDto(PersonalEntity personalEntity);

    PersonalEntity toEntity(PersonalRequestDetailsDto personalRequestDetailsDto);

}


