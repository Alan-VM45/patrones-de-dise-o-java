package patrones.facade;

public final class Audio {
    private int volumen;
    public void fijarVolumen(int volumen) {
        if (volumen < 0 || volumen > 100) throw new IllegalArgumentException("Volumen fuera de rango");
        this.volumen = volumen;
    }
    public int getVolumen() { return volumen; }
}