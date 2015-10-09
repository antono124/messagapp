package com.antogeo.dao;

import com.antogeo.entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDao {

    @Autowired
    HibernateUtil hibernateUtil;

    @Autowired
    private SessionFactory sessionFactory;

    public Message insert(Object o) {

        return (Message) hibernateUtil.insert(o);
    }

    public List<Message> getMessages(){

        try{
            Session session = getSessionFactory().getCurrentSession();

            return(List<Message>) session.createQuery("FROM Message").list();

        }catch(RuntimeException e){
            getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }

    }


    protected SessionFactory getSessionFactory() {

        return sessionFactory;
    }
}
