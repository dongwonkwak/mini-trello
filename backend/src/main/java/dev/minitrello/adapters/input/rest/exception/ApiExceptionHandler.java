package dev.minitrello.adapters.input.rest.exception;


import dev.minitrello.adapters.input.rest.model.ErrorMessage;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

/*
{
    code:
    message:
    details:
        []
}
 */
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handleValidationException(ConstraintViolationException exception) {
        return createErrorResponse(exception, HttpStatus.BAD_REQUEST, ",");
    }


    private ResponseEntity<ErrorMessage> createErrorResponse(Exception exception, HttpStatus httpStatus, String delim) {
        var details = Arrays.stream(exception.getMessage().split(delim)).toList();

        var message = new ErrorMessage()
                .code(httpStatus.name())
                .message(exception.getLocalizedMessage())
                .details(details);

        return new ResponseEntity<>(message, httpStatus);
    }
}
