package com.dipinprojectmatra;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id){
        super("Not Found"+id);
    }

}

