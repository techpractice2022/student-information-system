package org.NSoft.studentinformationsystem.service.mapper;


import org.NSoft.studentinformationsystem.domain.SchoolEntity;
import org.NSoft.studentinformationsystem.web.response.SchoolResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolMapper {

    //@Mapping(target = "name", source = "name")
    SchoolResponseDto toDto(SchoolEntity schoolEntity);

}
