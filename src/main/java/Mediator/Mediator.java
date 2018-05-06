package Mediator;

import java.util.ArrayList;

public abstract class Mediator {
    protected ArrayList colleagues;

    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }

    public abstract void operation();

}

abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void method1();

    public abstract void method2();
}

class ConcreteMediator extends Mediator {
    public void operation() {
        // ......
        ((Colleague) (colleagues.get(0))).method1();
        //......
    }
}

class ConcreteColleague extends Colleague {
    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }

    public void method1() {
        //......
    }

    public void method2() {
        mediator.operation();
    }
}