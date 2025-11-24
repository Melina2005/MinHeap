import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static minHeap<Integer> heap = new minHeap<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion;
        do {
            System.out.println("\n--- MENU MIN-HEAP ---");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar mínimo");
            System.out.println("3. Ver mínimo");
            System.out.println("4. Heapify");
            System.out.println("5. Imprimir heap");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un número: ");
                    int valor = sc.nextInt();
                    heap.insertar(valor);
                    break;
                case 2:
                    Integer eliminado = heap.eliminarMin();
                    if (eliminado == null) {
                        System.out.println("Heap vacío.");
                    } else {
                        System.out.println("Elemento eliminado: " + eliminado);
                    }
                    break;
                case 3:
                    Integer min = heap.peek();
                    if (min == null) {
                        System.out.println("Heap vacío.");
                    } else {
                        System.out.println("Mínimo actual: " + min);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese cantidad de elementos: ");
                    int n = sc.nextInt();

                    List<Integer> lista = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        lista.add(sc.nextInt());
                    }

                    heap.heapify(lista);
                    System.out.println("Heap generado correctamente.");
                    break;
                case 5:
                    heap.imprimir();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }
}
