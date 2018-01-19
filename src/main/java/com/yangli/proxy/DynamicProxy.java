package com.yangli.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * lies, please leave something
 *  动态代理
 * @author lies
 * @Createdon 2018/1/19 10:26.
 * @ProjectName proxy
 */
public class DynamicProxy implements InvocationHandler {
    //所需要代理的的对象的申明，需要实现接口（被代理对象）
    Object obj;

    //为被代理对应进行实例化，以及返回一个代理类的对象
    public Object blind(Object obj){
        this.obj = obj;//为被代理对象进行实例化
        //返回一个代理类的对象
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    //当通过代理类的对象发起对重写方法的调用时，会自动转换为调用该重写的invoke方法。
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object resultVal = method.invoke(proxy, args);
        //返回一个
        return resultVal;
    }
}
