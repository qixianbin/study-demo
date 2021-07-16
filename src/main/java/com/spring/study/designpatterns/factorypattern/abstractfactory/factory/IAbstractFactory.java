package com.spring.study.designpatterns.factorypattern.abstractfactory.factory;

import com.spring.study.designpatterns.factorypattern.abstractfactory.product.IPC;
import com.spring.study.designpatterns.factorypattern.abstractfactory.product.IPhone;

public interface IAbstractFactory {
    public IPhone createPhone();
    public IPC createPC();
}
