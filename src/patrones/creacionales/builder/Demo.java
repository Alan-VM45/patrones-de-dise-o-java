package patrones.creacionales.builder;

public final class Demo {
    static final class Pedido {
        private final String cliente;
        private final String direccion;
        private final String libro;
        private final boolean envolverParaRegalo;

        Pedido(String cliente, String direccion, String libro, boolean envolverParaRegalo) {
            this.cliente = cliente;
            this.direccion = direccion;
            this.libro = libro;
            this.envolverParaRegalo = envolverParaRegalo;
        }

        String resumen() {
            return "Pedido para " + cliente + ": " + libro + ", envio a " + direccion
                    + (envolverParaRegalo ? ", envuelto para regalo" : "");
        }
    }

    static final class PedidoBuilder {
        private String cliente;
        private String direccion;
        private String libro;
        private boolean envolverParaRegalo;

        PedidoBuilder cliente(String cliente) { this.cliente = cliente; return this; }
        PedidoBuilder direccion(String direccion) { this.direccion = direccion; return this; }
        PedidoBuilder libro(String libro) { this.libro = libro; return this; }
        PedidoBuilder envolverParaRegalo() { this.envolverParaRegalo = true; return this; }

        Pedido construir() {
            if (cliente == null || direccion == null || libro == null) {
                throw new IllegalStateException("El pedido necesita cliente, direccion y libro");
            }
            return new Pedido(cliente, direccion, libro, envolverParaRegalo);
        }
    }

    public static void main(String[] args) {
        Pedido pedido = new PedidoBuilder()
                .cliente("Lucia")
                .direccion("Av. Central 123")
                .libro("Java para principiantes")
                .envolverParaRegalo()
                .construir();
        System.out.println("El cliente elige solo las opciones que necesita:");
        System.out.println(pedido.resumen());
    }
}