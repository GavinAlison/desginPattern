package proxy.DymicType;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * DynamicProxy的应用
 *
 * @author hy
 */
public class DynamicProxyTest {
    interface IHello {
        void sayhello();
    }

    static class Hello implements IHello {
        @Override
        public void sayhello() {
            System.out.println("hello world!");
        }
    }

    static class DynamicProxy implements InvocationHandler {
        Object originalObj;

        // 生成一个动态代理类
        Object bind(Object originObj) {
            this.originalObj = originObj;
            return Proxy.newProxyInstance(
                    originObj.getClass().getClassLoader(), originalObj
                            .getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println("welcome...");
            return method.invoke(originalObj, args);
        }
    }

    public static void main(String[] args) {
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayhello();
    }

}
