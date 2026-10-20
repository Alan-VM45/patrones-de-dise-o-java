package patrones.estructurales.composite;

import java.util.ArrayList;
import java.util.List;

interface ElementoCatalogo {
    String nombre();
    double valor();
}

final class Producto implements ElementoCatalogo {
    private final String nombre;
    private final double precio;

    Producto(String nombre, double precio) { this.nombre = nombre; this.precio = precio; }

    public String nombre() { return nombre; }
    public double valor() { return precio; }
}

final class Caja implements ElementoCatalogo {
    private final List<ElementoCatalogo> elementos = new ArrayList<>();

    void agregar(ElementoCatalogo elemento) { elementos.add(elemento); }
    public String nombre() { return "Categoria de libros"; }

    public double valor() {
        double total = 0;
        for (ElementoCatalogo elemento : elementos) total += elemento.valor();
        return total;
    }
}

public final class Demo {
    public static void main(String[] args) {
        Caja programacion = new Caja();
        programacion.agregar(new Producto("Java practico", 300));
        Caja ciencias = new Caja();
        ciencias.agregar(new Producto("Fisica para todos", 250));
        Caja catalogo = new Caja();
        catalogo.agregar(programacion);
        catalogo.agregar(ciencias);
        if (catalogo.valor() != 550) throw new AssertionError("Total del catalogo");
        System.out.println("La categoria de programacion vale $" + programacion.valor() + ".");
        System.out.println("La categoria de ciencias vale $" + ciencias.valor() + ".");
        System.out.println("El catalogo puede sumar categorias completas: $" + catalogo.valor() + ".");
    }
}