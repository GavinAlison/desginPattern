package bridger;

//桥接模式
public class Bridge {
    public static void main(String[] args) {
        ConcreteImplementor c = new ConcreteImplementor();
        RefindAbstraction refind = new RefindAbstraction(c);
        refind.operation();
    }

}




