package com.ckj.projects;

/**
 * Hello world!
 *
 */

import com.ckj.projects.api.IntMsgService;
import com.ckj.projects.api.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring 动态注入接口，获取代理对象
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/springConfig.xml"})
public class App {
    @Autowired
    IntMsgService msgService;

    @Test
    public void AppTest() {
        System.out.println(msgService.getClass().getName());
        msgService.sendMsg(new Message());
        Message msg=msgService.reciveMsg(new Message());
        System.out.println(msg);
    }

}
