package patrones.comportamiento.chain;

public abstract class Manejador {
    private Manejador siguiente;
    public Manejador setSiguiente(Manejador siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }
    public final String manejar(Solicitud solicitud) {
        System.out.println(nombre() + " recibe el pedido mayorista de $" + solicitud.getMonto() + ".");
        if (puedeResolver(solicitud)) {
            System.out.println(nombre() + " tiene autoridad para aprobarlo.");
            return nombre();
        }
        System.out.println(nombre() + " no tiene autoridad para ese monto; lo pasa al siguiente responsable.");
        if (siguiente == null) throw new IllegalArgumentException("Ningun responsable puede aprobar el pedido");
        return siguiente.manejar(solicitud);
    }
    protected abstract boolean puedeResolver(Solicitud solicitud);
    protected abstract String nombre();
}