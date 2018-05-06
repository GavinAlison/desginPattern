package State;

// 环境类
public class Context {
    // 维护一个抽象状态对象的引用
    private State state;
    private double bill;

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    /**
     * 环境处理函数，调用状态实例行为 完成业务逻辑<br/>
     * 根据不同的状态实例引用  在不同状态下处理不同的行为
     */
    public void Handle() {
        checkState();
        state.Behavior();
    }

    /**
     * 检查环境状态:状态的改变/切换 在环境类中实现
     */
    private void checkState() {
        if (bill >= 0.00) {
            setState(new ConcreteStateA());
        } else {
            setState(new ConcreteStateB());
        }
    }


}
