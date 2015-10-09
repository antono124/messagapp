package com.antogeo.service;

import com.antogeo.dao.MessageDao;
import com.antogeo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;


    @Transactional(readOnly = false)
    public Message insert(Object o) {

        Message message = (Message) o;
        return messageDao.insert(message);
    }

    @Transactional(readOnly = true)
    public List<Message> getMessages(){

        return messageDao.getMessages();
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }
}
