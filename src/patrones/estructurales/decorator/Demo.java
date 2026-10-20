package patrones.estructurales.decorator;

public final class Demo {
    interface CotizadorPedido { double total(); String descripcion(); }
    static final class Libros implements CotizadorPedido {
        public double total() { return 600; }
        public String descripcion() { return "libros"; }
    }
    abstract static class ExtraPedido implements CotizadorPedido {
        protected final CotizadorPedido pedido;
        ExtraPedido(CotizadorPedido pedido) { this.pedido = pedido; }
    }
    static final class EnvolturaRegalo extends ExtraPedido {
        EnvolturaRegalo(CotizadorPedido pedido) { super(pedido); }
        public double total() { return pedido.total() + 40; }
        public String descripcion() { return pedido.descripcion() + " + envoltura de regalo"; }
    }
    static final class EnvioUrgente extends ExtraPedido {
        EnvioUrgente(CotizadorPedido pedido) { super(pedido); }
        public double total() { return pedido.total() + 90; }
        public String descripcion() { return pedido.descripcion() + " + envio urgente"; }
    }

    public static void main(String[] args) {
        CotizadorPedido pedido = new Libros();
        System.out.println("Solo libros: $" + pedido.total());
        pedido = new EnvolturaRegalo(pedido);
        pedido = new EnvioUrgente(pedido);
        if (pedido.total() != 730) throw new AssertionError("Los extras deben sumarse al pedido");
        System.out.println("Pedido con " + pedido.descripcion() + ": $" + pedido.total());
        System.out.println("Cada decorador agrega un servicio y un costo sin cambiar los libros originales.");
    }
}