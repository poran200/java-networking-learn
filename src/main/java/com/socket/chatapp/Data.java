package com.socket.chatapp;

import java.io.Serializable;

public class Data implements Serializable, Cloneable {
    public String message;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setMessage(String message) {
        this.message =message;
    }
}
