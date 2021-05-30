package cn.xiaoyu.algostruct.designPatterns.proxyDesign.dynamicAgency;

import org.omg.PortableInterceptor.RequestInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IUserController {
    public void login();

    public void register();

    public void loginOut();

}

public class UserController implements IUserController {
    public void login() {
        System.out.println("to login");
    }

    public void register() {
        System.out.println("to register");
    }

    public void loginOut() {
        System.out.println("to loginOut");
    }

}

class MetricsCollectorProxy {
    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = method.invoke(proxiedObject, args);
            System.out.println("insert metric operator");
            return result;
        }
    }
}

class Case {
    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        userController.login();
        userController.loginOut();
    }
}
