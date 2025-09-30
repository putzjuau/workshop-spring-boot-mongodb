package com.joaovictor.workshopmongo.exception;

public class ObjectNotFoundException extends RuntimeException { // classe auxiliar para tratar excessao
    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
