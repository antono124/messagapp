package com.antogeo.dao;

import com.antogeo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDao extends AbstractDao{


    private static final String TABLE = "Message";
    private static final String RECEIVERS = "receivers";
    private static final String SENDER = "sender";
    private static final String MESSAGE_ID = "messageId";
    private static final String USER_ID = "userId";

    @Autowired
    HibernateUtil hibernateUtil;


    @Override
    public Message insert(Object o) {

        return (Message) hibernateUtil.insert(o);
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public List getByUserId(long userId) {
        return null;
    }
}
