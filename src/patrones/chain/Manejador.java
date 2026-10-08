package patrones.chain;

public abstract class Manejador {
    private Manejador siguiente;
    public Manejador setSiguiente(Manejador siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }
    public final String manejar(Solicitud solicitud) {
        if (puedeResolver(solicitud)) return nombre();
        if (siguiente == null) throw new IllegalArgumentException("Ningun responsable puede resolver la solicitud");
        return siguiente.manejar(solicitud);
    }
    protected abstract boolean puedeResolver(Solicitud solicitud);
    protected abstract String nombre();
}