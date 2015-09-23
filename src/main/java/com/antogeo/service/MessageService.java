package com.antogeo.service;

import com.antogeo.dao.MessageDao;
import com.antogeo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService extends AbstractService {

    @Autowired
    MessageDao messageDao;

    @Transactional(readOnly = true)
    @Override
    public List<Message> getAll() {

        return messageDao.getAll();
    }


    @Transactional(readOnly = false)
    @Override
    public Message insert(Object o) {

        Message message = (Message) o;
        return messageDao.insert(message);
    }


    @Override
    public List getByUserId(long userId) {
        return null;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }
}
