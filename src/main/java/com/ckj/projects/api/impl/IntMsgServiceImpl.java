package com.ckj.projects.api.impl;

import com.ckj.projects.api.IntMsgService;
import com.ckj.projects.api.Message;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by ChenKaiJu on 2018/8/2  10:04
 */
public class IntMsgServiceImpl implements IntMsgService {
    @Override
    public void sendMsg(Message msg) {
        System.out.println("发送消息："+msg.toString());
    }

    @Override
    public Message reciveMsg(Message msg) {

        System.out.println("接收消息："+msg.toString());
        msg.setContent("你好");
        msg.setSender("myself");
        msg.setReciver("myself");
        msg.setSendTime(SimpleDateFormat.getDateTimeInstance().format(new Date()));
        return msg;
    }
}
