package br.unifei.imc.lojaprodutos.exceptions;

import java.time.Instant;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CartaoJaCadastradoException.class)
    public ResponseEntity<StandardError> cartaoJaCadastradoException(CartaoJaCadastradoException e){
        var error = new StandardError(e.getMessage(), Date.from(Instant.now()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e){
        var error = new StandardError(e.getMessage(), Date.from(Instant.now()));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<StandardError> emailJaCadastradoException(EmailJaCadastradoException e){
        var error = new StandardError(e.getMessage(), Date.from(Instant.now()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
