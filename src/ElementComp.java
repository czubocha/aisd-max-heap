import java.util.Comparator;

public class ElementComp implements Comparator<Element> {

    @Override
    public int compare(Element arg0, Element arg1) {
        return arg0.priority.compareTo(arg1.priority);
    }

}
