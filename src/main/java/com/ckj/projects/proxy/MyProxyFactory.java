package com.ckj.projects.proxy;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * created by ChenKaiJu on 2018/8/2  10:09
 */
public class MyProxyFactory<T> implements FactoryBean<T> {

    public Class getRealClass() {
        return realClass;
    }

    public void setRealClass(Class realClass) {
        this.realClass = realClass;
    }

    Class realClass;

    @Override
    public T getObject() throws Exception {
      MyProxyInvocationHandler handler=  new MyProxyInvocationHandler();
        T obj= (T) Proxy.newProxyInstance(realClass.getClassLoader(),new Class[] {realClass},handler);
        return obj;
    }

    @Override
    public Class<?> getObjectType() {
        return realClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
