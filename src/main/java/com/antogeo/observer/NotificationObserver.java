package com.antogeo.observer;


import java.util.Observable;


public abstract class NotificationObserver<T> implements java.util.Observer {



    public abstract void update(Observable o, Object arg);

}
