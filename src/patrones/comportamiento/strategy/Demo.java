package patrones.comportamiento.strategy;

public final class Demo {
    public static void main(String[] args) {
        Carrito carrito = new Carrito(new MercadoPago());
        String pagoMercadoPago = carrito.pagar(1250);
        comprobar("MercadoPago: 1250.0".equals(pagoMercadoPago), "estrategia inicial");
        System.out.println("Se paga $1250 usando MercadoPago: " + pagoMercadoPago);
        carrito.setEstrategiaPago(new TarjetaCredito());
        String pagoTarjeta = carrito.pagar(1250);
        comprobar("Tarjeta de credito: 1250.0".equals(pagoTarjeta), "cambio de estrategia");
        System.out.println("Se cambia la estrategia y se paga con tarjeta: " + pagoTarjeta);
    }
    private static void comprobar(boolean condicion, String detalle) {
        if (!condicion) throw new AssertionError("Comprobacion fallida: " + detalle);
    }
}