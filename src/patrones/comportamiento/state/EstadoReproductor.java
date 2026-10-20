package patrones.comportamiento.state;

public interface EstadoReproductor {
    void presionarPlay(Reproductor reproductor);
    void presionarPausa(Reproductor reproductor);
    String nombre();
}