package com.example.myhealth.model;

public class MyMessage {

    private String sender;
    private String content;
    private boolean isBelongsToCurrentUser;

    public MyMessage(String sender, String content, boolean isBelongsToCurrentUser) {
        this.sender = sender;
        this.content = content;
        this.isBelongsToCurrentUser = isBelongsToCurrentUser;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public boolean getIsBelongsToCurrentUser() {
        return isBelongsToCurrentUser;
    }
}
