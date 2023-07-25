package com.project.springproject.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNOtFoundException extends RuntimeException {
    public ResourceNOtFoundException(String message){
    super(message);
}}
