package Flyweight;

import java.util.HashMap;

public class FlyweightFactory {
    private static HashMap flyweights = new HashMap();

    public static Flyweight getFlyweight(String key) {
        if (flyweights.containsKey(key)) {
            return (Flyweight) flyweights.get(key);
        } else {
            Flyweight fw = new Flyweight("123");
            flyweights.put(key, fw);
            return fw;
        }
    }
}
