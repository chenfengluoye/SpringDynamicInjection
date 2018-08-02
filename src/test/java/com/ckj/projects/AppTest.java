package com.ckj.projects;

import com.ckj.projects.api.IntMsgService;
import com.ckj.projects.api.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/springConfig.xml"})
public class AppTest 
{

    @Autowired
    IntMsgService msgService;

    @Test
    public void shouldAnswerWithTrue() {
        System.out.println(msgService.getClass().getName());
        msgService.sendMsg(new Message());
        Message msg=msgService.reciveMsg(new Message());
        System.out.println(msg);
    }
}
