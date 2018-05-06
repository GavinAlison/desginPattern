package Singleton;

public class SingletonHolder {
    private SingletonHolder() {
    }

    private static class HolderClass {
        private final static SingletonHolder instance = new SingletonHolder();
    }

    public static SingletonHolder getInstance() {
        return HolderClass.instance;
    }

    public static void main(String args[]) {
        SingletonHolder s1, s2;
        s1 = SingletonHolder.getInstance();
        s2 = SingletonHolder.getInstance();
        System.out.println(s1 == s2);
    }
}
