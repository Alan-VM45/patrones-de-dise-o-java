package patrones.comportamiento.visitor;

interface Visitante {
    String visitarLibroImpreso(LibroImpreso libro);
    String visitarLibroDigital(LibroDigital libro);
}

interface Libro {
    String aceptar(Visitante visitante);
}

final class LibroImpreso implements Libro {
    private final String titulo;
    private final int paginas;

    LibroImpreso(String titulo, int paginas) { this.titulo = titulo; this.paginas = paginas; }
    String getTitulo() { return titulo; }
    int getPaginas() { return paginas; }
    public String aceptar(Visitante visitante) { return visitante.visitarLibroImpreso(this); }
}

final class LibroDigital implements Libro {
    private final String titulo;
    private final double megabytes;

    LibroDigital(String titulo, double megabytes) { this.titulo = titulo; this.megabytes = megabytes; }
    String getTitulo() { return titulo; }
    double getMegabytes() { return megabytes; }
    public String aceptar(Visitante visitante) { return visitante.visitarLibroDigital(this); }
}

final class GeneradorFichaCatalogo implements Visitante {
    public String visitarLibroImpreso(LibroImpreso libro) {
        return libro.getTitulo() + " | impreso | " + libro.getPaginas() + " paginas";
    }
    public String visitarLibroDigital(LibroDigital libro) {
        return libro.getTitulo() + " | digital | " + libro.getMegabytes() + " MB";
    }
}

public final class Demo {
    public static void main(String[] args) {
        Libro[] libros = {new LibroImpreso("Java practico", 320), new LibroDigital("Patrones GoF", 4.5)};
        Visitante fichas = new GeneradorFichaCatalogo();
        System.out.println("El visitante genera fichas distintas sin modificar las clases de libro:");
        for (Libro libro : libros) System.out.println("- " + libro.aceptar(fichas));
    }
}