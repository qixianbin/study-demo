package com.spring.study.designpatterns.proxypattern.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private Object object;

    public ProxyFactory(Object object) {
        this.object = object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getProxyInstance(){
        /**
         * 1、classloader：目标对象的classloader
         * 2、interface：目标接口实现的接口
         * 3、InvocationHandler：目标对象的调用处理程序，会把当前执行的目标对象作为方法传入
         */
        Object resObject = Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy:当前的代理类，就是resObject，在invoke方法中基本不用
                     * @param method：目标对象的方法
                     * @param args：目标方法需要的参数
                     * @return  目标对象方法的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK动态代理--增强开始");
                        //利用反射机制调用目标对象的方法
                        /**
                         * method.invoke
                         *      第一个参数是目标对象，不是代理对象
                         *      第二个参数是目标对象的方法需要的参数
                         */
                        Object invoke = method.invoke(object, args);
                        System.out.println("JDK动态代理--增强结束");
                        return invoke;
                    }
                });
        return resObject;
    }

}
