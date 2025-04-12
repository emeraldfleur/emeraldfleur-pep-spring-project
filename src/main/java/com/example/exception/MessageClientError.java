package com.example.exception;

public class MessageClientError extends RuntimeException{
    public MessageClientError()
    {
        super();
    }
    public MessageClientError(String words)
    {
        super(words);
    }
}
