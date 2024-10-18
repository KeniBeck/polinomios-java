import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

// Clase para representar un término del polinomio
class Termino {
    int coeficiente;
    int exponente;

    Termino(int coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }

    @Override
    public String toString() {
        return coeficiente + "x^" + exponente;
    }
}

// Clase para representar un polinomio en Forma 2
class PolinomioForma2 {
    List<Termino> terminos;

    PolinomioForma2() {
        this.terminos = new ArrayList<>();
    }

    void agregarTermino(int coeficiente, int exponente) {
        terminos.add(new Termino(coeficiente, exponente));
    }

    void eliminarTerminosMultiploDe3() {
        terminos.removeIf(t -> t.coeficiente % 3 == 0);
    }

    @Override
    public String toString() {
        return terminos.toString();
    }
}

// Clase para representar un polinomio en Forma 3 (similar a Forma 2 para simplicidad)
class PolinomioForma3 extends PolinomioForma2 {
    // Puede tener métodos adicionales o diferentes representaciones
}

// Clase para operaciones con polinomios
class OperacionesPolinomios {
    static PolinomioForma2 sumarPolinomios(PolinomioForma2 p2, PolinomioForma3 p3) {
        PolinomioForma2 resultado = new PolinomioForma2();
        Map<Integer, Integer> mapa = new HashMap<>();

        // Agregar términos del primer polinomio
        for (Termino t : p2.terminos) {
            mapa.put(t.exponente, mapa.getOrDefault(t.exponente, 0) + t.coeficiente);
        }

        // Agregar términos del segundo polinomio
        for (Termino t : p3.terminos) {
            mapa.put(t.exponente, mapa.getOrDefault(t.exponente, 0) + t.coeficiente);
        }

        // Crear el polinomio resultante
        for (Map.Entry<Integer, Integer> entry : mapa.entrySet()) {
            resultado.agregarTermino(entry.getValue(), entry.getKey());
        }

        // Ordenar los términos por exponente en orden descendente
        Collections.sort(resultado.terminos, new Comparator<Termino>() {
            @Override
            public int compare(Termino t1, Termino t2) {
                return Integer.compare(t2.exponente, t1.exponente);
            }
        });

        return resultado;
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {
        PolinomioForma2 p2 = new PolinomioForma2();
        p2.agregarTermino(3, 4);
        p2.agregarTermino(5, 2);
        p2.agregarTermino(2, 0);

        PolinomioForma3 p3 = new PolinomioForma3();
        p3.agregarTermino(6, 3);
        p3.agregarTermino(4, 2);
        p3.agregarTermino(1, 0);

        // Mostrar polinomios originales
        System.out.println("Polinomio en Forma 2: " + p2);
        System.out.println("Polinomio en Forma 3: " + p3);

        // Sumar los polinomios
        PolinomioForma2 suma = OperacionesPolinomios.sumarPolinomios(p2, p3);
        System.out.println("Suma de los polinomios: " + suma);

        // Eliminar términos con coeficiente múltiplo de 3
        suma.eliminarTerminosMultiploDe3();
        System.out.println("Polinomio resultante: " + suma);
    }
}