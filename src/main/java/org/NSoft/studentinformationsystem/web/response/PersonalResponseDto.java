package org.NSoft.studentinformationsystem.web.response;


import java.io.Serializable;
import lombok.Data;


@Data
public class PersonalResponseDto implements Serializable {

    private static final long serialVersionUID = 6397895759617983229L;

    private Long id; //(This variable is used for both findByLastname and findById method, another dto could be made without id for the lastname)

    private String lastname;

    private String firstname;

    private String middleinitial;

    private Integer age;

   private String image; //(This variable is used for both findByLastname and findById method, another dto could be made without image for the lastname)
}


