package patrones.comportamiento.memento;

public final class Memento {
    private final String estado;
    Memento(String estado) { this.estado = estado; }
    String getEstado() { return estado; }
}