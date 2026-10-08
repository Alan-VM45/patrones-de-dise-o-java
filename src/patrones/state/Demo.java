package patrones.state;

public final class Demo {
    public static void main(String[] args) {
        Reproductor reproductor = new Reproductor();
        comprobar("Pausado".equals(reproductor.getEstado()), "estado inicial");
        reproductor.presionarPlay();
        comprobar("Sonando".equals(reproductor.getEstado()), "play");
        reproductor.presionarPausa();
        comprobar("Pausado".equals(reproductor.getEstado()), "pausa");
        System.out.println("State: OK");
    }
    private static void comprobar(boolean condicion, String detalle) {
        if (!condicion) throw new AssertionError("Comprobacion fallida: " + detalle);
    }
}