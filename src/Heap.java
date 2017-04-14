import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap {

    private ArrayList<Element> items;
    private ElementComp comp = new ElementComp();

    public Heap() {
        items = new ArrayList<Element>();
    }

    private void siftUp() {
        int i = items.size() - 1;
        while (i > 0) {
            int p = (i - 1) / 2;
            Element item = items.get(i);
            Element parent = items.get(p);
            if (comp.compare(item, parent) > 0) {
                items.set(i, parent);
                items.set(p, item);
                i = p;
            } else
                return;
        }
    }

    public void enqueue(Element item) {
        items.add(item);
        siftUp();
    }

    private void siftDown() {
        int k = 0;
        int l = 2 * k + 1;
        while (l < items.size()) {
            int max = l, r = l + 1;
            if (r < items.size())
                if (comp.compare(items.get(r), items.get(l)) > 0)
                    max++;
            if (comp.compare(items.get(k), items.get(max)) < 0) {
                swap(k, max);
                k = max;
                l = 2 * k + 1;
            } else
                return;
        }
    }

    private void swap(int arg0, int arg1) {
        Element temp = items.get(arg0);
        items.set(arg0, items.get(arg1));
        items.set(arg1, temp);
    }

    public Element dequeue() throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            return items.remove(0);
        }
        Element hold = items.get(0);
        items.set(0, items.remove(items.size() - 1));
        siftDown();
        return hold;
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();

    }

    public String toString() {
        return items.toString();
    }
}
