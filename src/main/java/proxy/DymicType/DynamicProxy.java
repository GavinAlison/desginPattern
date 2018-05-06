package proxy.DymicType;

import com.sun.org.apache.regexp.internal.RE;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    Object originObj;

    Object bind(Object originObj) {
        this.originObj = originObj;
        return Proxy.newProxyInstance(
                originObj.getClass().getClassLoader(),
                originObj.getClass().getInterfaces(),
                this);
    }

    public DynamicProxy(Object originObj) {
        this.originObj = originObj;
    }

    public DynamicProxy() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前...");
        return method.invoke(originObj, args);
    }


    public static void main(String[] args) {


        AbstractSubject asub = (AbstractSubject) new DynamicProxy().bind(new RealSub());
        asub.request();

        AbstractSubject asub2 = new RealSub();

        DynamicProxy dynamic = new DynamicProxy(asub2);
        AbstractSubject proxy = (AbstractSubject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{AbstractSubject.class},
                dynamic);
        proxy.request();
    }
}
