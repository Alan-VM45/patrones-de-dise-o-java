package patrones.comportamiento.state;

public final class Sonando implements EstadoReproductor {
    @Override public void presionarPlay(Reproductor reproductor) { }
    @Override public void presionarPausa(Reproductor reproductor) { reproductor.cambiarEstado(new Pausado()); }
    @Override public String nombre() { return "Sonando"; }
}