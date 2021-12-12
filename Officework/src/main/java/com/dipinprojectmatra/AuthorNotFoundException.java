package com.dipinprojectmatra;

public class AuthorNotFoundException extends Exception {
    public AuthorNotFoundException(Long id){
        super("Not Found with id "+id);
    }
}

