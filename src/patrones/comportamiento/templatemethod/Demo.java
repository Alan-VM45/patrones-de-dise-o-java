package patrones.comportamiento.templatemethod;

abstract class PreparadorPedido {
    final String procesar() {
        return "Validar pago, " + prepararProducto() + ", " + entregarProducto();
    }

    protected abstract String prepararProducto();
    protected abstract String entregarProducto();
}

final class PedidoFisico extends PreparadorPedido {
    protected String prepararProducto() { return "empaquetar libro"; }
    protected String entregarProducto() { return "enviar paquete"; }
}

final class PedidoDigital extends PreparadorPedido {
    protected String prepararProducto() { return "generar enlace de descarga"; }
    protected String entregarProducto() { return "enviar enlace por correo"; }
}

public final class Demo {
    public static void main(String[] args) {
        System.out.println("Pedido de libro fisico: " + new PedidoFisico().procesar());
        System.out.println("Pedido de libro digital: " + new PedidoDigital().procesar());
        System.out.println("Ambos siguen el mismo flujo; cada tipo prepara y entrega de forma distinta.");
    }
}