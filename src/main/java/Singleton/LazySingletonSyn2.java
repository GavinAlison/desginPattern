package Singleton;

// .懒汉式单例类
public class LazySingletonSyn2 {
    private static LazySingletonSyn2 instance = null;

    private LazySingletonSyn2() {
    }

    public static LazySingletonSyn2 getInstance() {

        if (instance == null) {
            synchronized (LazySingletonSyn2.class) {
                instance = new LazySingletonSyn2();
            }
        }
        return instance;
    }
}
