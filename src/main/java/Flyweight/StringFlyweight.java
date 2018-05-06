package Flyweight;

public class StringFlyweight {
    public static void main(String args[]) {
        String str1 = "abcd";
        String str2 = "abcd";
        String str3 = "ab" + "cd";
        String str4 = "ab";
        //会转换成StringBuilder对象， 再进行append(), 最后会转换成new String()对象
        str4 += "cd";
        // true
        System.out.println(str1 == str2);
        //true
        System.out.println(str1 == str3);
        // false
        System.out.println(str1 == str4);
    }
}
