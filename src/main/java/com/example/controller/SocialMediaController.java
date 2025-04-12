package com.example.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.MessageService;
import com.example.service.AccountService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.exception.DuplicateUsernameException;
import com.example.exception.LoginFailException;
import com.example.exception.MessageClientError;
import java.util.List;



/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController 
{
    @Autowired
    public SocialMediaController(MessageService externalM, AccountService externalA)
    {
        billyBob = externalM;
        phillyBobbyBrown = externalA;
    }
    private final MessageService billyBob;
    private final AccountService phillyBobbyBrown;

    @PostMapping("/register") //User Story 1
    public ResponseEntity<Account> registerAccount(@RequestBody Account accountReceived)
    {
        Account philBob = phillyBobbyBrown.registerAccount(accountReceived);
        return new ResponseEntity<Account>(philBob, HttpStatus.OK);
    } 

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException exception)
    {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DuplicateUsernameException.class)
    public ResponseEntity<Object> handleDuplicateUsernameException(DuplicateUsernameException exception)
    {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PostMapping("/login") // User Story 2
    public ResponseEntity<Account> loginAccount(@RequestBody Account accountReceived)
    {
        Account philBob = phillyBobbyBrown.loginAccount(accountReceived);
        return new ResponseEntity<Account>(philBob, HttpStatus.OK);
    } 
    
    @ExceptionHandler(LoginFailException.class)
    public ResponseEntity<Object> handleLoginFailException(LoginFailException exception)
    {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/messages") // User Story 3
    public ResponseEntity<Message> submitMessage(@RequestBody Message messageReceived)
    {
        Message philBob = billyBob.submitMessage(messageReceived);
        return new ResponseEntity<Message>(philBob, HttpStatus.OK);
    } 

    @ExceptionHandler(MessageClientError.class)
    public ResponseEntity<Object> handleMessageClientError(MessageClientError exception)
    {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/messages") // User Story 4
    public ResponseEntity<List<Message>> retrieveMessages()
    {
        List<Message> philBob = billyBob.retrieveMessages();
        return new ResponseEntity<List<Message>>(philBob, HttpStatus.OK);
    } 

    @GetMapping("/messages/{messageId}") // User Story 5
    public ResponseEntity<Message> retrieveMessage(@PathVariable int messageId)
    {
        Message philBob = billyBob.retrieveMessage(messageId);
        return new ResponseEntity<Message>(philBob, HttpStatus.OK);
    } 

    @DeleteMapping("/messages/{messageId}") // User Story 6
    public ResponseEntity<String> deleteMessage(@PathVariable int messageId)
    {
        String philBob = billyBob.deleteMessage(messageId);
        return new ResponseEntity<String>(philBob, HttpStatus.OK);
    } 

    @PatchMapping("/messages/{messageId}") // User Story 7
    public ResponseEntity<String> updateMessage(@PathVariable int messageId, String messageText)
    {
        String philBob = billyBob.updateMessage(messageId, messageText);
        return new ResponseEntity<String>(philBob, HttpStatus.OK);
    } 
    
}
