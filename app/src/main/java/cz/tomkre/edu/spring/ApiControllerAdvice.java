package cz.tomkre.edu.spring;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, ?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exc) {
        return exc.getBindingResult().getAllErrors().stream()
            .map(FieldError.class::cast)
            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, ?> handleNotFoundException(ResourceNotFoundException exc) {
        return Map.of("message", exc.getMessage());
    }

}
