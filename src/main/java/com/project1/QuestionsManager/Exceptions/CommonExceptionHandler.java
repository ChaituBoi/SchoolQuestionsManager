package com.project1.QuestionsManager.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> QuestionNotFoundHandler(QuestionNotFound exception)
    {

        ExceptionResponse resp = new ExceptionResponse(
            exception.getMessage(),
            HttpStatus.NOT_FOUND.value(),
            System.currentTimeMillis()
        );
        return new ResponseEntity<>(resp,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> GeneralHandler(Exception exception)
    {
        ExceptionResponse resp = new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);

    }

}
