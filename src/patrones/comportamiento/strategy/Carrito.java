package patrones.comportamiento.strategy;

import java.util.Objects;

public final class Carrito {
    private EstrategiaPago estrategiaPago;
    public Carrito(EstrategiaPago estrategiaPago) {
        this.estrategiaPago = Objects.requireNonNull(estrategiaPago, "estrategiaPago");
    }
    public void setEstrategiaPago(EstrategiaPago estrategiaPago) {
        this.estrategiaPago = Objects.requireNonNull(estrategiaPago, "estrategiaPago");
    }
    public String pagar(double monto) {
        if (!Double.isFinite(monto) || monto < 0) throw new IllegalArgumentException("Monto no valido");
        return estrategiaPago.procesar(monto);
    }
}