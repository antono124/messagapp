package com.antogeo.observer;

import com.antogeo.utils.ButtonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Observable;


@Component("completeContestNotificationObserver")
public class PressButtonNotificationObserver  extends NotificationObserver {

    @Autowired
    private MessageLogic messageLogic;

    @Override
    public void update(Observable o,  Object arg) {

        messageLogic.buildAndSendButtonMessage((ButtonType) arg);
    }
}
