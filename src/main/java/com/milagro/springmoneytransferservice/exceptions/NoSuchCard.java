package com.milagro.springmoneytransferservice.exceptions;

public class NoSuchCard extends Throwable{
    public NoSuchCard(String msg){
        super(msg);
    }
}
