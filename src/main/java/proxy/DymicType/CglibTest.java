package proxy.DymicType;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

import org.junit.Test;

/**
 * 利用cglib实现基于类的动态代理<br>
 * 使用enhancer类，设置其代理的类，设置回调函数是methodinterceptor接口的实现类， 这个实现类重写 intercept方法<br>
 * 然后就可以利用enhancer.create()创建代理类了。
 *
 * @author hy
 */
public class CglibTest {
    public void test() {
        System.out.println("cglib  test");
    }

    public String method01(String input) {
        return "method01  " + input;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        // 实现methodInterceptor接口，重写intercept方法，拦截所有的方法，所有的方法都会调用intercept方法
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args,
                                    MethodProxy proxy) throws Throwable {
                System.out.println("cglib before!");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("cglib after!");
                return result;
            }
        });

        CglibTest cg = (CglibTest) enhancer.create();
        cg.test();
    }

    @Test
    public void testFixedValue() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(new FixedValue() {
            // 拦截所有的方法，返回共同的值
            @Override
            public Object loadObject() throws Exception {
                return "hahaha";
            }
        });
        CglibTest proxy = (CglibTest) enhancer.create();
        // hahaha
        proxy.test();
        // hahaha
        System.out.println(proxy.toString());
        // class com.alison.cglib.CglibTest$$EnhancerByCGLIB$$5ca85ffc
        System.out.println(proxy.getClass());
        // String cannot be cast to Number
        // System.out.println(proxy.hashCode());
    }

    @Test
    public void testInvocationHandler() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(new InvocationHandler() {
            // 可能会有死循环
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                if (method.getDeclaringClass() != Object.class
                        && method.getReturnType() == String.class) {
                    return "cglib invocationHandler invoke!";
                } else {
                    throw new RuntimeException("Do not know what to do");
                }
            }
        });
        CglibTest proxy = (CglibTest) enhancer.create();
        // cglib invocationHandler invoke!
        System.out.println(proxy.method01("asd"));
    }

    @Test
    public void testCallbackFilter() {
        Enhancer enhancer = new Enhancer();
        CallbackHelper callbackHelper = new CallbackHelper(CglibTest.class,
                new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class
                        && method.getReturnType() == String.class) {
                    return new FixedValue() {
                        @Override
                        public Object loadObject() throws Exception {
                            return "Hello cglib";
                        }
                    };
                } else {
                    return NoOp.INSTANCE;
                }
            }
        };
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        CglibTest proxy = (CglibTest) enhancer.create();
        System.out.println(proxy.method01(null));
        System.out.println(proxy.toString());
        System.out.println(proxy.hashCode());
    }
}
