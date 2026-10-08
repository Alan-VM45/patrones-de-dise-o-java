package patrones.chain;

public final class Director extends Manejador {
    @Override protected boolean puedeResolver(Solicitud solicitud) { return true; }
    @Override protected String nombre() { return "Director"; }
}