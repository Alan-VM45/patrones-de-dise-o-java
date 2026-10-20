package patrones.estructurales.flyweight;

import java.util.HashMap;
import java.util.Map;

final class DatosCatalogo {
    private final String isbn;
    private final String titulo;
    private final String autor;

    DatosCatalogo(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    String describir() { return titulo + " de " + autor + " (ISBN " + isbn + ")"; }
}

final class FabricaCatalogo {
    private final Map<String, DatosCatalogo> libros = new HashMap<>();

    DatosCatalogo obtener(String isbn, String titulo, String autor) {
        if (!libros.containsKey(isbn)) libros.put(isbn, new DatosCatalogo(isbn, titulo, autor));
        return libros.get(isbn);
    }
}

final class Ejemplar {
    private final String codigoEjemplar;
    private final DatosCatalogo libro;

    Ejemplar(String codigoEjemplar, DatosCatalogo libro) { this.codigoEjemplar = codigoEjemplar; this.libro = libro; }

    String mostrar() { return codigoEjemplar + ": " + libro.describir(); }
    DatosCatalogo getLibro() { return libro; }
}

public final class Demo {
    public static void main(String[] args) {
        FabricaCatalogo fabrica = new FabricaCatalogo();
        Ejemplar primero = new Ejemplar("COPIA-01", fabrica.obtener("978-1", "Java para principiantes", "Ana Ruiz"));
        Ejemplar segundo = new Ejemplar("COPIA-02", fabrica.obtener("978-1", "Java para principiantes", "Ana Ruiz"));
        if (primero.getLibro() != segundo.getLibro()) throw new AssertionError("Los datos del libro deben compartirse");
        System.out.println(primero.mostrar());
        System.out.println(segundo.mostrar());
        System.out.println("Son dos ejemplares fisicos, pero comparten los mismos datos de catalogo: "
            + (primero.getLibro() == segundo.getLibro()));
    }
}