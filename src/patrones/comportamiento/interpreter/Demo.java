package patrones.comportamiento.interpreter;

interface Expresion {
    boolean evaluar(Libro libro);
}

final class Libro {
    private final String titulo;
    private final double precio;

    Libro(String titulo, double precio) { this.titulo = titulo; this.precio = precio; }
    String getTitulo() { return titulo; }
    double getPrecio() { return precio; }
}

final class PrecioMaximo implements Expresion {
    private final double maximo;
    PrecioMaximo(double maximo) { this.maximo = maximo; }
    public boolean evaluar(Libro libro) { return libro.getPrecio() <= maximo; }
}

final class TituloContiene implements Expresion {
    private final String palabra;
    TituloContiene(String palabra) { this.palabra = palabra.toLowerCase(); }
    public boolean evaluar(Libro libro) { return libro.getTitulo().toLowerCase().contains(palabra); }
}

final class Y implements Expresion {
    private final Expresion izquierda;
    private final Expresion derecha;

    Y(Expresion izquierda, Expresion derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public boolean evaluar(Libro libro) { return izquierda.evaluar(libro) && derecha.evaluar(libro); }
}

public final class Demo {
    public static void main(String[] args) {
        Expresion busqueda = new Y(new PrecioMaximo(400), new TituloContiene("java"));
        Libro[] catalogo = {new Libro("Java practico", 350), new Libro("Cocina facil", 250),
                new Libro("Java avanzado", 600)};
        System.out.println("Busqueda interpretada: libros con 'Java' que cuesten hasta $400");
        for (Libro libro : catalogo) {
            if (busqueda.evaluar(libro)) System.out.println("Coincidencia: " + libro.getTitulo() + " ($" + libro.getPrecio() + ")");
        }
        System.out.println("Cada regla se evalua sobre los libros y se combina con AND.");
    }
}