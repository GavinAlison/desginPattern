package Singleton;

// .懒汉式单例类
public class lazySingletonDoubleCheck {
    private static lazySingletonDoubleCheck instance = null;

    private lazySingletonDoubleCheck() {
    }

    public static lazySingletonDoubleCheck getInstance() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (lazySingletonDoubleCheck.class) {
                //第二重判断
                if (instance == null) {
                    instance = new lazySingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
