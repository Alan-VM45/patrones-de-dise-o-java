package patrones.comportamiento.chain;

public final class Gerente extends Manejador {
    @Override protected boolean puedeResolver(Solicitud solicitud) { return solicitud.getMonto() <= 1000; }
    @Override protected String nombre() { return "Gerente"; }
}