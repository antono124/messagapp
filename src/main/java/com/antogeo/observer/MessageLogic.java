package com.antogeo.observer;

import com.antogeo.entity.Message;
import com.antogeo.entity.User;
import com.antogeo.service.MessageService;
import com.antogeo.service.UserService;
import com.antogeo.utils.ButtonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component("messageLogic")
public class MessageLogic {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;


    protected void buildAndSendButtonMessage(ButtonType buttonType){

        String buttonColor;
        if(buttonType.equals(ButtonType.GREEN)){
            buttonColor = "green";
        }else{
            buttonColor = "red";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User sender = userService.getUserByUsername(auth.getName());


        String title = "Button pressed";
        String body = "User "  + sender.getUsername() + " just pressed the " + buttonColor + " button!";


        Message message = new Message();

        message.setTitle(title);
        message.setBody(body);
        message.setSender(sender);

        messageService.insert(message);


    }

}
