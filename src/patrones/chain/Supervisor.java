package patrones.chain;

public final class Supervisor extends Manejador {
    @Override protected boolean puedeResolver(Solicitud solicitud) { return solicitud.getMonto() <= 100; }
    @Override protected String nombre() { return "Supervisor"; }
}