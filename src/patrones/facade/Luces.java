package patrones.facade;

public final class Luces {
    private boolean tenues;
    public void atenuar() { tenues = true; }
    public boolean estanTenues() { return tenues; }
}