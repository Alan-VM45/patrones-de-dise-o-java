package patrones.strategy;

public final class Demo {
    public static void main(String[] args) {
        Carrito carrito = new Carrito(new MercadoPago());
        comprobar("MercadoPago: 1250.0".equals(carrito.pagar(1250)), "estrategia inicial");
        carrito.setEstrategiaPago(new TarjetaCredito());
        comprobar("Tarjeta de credito: 1250.0".equals(carrito.pagar(1250)), "cambio de estrategia");
        System.out.println("Strategy: OK");
    }
    private static void comprobar(boolean condicion, String detalle) {
        if (!condicion) throw new AssertionError("Comprobacion fallida: " + detalle);
    }
}