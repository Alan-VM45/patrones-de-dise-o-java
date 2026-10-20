package patrones.comportamiento.memento;

public final class Demo {
    static final class EstadoCarrito {
        private final String contenido;
        EstadoCarrito(String contenido) { this.contenido = contenido; }
    }
    static final class Carrito {
        private String contenido = "";
        void agregar(String libro) { contenido = contenido.isEmpty() ? libro : contenido + ", " + libro; }
        EstadoCarrito guardar() { return new EstadoCarrito(contenido); }
        void restaurar(EstadoCarrito estado) { contenido = estado.contenido; }
        String getContenido() { return contenido; }
    }

    public static void main(String[] args) {
        Carrito carrito = new Carrito();
        carrito.agregar("Java practico");
        EstadoCarrito guardado = carrito.guardar();
        System.out.println("Carrito guardado: " + carrito.getContenido());
        carrito.agregar("Libro agregado por error");
        System.out.println("Despues de agregar otro libro: " + carrito.getContenido());
        carrito.restaurar(guardado);
        if (!"Java practico".equals(carrito.getContenido())) throw new AssertionError("No se restauro el carrito");
        System.out.println("Al restaurar el estado guardado: " + carrito.getContenido());
    }
}