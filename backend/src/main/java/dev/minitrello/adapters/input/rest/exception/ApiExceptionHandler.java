package dev.minitrello.adapters.input.rest.exception;


import dev.minitrello.adapters.input.rest.model.ErrorMessage;
import dev.minitrello.common.exception.EmailExistsException;
import dev.minitrello.common.exception.GenericException;
import dev.minitrello.common.exception.UsernameExistsException;
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

    @ExceptionHandler(value = UsernameExistsException.class)
    public ResponseEntity<ErrorMessage> handleUsernameException(UsernameExistsException exception) {
        return createErrorResponse(exception, HttpStatus.BAD_REQUEST, "");
    }

    @ExceptionHandler(value = EmailExistsException.class)
    public ResponseEntity<ErrorMessage> handleEmailException(EmailExistsException exception) {
        return createErrorResponse(exception, HttpStatus.BAD_REQUEST, "");
    }

    @ExceptionHandler(value = GenericException.class)
    public ResponseEntity<ErrorMessage> handleGenericException(GenericException exception) {
        return createErrorResponse(exception, HttpStatus.BAD_REQUEST, "");
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
