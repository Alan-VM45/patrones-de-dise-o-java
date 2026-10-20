package patrones.creacionales.prototype;

import java.util.ArrayList;
import java.util.List;

public final class Demo {
    static final class PlantillaPedido implements Cloneable {
        private final String cliente;
        private final List<String> libros;

        PlantillaPedido(String cliente, List<String> libros) {
            this.cliente = cliente;
            this.libros = new ArrayList<>(libros);
        }

        void agregarLibro(String libro) { libros.add(libro); }
        String resumen() { return cliente + " compra " + String.join(", ", libros); }

        public PlantillaPedido clone() {
            return new PlantillaPedido(cliente, libros);
        }
    }

    public static void main(String[] args) {
        PlantillaPedido original = new PlantillaPedido("Mateo", List.of("Java basico"));
        PlantillaPedido siguienteCompra = original.clone();
        siguienteCompra.agregarLibro("Patrones de diseno");
        System.out.println("Plantilla guardada: " + original.resumen());
        System.out.println("Pedido nuevo basado en la plantilla: " + siguienteCompra.resumen());
        System.out.println("La copia es independiente: " + (original != siguienteCompra));
    }
}