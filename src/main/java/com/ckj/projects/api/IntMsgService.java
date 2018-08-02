package com.ckj.projects.api;

/**
 * created by ChenKaiJu on 2018/8/2  9:59
 */
public interface IntMsgService {

    public void sendMsg(Message msg);

    public Message reciveMsg(Message msg);
}
