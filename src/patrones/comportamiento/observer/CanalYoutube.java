package patrones.comportamiento.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CanalYoutube {
    private final List<Observador> suscriptores = new ArrayList<>();
    public void suscribir(Observador observador) { suscriptores.add(Objects.requireNonNull(observador, "observador")); }
    public void cancelarSuscripcion(Observador observador) { suscriptores.remove(observador); }
    public void subirVideo(String titulo) {
        for (Observador suscriptor : List.copyOf(suscriptores)) suscriptor.actualizar(titulo);
    }
}