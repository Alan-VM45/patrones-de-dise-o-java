package patrones.comportamiento.strategy;

public final class TarjetaCredito implements EstrategiaPago {
    @Override public String procesar(double monto) { return "Tarjeta de credito: " + monto; }
}