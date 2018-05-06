package proxy.DymicType;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 测试静态代理<br>
 * 总的来说静态代理实现简单也容易理解，但是静态代理不能使一个代理类反复作用于多个目标对象，代理对象直接持有目标对象的引用，<br>
 * 这导致代理对象和目标对象类型紧密耦合了在一起 。<br>
 * 如果UserDao接口下还有另一个<b>实现类<b>也需要进行事务控制，那么就要重新写一个代理类，这样就会产生许多重复的模版代码 ，<br>
 * 不能达到代码复用的目的。而动态代理就可以很好的解决这样的问题。
 *
 * @author hy
 */
public class ProxyTest {

    /**
     * 代理接口
     */
    interface UserDao {
        void save();
    }

    /**
     * 目标对象
     */
    class UserDaoImpl implements UserDao {
        @Override
        public void save() {
            System.out.println("saveing user ....");
        }
    }

    /**
     * 代理对象
     */
    class TransactionHandler implements UserDao {
        // 目标代理对象
        private UserDaoImpl target;

        // 构造代理对象时传入目标对象
        public TransactionHandler(UserDaoImpl target) {
            this.target = target;
        }

        @Override
        public void save() {
            // 调用目标方法前的处理
            System.out.println("开启事务控制.....");
            // 调用目标对象的方法
            target.save();
            // 调用目标方法后的处理
            System.out.println("关闭事务控制.....");
        }
    }

    // 代理对象：TransactionDynamicHandler
    public class TransactionDynamicHandler implements InvocationHandler {

        // 需要代理的目标对象
        // 这里设计为可以为任意一个对象添加事务控制, 所以将目标对象声明为Object
        private Object target;

        // 构造TransactionDynamicHandler时传入目标对象
        public TransactionDynamicHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            // 调用目标方法前的处理
            System.out.println("开启事务控制...");
            // 调用目标对象的方法
            Object result = method.invoke(target, args);
            // 调用目标方法后的处理
            System.out.println("关闭事务控制...");
            // 放回方法调用结果
            return result;
        }

    }

    public static void main(String[] args) {

    }

    public void method01() {
        // 新建目标对象
        UserDaoImpl target = new ProxyTest().new UserDaoImpl();
        // 创建代理对象, 并使用接口对其进行引用
        UserDao userDao = new ProxyTest().new TransactionHandler(target);
        // 针对接口进行调用
        userDao.save();
    }

    public void method02() {
        // 新建目标对象
        Object target = new UserDaoImpl();
        // 创建事务处理器
        TransactionDynamicHandler handler = new ProxyTest().new TransactionDynamicHandler(
                target);
        // 生成代理类并使用接口对其进行引用
        UserDao userDao = (UserDao) Proxy.newProxyInstance(target
                        .getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        // 针对接口进行方法调用
        userDao.save();
    }
}
