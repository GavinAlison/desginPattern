package facade;

// 外观类， 封装各个子系统，提供统一接口
public class Facade {
    private SubSystemA subA = new SubSystemA();
    private SubSystemB subB = new SubSystemB();
    private SubSystemC subc = new SubSystemC();

    public void methhod() {
        subA.methodA();
        subB.methodB();
        subc.methodC();
    }
}
