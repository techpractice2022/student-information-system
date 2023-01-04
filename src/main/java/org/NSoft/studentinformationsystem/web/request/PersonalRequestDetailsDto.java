package org.NSoft.studentinformationsystem.web.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.print.DocFlavor.BYTE_ARRAY;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalRequestDetailsDto implements Serializable {


    private static final long serialVersionUID = -7175623352146349491L;


    @NotEmpty
    private String lastname;

    @NotNull
    private String firstname;

    @NotEmpty
    private String middleinitial;

    @NotNull
    private Integer age;

    private MultipartFile image;



}
