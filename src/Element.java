public class Element {

    Double priority;
    String data;

    public Element(Double priority, String data) {
        this.priority = priority;
        this.data = data;
    }

    @Override
    public String toString() {
        return priority.toString();
    }

}
