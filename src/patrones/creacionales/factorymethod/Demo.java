package patrones.creacionales.factorymethod;

public final class Demo {
    interface Recibo { String generar(String numeroPedido, double total); }
    static final class ReciboPDF implements Recibo {
        public String generar(String numero, double total) { return "PDF pedido " + numero + " - Total: $" + total; }
    }
    static final class ReciboTexto implements Recibo {
        public String generar(String numero, double total) { return "Pedido " + numero + " | Total $" + total; }
    }
    abstract static class GeneradorRecibo {
        protected abstract Recibo crearRecibo();
        String emitir(String numero, double total) { return crearRecibo().generar(numero, total); }
    }
    static final class GeneradorPDF extends GeneradorRecibo {
        protected Recibo crearRecibo() { return new ReciboPDF(); }
    }
    static final class GeneradorTexto extends GeneradorRecibo {
        protected Recibo crearRecibo() { return new ReciboTexto(); }
    }

    public static void main(String[] args) {
        System.out.println("Recibo para el mismo pedido, generado por cada canal:");
        System.out.println(new GeneradorPDF().emitir("A-104", 650));
        System.out.println(new GeneradorTexto().emitir("A-104", 650));
    }
}