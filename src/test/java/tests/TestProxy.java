package tests;

import Model.ServiceImplementation;
import Model.ServiceInterface;
import Proxy.ProxyFactory;
import org.junit.Assert;
import org.junit.Test;

import java.security.Provider;

public class TestProxy {

    private final ServiceImplementation originalObject=new ServiceImplementation();

    @Test
    public void testProxy(){
        //accessing the object directly
        Assert.assertEquals(4, originalObject.addTwoNumbers(3,1));

        //create the proxy
        ServiceInterface proxyObject = ProxyFactory.createProxy(originalObject);

        //verify the proxy
        Assert.assertNotNull(proxyObject);

        //check the proxy logs
        Assert.assertEquals(4, proxyObject.addTwoNumbers(2,2));
    }
}
