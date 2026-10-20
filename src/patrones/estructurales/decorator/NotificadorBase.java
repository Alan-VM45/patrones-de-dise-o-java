package patrones.estructurales.decorator;

public final class NotificadorBase implements Notificador {
    @Override
    public String enviar(String mensaje) { return "Email: " + mensaje; }
}