import java.util.ArrayList;
import java.util.List;

public class minHeap<T extends Comparable<T>> {
    private List<T> heap;

    public minHeap() {
        this.heap = new ArrayList<>();
    }

    // INSERTAR
    public void insertar(T valor) {
        heap.add(valor);                // Insertar al final
        upHeapify(heap.size() - 1);     // Restaurar propiedad del heap
    }

    // ELIMINAR MIN
    public T eliminarMin() {
        if (heap.isEmpty()) return null;

        T min = heap.get(0);
        T ultimo = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, ultimo);
            downHeapify(0);
        }
        return min;
    }

    // PEEK
    public T peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    // HEAPIFY COMPLETO
    public void heapify(List<T> elementos) {
        heap = new ArrayList<>(elementos);

        for (int i = (heap.size() - 1) / 2; i >= 0; i--) {
            downHeapify(i);
        }
    }

    // UP HEAPIFY
    private void upHeapify(int i) {
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (heap.get(i).compareTo(heap.get(padre)) < 0) {
                swap(i, padre);
                i = padre;
            } else {
                break;
            }
        }
    }

    // DOWN HEAPIFY
    private void downHeapify(int i) {
        int size = heap.size();

        while (true) {
            int izq = 2 * i + 1;
            int der = 2 * i + 2;
            int menor = i;

            if (izq < size && heap.get(izq).compareTo(heap.get(menor)) < 0) {
                menor = izq;
            }

            if (der < size && heap.get(der).compareTo(heap.get(menor)) < 0) {
                menor = der;
            }

            if (menor != i) {
                swap(i, menor);
                i = menor;
            } else {
                break;
            }
        }
    }

    // SWAP
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // MOSTRAR
    public void imprimir() {
        System.out.println(heap);
    }

    // GET LISTA COMPLETa
    public List<T> getHeap() {
        return heap;
    }
}
