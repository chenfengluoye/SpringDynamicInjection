package com.ckj.projects.api;

import java.io.Serializable;

/**
 * created by ChenKaiJu on 2018/8/2  10:01
 */
public class Message implements Serializable {

    String content;

    String sender;

    String reciver;

    String sendTime;


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

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", reciver='" + reciver + '\'' +
                ", sendTime='" + sendTime + '\'' +
                '}';
    }
}
