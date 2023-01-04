package org.NSoft.studentinformationsystem.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "reason")
public class DTOException extends RuntimeException {

    public DTOException(){
        super("Invalid data type.");
    }
}
