package com.service.course.exceptions;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {

        super("Resource not found !!");

    }

    public ResourceNotFoundException(String courseNotFound) {
        super(courseNotFound);
    }
}
