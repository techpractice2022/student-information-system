package org.NSoft.studentinformationsystem.web.exception;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author Aldwin Delgado
 */
@Data
@AllArgsConstructor
public class ErrorDto implements Serializable {

    private static final long serialVersionUID = -336620372152552809L;

    private HttpStatus status;

    private String message;

    private String details;


}
