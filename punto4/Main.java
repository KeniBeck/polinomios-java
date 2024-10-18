class Nodo {
    int fila;
    int columna;
    int valor;
    Nodo siguiente;

    public Nodo(int fila, int columna, int valor) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
        this.siguiente = null;
    }
}

class MatrizDispersa {
    private Nodo cabeza;

    public MatrizDispersa() {
        this.cabeza = null;
    }

    // Método para agregar un nodo en la lista enlazada (Forma 2 - F2)
    public void agregarElemento(int fila, int columna, int valor) {
        Nodo nuevoNodo = new Nodo(fila, columna, valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    // Método para convertir de tripleta a Forma 2 (lista enlazada)
    public static MatrizDispersa convertirTripletaALista(int[][] tripletas) {
        MatrizDispersa matrizF2 = new MatrizDispersa();

        // Recorrer las tripletas y agregar los elementos no nulos a la lista enlazada
        for (int i = 0; i < tripletas.length; i++) {
            int fila = tripletas[i][0];
            int columna = tripletas[i][1];
            int valor = tripletas[i][2];
            matrizF2.agregarElemento(fila, columna, valor);
        }
        return matrizF2;
    }

    // Método para mostrar la lista en Forma 2 (F2)
    public void mostrarF2() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println("Fila: " + actual.fila + ", Columna: " + actual.columna + ", Valor: " + actual.valor);
            actual = actual.siguiente;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Matriz dispersa representada como tripletas (fila, columna, valor)
        int[][] tripletas = {
            {0, 1, 5},
            {2, 0, 8},
            {3, 4, 12},
            {4, 2, 7}
        };

        // Convertir la matriz de tripletas a lista Forma 2 (F2)
        MatrizDispersa matrizF2 = MatrizDispersa.convertirTripletaALista(tripletas);

        // Mostrar la lista en Forma 2 (F2)
        System.out.println("Matriz en Forma 2 (Lista enlazada):");
        matrizF2.mostrarF2();
    }
}
