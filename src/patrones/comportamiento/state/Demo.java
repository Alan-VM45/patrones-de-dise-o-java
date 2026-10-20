package patrones.comportamiento.state;

public final class Demo {
    interface EstadoPedido {
        String nombre();
        EstadoPedido enviar();
        EstadoPedido entregar();
    }
    static final class Recibido implements EstadoPedido {
        public String nombre() { return "Recibido"; }
        public EstadoPedido enviar() { return new Enviado(); }
        public EstadoPedido entregar() { throw new IllegalStateException("Primero hay que enviar el pedido"); }
    }
    static final class Enviado implements EstadoPedido {
        public String nombre() { return "Enviado"; }
        public EstadoPedido enviar() { return this; }
        public EstadoPedido entregar() { return new Entregado(); }
    }
    static final class Entregado implements EstadoPedido {
        public String nombre() { return "Entregado"; }
        public EstadoPedido enviar() { throw new IllegalStateException("El pedido ya fue entregado"); }
        public EstadoPedido entregar() { return this; }
    }
    static final class Pedido {
        private EstadoPedido estado = new Recibido();
        void enviar() { estado = estado.enviar(); }
        void entregar() { estado = estado.entregar(); }
        String getEstado() { return estado.nombre(); }
    }

    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        System.out.println("Estado al confirmar la compra: " + pedido.getEstado());
        pedido.enviar();
        System.out.println("La tienda marca el paquete como enviado: " + pedido.getEstado());
        pedido.entregar();
        System.out.println("El cliente recibe el pedido: " + pedido.getEstado());
    }
}