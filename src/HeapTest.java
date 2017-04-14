public class HeapTest {

    public static void main(String[] args) {

        Heap heap = new Heap();
        heap.enqueue(new Element(1d, "Trol"));
        heap.enqueue(new Element(2d, "Trol"));
        heap.enqueue(new Element(3d, "Trol"));
        heap.enqueue(new Element(4d, "Trol"));
        heap.enqueue(new Element(5d, "Trol"));
        heap.dequeue();
        System.out.println(heap);

        HeapArray heapArray = new HeapArray(5);
        heapArray.enqueue(new Element(1d, "Trol"));
        heapArray.enqueue(new Element(2d, "Trol"));
        heapArray.enqueue(new Element(3d, "Trol"));
        heapArray.enqueue(new Element(4d, "Trol"));
        heapArray.enqueue(new Element(5d, "Trol"));
        heapArray.dequeue();
        System.out.println(heapArray);

        Element tablica[] = {new Element(1d, "Trol"), new Element(2d, "Trol"), new Element(3d, "Trol"),
                new Element(4d, "Trol"), new Element(5d, "Trol")};
        HeapArray heapFromArray = new HeapArray(tablica);
        heapFromArray.dequeue();
        System.out.println(heapFromArray);
    }
}
