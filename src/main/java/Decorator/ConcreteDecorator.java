package Decorator;

public class ConcreteDecorator extends Decorator {


    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }

    // 添加的新的行为，新的功能
    public void addBehavior() {
        // 具体的实现
    }


}
