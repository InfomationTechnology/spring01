package com.hjj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

/**
 * @Auther: HJJ
 * @Date: 2019/04/22 16:39
 * @Description: AOP XML方式
 *
 * JoinPoint(连接点):在目标对象中，所有可以增强的方法。
 * PointCut(切入点)：目标对象，已经增强的方法。
 * Advice(通知/增强)：增强的代码
 * Target(目标对象)：被代理对象
 * WeAVing(织入):将通知应用到切入点的过程
 * Proxy(代理)：将通知织入到目标对象之后，形成代理对象
 * Aspect(切面)：切入点+通知
 *
 * 前置通知 目标方法之前调用
 * 后置通知 （如果出现异常不会调用） 在目标方法运行之后
 * 环绕通知 在目标方法之前和之后都调用
 * 异常拦截通知 如果出现异常，就会调用
 * 后置通知 （无论是否出现异常都会调用） 在目标方法运行之后调用
 */
public class MyAdvice {

    //前置通知，方法名是自己定义的
    public void before(){
        System.out.println("这是前置通知");
    }
    //后置通知
    public void afterReturning(){
        System.out.println("这是后置通知（如果出现异常不会调用）");
    }
    //环绕通知
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("这是环绕通知之前的部分！");
        Object proceed = pjp.proceed();//调用目标方法
        System.out.println("这是环绕通知之后的部分！");
        return proceed;
    }
    //异常通知
    public void afterException() {
        System.out.println("异常出现了！");
    }
    //后置通知
    public void after() {
        System.out.println("这是后置通知(出现异常也会调用)");
    }

}
