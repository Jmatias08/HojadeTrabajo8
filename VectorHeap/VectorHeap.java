import java.util.ArrayList;

/**
 * Implementación de una cola de prioridad usando un Heap (min-heap).
 * @param <E> tipo de dato comparable
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    private ArrayList<E> data;

    public VectorHeap() {
        data = new ArrayList<>();
    }

    /**
     * Inserta un elemento en la cola
     */
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Remueve el elemento con mayor prioridad
     */
    public E remove() {
        if (data.isEmpty()) return null;

        E min = data.get(0);
        E last = data.remove(data.size() - 1);

        if (!data.isEmpty()) {
            data.set(0, last);
            percolateDown(0);
        }

        return min;
    }

    /**
     * Verifica si está vacío
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (data.get(index).compareTo(data.get(parent)) >= 0) break;

            swap(index, parent);
            index = parent;
        }
    }

    private void percolateDown(int index) {
        int size = data.size();

        while (2 * index + 1 < size) {
            int child = 2 * index + 1;

            if (child + 1 < size &&
                data.get(child + 1).compareTo(data.get(child)) < 0) {
                child++;
            }

            if (data.get(index).compareTo(data.get(child)) <= 0) break;

            swap(index, child);
            index = child;
        }
    }

    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}