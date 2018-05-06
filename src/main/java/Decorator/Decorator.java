package Decorator;

// 注意是实现抽象构件接口，以便实现相应的方法，在对应的方法里添加新的功能
public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        //调用原有业务方法
        component.operation();
    }
}
