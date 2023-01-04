package org.NSoft.studentinformationsystem.web.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Aldwin Delgado
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@RestControllerAdvice
public class WebEndpointExceptionHandler extends ResponseEntityExceptionHandler {

    private String errorMessage;

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex,
        WebRequest request) {
        errorMessage = "Requested resource does not exist";

        return createResponse(new ErrorDto(HttpStatus.NOT_FOUND, errorMessage, ex.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex,
        WebRequest request) {
        errorMessage = "Request is not well-formed";

        return createResponse(new ErrorDto(HttpStatus.BAD_REQUEST, errorMessage, ex.getMessage()));
    }

    @ExceptionHandler(DuplicateIdentifierException.class)
    protected ResponseEntity<Object> handleDuplicateIdentifierException(DuplicateIdentifierException ex,
                                                                        WebRequest request){
        errorMessage = "Request 'name' is already used.";

        return createResponse(new ErrorDto(HttpStatus.CONFLICT, errorMessage, ex.getMessage()));
    }

    private ResponseEntity<Object> createResponse(ErrorDto errorDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return new ResponseEntity<>(errorDto, headers, errorDto.getStatus());
    }

    @ExceptionHandler(DTOException.class)
    protected ResponseEntity<Object> handleDTOException(DTOException pDTOEx, WebRequest pWebRequest){
        errorMessage = "invalid data type";
        return  createResponse((new ErrorDto(HttpStatus.BAD_REQUEST, errorMessage, pDTOEx.getMessage())));
    }

    @ExceptionHandler(InvalidRequestException.class)
    protected ResponseEntity<Object> handleInvalidRequestException(InvalidRequestException ex, WebRequest pWebRequest){
        errorMessage = "invalid request";
        return  createResponse((new ErrorDto(HttpStatus.BAD_REQUEST, errorMessage, ex.getMessage())));
    }

}
