package com.hjj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        HelloWorld h1 = (HelloWorld) context.getBean(HelloWorld.class);
        HelloWorld h2 = (HelloWorld) context.getBean(HelloWorld.class);
        System.out.println(h1==h2);

        Customer c1 = (Customer) context.getBean("customer");
        System.out.println(c1.getContact().getAddress() + " ," +c1.getContact().getTelphone());

    }
}
