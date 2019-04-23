package com.hjj;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Auther: HJJ
 * @Date: 2019/04/22 12:03
 * @Description:
 */
@Component
public class HelloWorld {


    private String name;

    public String getName() {
        return name;
    }
    @Value("houjianjun111")
    public void setName(String name) {
        this.name = name;
    }

    public void hello(){
        System.out.println("hello:"+name);
    }
}
