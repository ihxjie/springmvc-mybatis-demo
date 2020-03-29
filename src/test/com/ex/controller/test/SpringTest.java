package com.ex.controller.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void testSpring(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PathController exTestController = (PathController)applicationContext.getBean("pathController");

    }
}
