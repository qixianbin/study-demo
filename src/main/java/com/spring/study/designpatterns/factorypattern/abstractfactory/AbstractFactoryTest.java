package com.spring.study.designpatterns.factorypattern.abstractfactory;

import com.spring.study.designpatterns.factorypattern.abstractfactory.factory.IAbstractFactory;
import com.spring.study.designpatterns.factorypattern.abstractfactory.factory.MIFactory;
import com.spring.study.designpatterns.factorypattern.abstractfactory.factory.SanxingFactory;
import com.spring.study.designpatterns.factorypattern.abstractfactory.product.IPC;
import com.spring.study.designpatterns.factorypattern.abstractfactory.product.IPhone;
import com.spring.study.designpatterns.factorypattern.factorymethod.factory.IFactoryMethod;

public class AbstractFactoryTest {
    
    public static void main(String[] args) {
        IAbstractFactory abstractFactory = new MIFactory();
        IAbstractFactory abstractFactory1 = new SanxingFactory();
        
        IPhone phone = abstractFactory.createPhone();
        IPC ipc = abstractFactory.createPC();
        
        IPhone phone1 = abstractFactory1.createPhone();
        IPC ipc1 = abstractFactory1.createPC();
        
        phone.makePhone();
        phone1.makePhone();
        ipc.makePC();
        ipc1.makePC();
    }
    
}
