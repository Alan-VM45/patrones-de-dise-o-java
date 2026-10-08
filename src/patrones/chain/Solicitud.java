package patrones.chain;

public final class Solicitud {
    private final int monto;
    public Solicitud(int monto) {
        if (monto < 0) throw new IllegalArgumentException("El monto no puede ser negativo");
        this.monto = monto;
    }
    public int getMonto() { return monto; }
}