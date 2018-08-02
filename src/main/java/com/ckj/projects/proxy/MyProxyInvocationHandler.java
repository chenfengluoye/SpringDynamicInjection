package com.ckj.projects.proxy;

import com.ckj.projects.api.Message;
import com.ckj.projects.api.impl.IntMsgServiceImpl;
import com.sun.deploy.net.proxy.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * created by ChenKaiJu on 2018/8/2  10:08
 */
public class MyProxyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"方法开始执行。。。");
        try {
            if(method.getName().equals("sendMsg")){
                IntMsgServiceImpl intMsgService=new IntMsgServiceImpl();
                intMsgService.sendMsg((Message) args[0]);
                System.out.println(method.getName()+"方法执行完毕。。。");
                return null;
            }else{
                IntMsgServiceImpl intMsgService=new IntMsgServiceImpl();
                Message message= intMsgService.reciveMsg((Message) args[0]);
                System.out.println(method.getName()+"方法执行完毕。。。");
                return message;
            }
        }catch (Exception e){
            System.out.println(method.getName()+"方法异常结束。。。");
            return null;
        }
    }
}
