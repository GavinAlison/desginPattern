package State;

// 具体的状态子类A
public class ConcreteStateA extends State {

    @Override
    public void Behavior() {
        System.out.println("手机在未欠费停机状态下, 能正常拨打电话");
    }
}
