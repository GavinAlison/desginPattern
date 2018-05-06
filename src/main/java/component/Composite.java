package component;

import java.util.ArrayList;

public class Composite extends Component {
    private ArrayList<Component> list = new ArrayList<Component>();

    public void add(Component c) {
        list.add(c);
    }

    public void remove(Component c) {
        list.remove(c);
    }

    public Component getChild(int i) {
        return (Component) list.get(i);
    }

    public void operation() {
        for (Object obj : list) {
            ((Component) obj).operation();
        }
    }
}