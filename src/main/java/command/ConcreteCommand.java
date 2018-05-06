package command;

public class ConcreteCommand extends Command {

    //维持一个对请求接收者对象的引用
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //调用请求接收者的业务处理方法action()
        receiver.action();
    }
}
