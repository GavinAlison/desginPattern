package component;

// 抽象构件
public abstract class Component {
    //增加成员
    public abstract void add(Component c);

    //删除成员
    public abstract void remove(Component c);

    //获取成员
    public abstract Component getChild(int i);

    //业务方法
    public abstract void operation();


}
