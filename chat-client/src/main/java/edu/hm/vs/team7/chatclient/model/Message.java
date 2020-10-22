package edu.hm.vs.team7.chatclient.model;

import java.util.UUID;

public class Message {

    public static Message from(Message message) {
        return new Message(message.content, message.sender, message.uuid);
    }

    private  String content;
    private String sender;
    private UUID uuid;

    public Message(){}

    private Message(String content, String sender, UUID uuid) {
        this.content = content;
        this.sender = sender;
        this.uuid = uuid;
    }

    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.uuid = UUID.randomUUID();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
