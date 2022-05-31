package Proxy;

import Model.ServiceInterface;

import java.lang.reflect.InvocationHandler;

public class ProxyFactory {

    public static ServiceInterface createProxy (Object targetObject){

        ClassLoader classLoader=targetObject.getClass().getClassLoader();

        Class<?>[] interfaces=new Class[]{ServiceInterface.class};

        InvocationHandler invocationHandler= new CustomInvocationHandler(targetObject);

        return (ServiceInterface) java.lang.reflect.Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
