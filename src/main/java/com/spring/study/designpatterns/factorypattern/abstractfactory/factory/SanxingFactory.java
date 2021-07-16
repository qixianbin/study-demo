package com.spring.study.designpatterns.factorypattern.abstractfactory.factory;

import com.spring.study.designpatterns.factorypattern.abstractfactory.product.IPC;
import com.spring.study.designpatterns.factorypattern.abstractfactory.product.IPhone;
import com.spring.study.designpatterns.factorypattern.abstractfactory.product.SanxingPC;
import com.spring.study.designpatterns.factorypattern.abstractfactory.product.SanxingPhone;

public class SanxingFactory implements IAbstractFactory {
    @Override
    public IPhone createPhone() {
        return new SanxingPhone();
    }
    
    @Override
    public IPC createPC() {
        return new SanxingPC();
    }
}
