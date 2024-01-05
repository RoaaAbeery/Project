package com.example.foodtruck.Advice;

import com.example.foodtruck.ApiException.ApiException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice

public class ControllerAdvice {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(msg);
    }


    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity ConstraintViolationException(ConstraintViolationException e) {
        String msg =e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }



    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }


    @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class )
    public ResponseEntity InvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e){
        String msg=e.getMessage();
        return ResponseEntity.status(200).body(msg);
    }


    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }


    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }


    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }


    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }


    @ExceptionHandler(value = UnexpectedTypeException.class)
    public ResponseEntity UnexpectedTypeException(UnexpectedTypeException e){
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);

    }
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException e){
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);

    }
    @ExceptionHandler(value = IncorrectResultSizeDataAccessException.class)
    public ResponseEntity IncorrectResultSizeDataAccessException(IncorrectResultSizeDataAccessException e){
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);

    }


    @ExceptionHandler(value = JpaSystemException.class)
    public ResponseEntity IncorrectResultSizeDataAccessException(JpaSystemException e){
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);

    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity NullPointerException(NullPointerException e){
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);

    }


    @ExceptionHandler(value = InvalidDataAccessApiUsageException.class)
    public ResponseEntity InvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException e){
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);

    }

    @ExceptionHandler(value = HttpMessageConversionException.class)
    public ResponseEntity HttpMessageConversionException(HttpMessageConversionException e){
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);

    }
}
