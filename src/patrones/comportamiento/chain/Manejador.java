package patrones.comportamiento.chain;

public abstract class Manejador {
    private Manejador siguiente;
    public Manejador setSiguiente(Manejador siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }
    public final String manejar(Solicitud solicitud) {
        System.out.println(nombre() + " recibe la solicitud de $" + solicitud.getMonto() + ".");
        if (puedeResolver(solicitud)) {
            System.out.println(nombre() + " puede resolverla y la aprueba.");
            return nombre();
        }
        System.out.println(nombre() + " no puede resolverla; la pasa al siguiente responsable.");
        if (siguiente == null) throw new IllegalArgumentException("Ningun responsable puede resolver la solicitud");
        return siguiente.manejar(solicitud);
    }
    protected abstract boolean puedeResolver(Solicitud solicitud);
    protected abstract String nombre();
}