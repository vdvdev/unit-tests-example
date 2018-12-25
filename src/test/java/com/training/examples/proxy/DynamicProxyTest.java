package com.training.examples.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    @Test
    public void test(){
        InvocationHandler myProxy = new MyProxy(new Integer(7));
        Class[] classes = new Class[]{Comparable.class, Runnable.class};
        Object proxy = Proxy.newProxyInstance(null, classes, myProxy);
        System.out.println(((Comparable)proxy).compareTo(new Integer(5)));
    }

    static class MyProxy implements InvocationHandler{

        private final Object target;

        public MyProxy(Object target){
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(args);
            return method.invoke(target, args);
        }
    }
}
