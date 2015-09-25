package com.antogeo.observer;

import com.antogeo.utils.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Observable;


@Component("chooseColorNotificationObserver")
public class ChooseColorNotificationObserver extends NotificationObserver {

    @Autowired
    private MessageLogic messageLogic;

    @Override
    public void update(Observable o,  Object arg) {

        messageLogic.buildAndSendColorMessage((Color) arg);
    }
}
