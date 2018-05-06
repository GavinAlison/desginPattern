package Singleton;

// .懒汉式单例类
public class LazySingletonSyn {
    private static LazySingletonSyn instance = null;

    private LazySingletonSyn() {
    }

    synchronized public static LazySingletonSyn getInstance() {
        if (instance == null) {
            instance = new LazySingletonSyn();
        }
        return instance;
    }
}
