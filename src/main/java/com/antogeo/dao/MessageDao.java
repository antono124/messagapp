package com.antogeo.dao;

import com.antogeo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDao {

    @Autowired
    HibernateUtil hibernateUtil;

    public Message insert(Object o) {

        return (Message) hibernateUtil.insert(o);
    }

}
