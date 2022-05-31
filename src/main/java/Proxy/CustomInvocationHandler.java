package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * This {@link InvocationHandler} will log to console the execution of any
 * method on the targetObject.<br>
 * It acts as a proxy for the original object but is in fact only a handler, the
 * actual proxy is created via {@link Proxy} class
 */
public class CustomInvocationHandler implements InvocationHandler {

    /**
     * @param targetObject the object for which the Proxy is created
     */
    final private Object targetObject;
    public LocalDateTime dateLog;

    public CustomInvocationHandler(Object targetObject) {

    this.targetObject=targetObject;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        Object result;
        try{
            //log before
            System.out.println(this+" proxy executed before method "+method.getName());
            System.out.println(" ");
            dateLog=LocalDateTime.now();
            System.out.println(dateLog);
            System.out.println("");
            result=method.invoke(targetObject, args);
        }catch(Exception e){
            //log exceptiomn
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        }finally {
            //log after
            System.out.println(this+"proxy executed after method"+ method.getName());
        }

        System.out.println(result);
        return result;
    }
}
