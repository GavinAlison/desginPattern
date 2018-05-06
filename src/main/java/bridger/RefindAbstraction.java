package bridger;

public class RefindAbstraction extends Abstraction {
    public RefindAbstraction(Implementor impl) {
        super(impl);
    }

    @Override
    public void operation() {
        super.impl.operationImpl();
    }
}