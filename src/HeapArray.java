import java.util.Arrays;
import java.util.NoSuchElementException;

public class HeapArray {

    Element[] items;
    int size;
    private ElementComp comp = new ElementComp();

    public HeapArray() {
        items = new Element[10];
    }

    public HeapArray(int size) {
        items = new Element[size];
    }

    public HeapArray(Element tab[]) {
        items = tab;
        size = tab.length;
        construct();
    }

    private void siftUp() {
        int i = size - 1;
        while (i > 0) {
            int p = (i - 1) / 2;
            Element item = items[i];
            Element parent = items[p];
            if (comp.compare(item, parent) > 0) {
                items[i] = parent;
                items[p] = item;
                i = p;
            } else
                return;
        }
    }

    public void enqueue(Element item) {
        items[size] = item;
        if (items.length == ++size)
            items = Arrays.copyOf(items, 2 * size);
        siftUp();
    }

    private void siftDown(int k) {
        int l = 2 * k + 1;
        while (l < size) {
            int max = l, r = l + 1;
            if (r < size)
                if (comp.compare(items[r], items[l]) > 0)
                    max++;
            if (comp.compare(items[k], items[max]) < 0) {
                swap(k, max);
                k = max;
                l = 2 * k + 1;
            } else
                return;
        }
    }

    private void swap(int arg0, int arg1) {
        Element temp = items[arg0];
        items[arg0] = items[arg1];
        items[arg1] = temp;
    }

    public Element dequeue() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            Element hold = items[0];
            items[0] = null;
            size--;
            return hold;
        }
        Element hold = items[0];
        items[0] = items[size - 1];
        items[size - 1] = null;
        if (items.length == 2 * size--)
            items = Arrays.copyOf(items, size + 1);
        siftDown(0);
        return hold;
    }

    public void construct() {
        construct(0);
    }

    private void construct(int index) {
        if (2 * index + 1 <= size / 2)
            construct(2 * index + 1);
        if (2 * index + 2 <= size / 2)
            construct(2 * index + 2);
        siftDown(index);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public String toString() {
        return Arrays.toString(items);
    }
}
