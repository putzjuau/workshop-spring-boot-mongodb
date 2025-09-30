package com.joaovictor.workshopmongo.resources.exception;

import com.fasterxml.jackson.core.ObjectCodec;
import com.joaovictor.workshopmongo.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler{
    @ExceptionHandler(ObjectNotFoundException.class) //quando ocorrer essa excessao, cair para ca
    public ResponseEntity<StardardError> objetNotFound(ObjectNotFoundException e, HttpServletRequest request){ // quando estourar no serviço a excessao:
        HttpStatus status = HttpStatus.NOT_FOUND;
        StardardError err = new StardardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI()  );
        return ResponseEntity.status(404).body(err);
    }
}
