package patrones.facade;

import java.util.Objects;

public final class CineFacade {
    private final Luces luces;
    private final Proyector proyector;
    private final Audio audio;
    private String peliculaActual;
    public CineFacade(Luces luces, Proyector proyector, Audio audio) {
        this.luces = Objects.requireNonNull(luces, "luces");
        this.proyector = Objects.requireNonNull(proyector, "proyector");
        this.audio = Objects.requireNonNull(audio, "audio");
    }
    public void verPelicula(String pelicula) {
        peliculaActual = Objects.requireNonNull(pelicula, "pelicula");
        luces.atenuar();
        proyector.encender();
        audio.fijarVolumen(80);
    }
    public String getPeliculaActual() { return peliculaActual; }
}