package com.example.exception;

public class DuplicateUsernameException extends RuntimeException //We're handling this with Spring so Runtime for unchecked
{
    public DuplicateUsernameException()
    {
        super();
    }
    public DuplicateUsernameException(String words)
    {
        super(words);
    }
}
