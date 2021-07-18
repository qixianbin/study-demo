package com.spring.study.designpatterns.proxypattern.cblibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    //目标对象
    private Object target;

    //通过构造函数构建目标对象
    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回一个代理对象
    public Object getProxyInstance(){
        //创建工具类
        Enhancer enhancer = new Enhancer();
        //设置继承类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数为自己
        enhancer.setCallback(this);
        //创建代理对象
        Object o = enhancer.create();
        return o;
    }

    /**
     *
     * @param o
     * @param method：要执行的目标方法
     * @param args：目标方法需要的参数
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cblib动态代理--增强开始");
        Object invoke = method.invoke(target, args);
        System.out.println("cglib动态代理--增强结束");
        return invoke;
    }
}
