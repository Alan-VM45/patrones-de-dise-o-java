package patrones.estructurales.facade;

public final class Proyector {
    private boolean encendido;
    public void encender() { encendido = true; }
    public boolean estaEncendido() { return encendido; }
}