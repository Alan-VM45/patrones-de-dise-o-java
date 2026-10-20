package patrones.comportamiento.state;

public final class Pausado implements EstadoReproductor {
    @Override public void presionarPlay(Reproductor reproductor) { reproductor.cambiarEstado(new Sonando()); }
    @Override public void presionarPausa(Reproductor reproductor) { }
    @Override public String nombre() { return "Pausado"; }
}