package patrones.strategy;

public final class MercadoPago implements EstrategiaPago {
    @Override public String procesar(double monto) { return "MercadoPago: " + monto; }
}