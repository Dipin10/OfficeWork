package com.dipinprojectmatra;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id){
        super("Not Found"+id);
    }
}

