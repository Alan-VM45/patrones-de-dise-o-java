package patrones.comportamiento.state;

public final class Reproductor {
    private EstadoReproductor estado = new Pausado();
    public void presionarPlay() { estado.presionarPlay(this); }
    public void presionarPausa() { estado.presionarPausa(this); }
    public void cambiarEstado(EstadoReproductor estado) {
        if (estado == null) throw new IllegalArgumentException("El estado no puede ser nulo");
        this.estado = estado;
    }
    public String getEstado() { return estado.nombre(); }
}