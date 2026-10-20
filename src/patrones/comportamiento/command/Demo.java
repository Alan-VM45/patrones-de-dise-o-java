package patrones.comportamiento.command;

interface Comando {
    void ejecutar();
}

final class Carrito {
    private final java.util.List<String> libros = new java.util.ArrayList<>();
    void agregar(String libro) { libros.add(libro); }
    java.util.List<String> getLibros() { return libros; }
}

final class AgregarLibro implements Comando {
    private final Carrito carrito;
    private final String libro;

    AgregarLibro(Carrito carrito, String libro) { this.carrito = carrito; this.libro = libro; }

    public void ejecutar() { carrito.agregar(libro); }
}

final class BotonAgregarAlCarrito {
    private final Comando comando;

    BotonAgregarAlCarrito(Comando comando) { this.comando = comando; }

    void pulsar() { comando.ejecutar(); }
}

public final class Demo {
    public static void main(String[] args) {
        Carrito carrito = new Carrito();
        Comando agregar = new AgregarLibro(carrito, "Java practico");
        BotonAgregarAlCarrito boton = new BotonAgregarAlCarrito(agregar);
        System.out.println("Antes de pulsar, el carrito contiene: " + carrito.getLibros());
        boton.pulsar();
        if (!carrito.getLibros().contains("Java practico")) throw new AssertionError("El comando debe agregar el libro");
        System.out.println("Despues de pulsar Agregar al carrito: " + carrito.getLibros());
        System.out.println("El boton ejecuta el comando sin necesitar saber como se modifica el carrito.");
    }
}