package com.example.service;
import org.springframework.stereotype.Service;
import com.example.entity.Message;
import com.example.exception.MessageClientError;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService 
{
    public MessageService(AccountRepository passedInRepo, MessageRepository messageRepo)
    {
        phil = passedInRepo;
        messageRepoOurs = messageRepo;
    }
    private final AccountRepository phil;
    private final MessageRepository messageRepoOurs;


    public Message submitMessage(Message message)
    {
        String messageText = message.getMessageText();
        int userID = message.getPostedBy();
        long time = message.getTimePostedEpoch();
        if(messageText == null || messageText.isBlank() || (messageText.length() > 255))
        {
            throw new MessageClientError();
        }
        else if(!phil.existsById(userID))
        {
            throw new MessageClientError();
        }
        else
        {
            Message barb = new Message(userID, messageText, time);
            barb = messageRepoOurs.save(barb);
            return barb;
        }
    }
    public List<Message> retrieveMessages()
    {
        List<Message> messageList = messageRepoOurs.findAll();
        return messageList;
    }
    public Message retrieveMessage(int messageId)
    {
        Optional<Message> bob = messageRepoOurs.findById(messageId);
        if(bob.isEmpty())
        {
            return new Message();
        }
        else
        {
            return bob.get();
        }
    }
}
