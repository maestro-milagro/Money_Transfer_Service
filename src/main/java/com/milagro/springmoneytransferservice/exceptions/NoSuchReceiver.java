package com.milagro.springmoneytransferservice.exceptions;

public class NoSuchReceiver extends Throwable{
    public NoSuchReceiver(String msg){
        super(msg);
    }
}
