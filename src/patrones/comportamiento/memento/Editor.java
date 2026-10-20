package patrones.comportamiento.memento;

public final class Editor {
    private String texto = "";
    public void escribir(String texto) { this.texto = texto; }
    public Memento guardar() { return new Memento(texto); }
    public void restaurar(Memento memento) {
        if (memento == null) throw new IllegalArgumentException("El memento no puede ser nulo");
        texto = memento.getEstado();
    }
    public String getTexto() { return texto; }
}