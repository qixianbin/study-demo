package com.spring.study.designpatterns.factorypattern.abstractfactory.factory;

import com.spring.study.designpatterns.factorypattern.abstractfactory.product.IPC;
import com.spring.study.designpatterns.factorypattern.abstractfactory.product.IPhone;
import com.spring.study.designpatterns.factorypattern.abstractfactory.product.MIPc;
import com.spring.study.designpatterns.factorypattern.abstractfactory.product.MIPhone;

public class MIFactory implements IAbstractFactory{
    @Override
    public IPhone createPhone() {
        return new MIPhone();
    }
    
    @Override
    public IPC createPC() {
        return new MIPc();
    }
}
