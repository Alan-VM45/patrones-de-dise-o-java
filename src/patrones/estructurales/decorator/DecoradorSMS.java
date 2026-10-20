package patrones.estructurales.decorator;

import java.util.Objects;

public final class DecoradorSMS implements Notificador {
    private final Notificador envoltorio;
    public DecoradorSMS(Notificador envoltorio) {
        this.envoltorio = Objects.requireNonNull(envoltorio, "envoltorio");
    }
    @Override
    public String enviar(String mensaje) {
        return envoltorio.enviar(mensaje) + " | SMS: " + mensaje;
    }
}