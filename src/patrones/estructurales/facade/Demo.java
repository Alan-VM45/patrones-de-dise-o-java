package patrones.estructurales.facade;

public final class Demo {
    static final class Inventario {
        boolean hayExistencias(String isbn) { return "978-1".equals(isbn); }
        void reservar(String isbn) { System.out.println("Inventario: reservado " + isbn); }
    }
    static final class Pagos {
        boolean cobrar(String cliente, double total) {
            System.out.println("Pago: cobrados $" + total + " a " + cliente);
            return true;
        }
    }
    static final class Envio {
        void preparar(String cliente, String isbn) {
            System.out.println("Envio: preparado " + isbn + " para " + cliente);
        }
    }
    static final class CompraFacade {
        private final Inventario inventario = new Inventario();
        private final Pagos pagos = new Pagos();
        private final Envio envio = new Envio();

        String comprar(String cliente, String isbn, double precio) {
            if (!inventario.hayExistencias(isbn)) return "No hay existencias";
            inventario.reservar(isbn);
            if (!pagos.cobrar(cliente, precio)) return "Pago rechazado";
            envio.preparar(cliente, isbn);
            return "Compra confirmada";
        }
    }

    public static void main(String[] args) {
        String resultado = new CompraFacade().comprar("Sofia", "978-1", 420);
        if (!"Compra confirmada".equals(resultado)) throw new AssertionError("La compra debe completarse");
        System.out.println(resultado + ". El cliente uso una sola operacion para coordinar los servicios.");
    }
}