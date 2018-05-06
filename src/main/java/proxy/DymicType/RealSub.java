package proxy.DymicType;

public class RealSub implements AbstractSubject {

    @Override
    public void request() {
        System.out.println("real sub");
    }
}
