package com.example.exception;

public class LoginFailException extends RuntimeException //We're handling this with Spring so Runtime for unchecked
{
    public LoginFailException()
    {
        super();
    }
    public LoginFailException(String words)
    {
        super(words);
    }
}
