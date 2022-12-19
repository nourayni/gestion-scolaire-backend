package com.gestionuniversitaire.gestionuniversitaire.exception;

public class UserConflictException extends ConflictException{
    public UserConflictException(String message) {
        super(message);
    }
}
