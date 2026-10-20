package patrones.comportamiento.state;

public final class Demo {
    public static void main(String[] args) {
        Reproductor reproductor = new Reproductor();
        comprobar("Pausado".equals(reproductor.getEstado()), "estado inicial");
        System.out.println("Estado inicial: " + reproductor.getEstado());
        reproductor.presionarPlay();
        comprobar("Sonando".equals(reproductor.getEstado()), "play");
        System.out.println("Al presionar Play: " + reproductor.getEstado());
        reproductor.presionarPausa();
        comprobar("Pausado".equals(reproductor.getEstado()), "pausa");
        System.out.println("Al presionar Pausa: " + reproductor.getEstado());
        System.out.println("La misma accion cambia segun el estado actual del reproductor.");
    }
    private static void comprobar(boolean condicion, String detalle) {
        if (!condicion) throw new AssertionError("Comprobacion fallida: " + detalle);
    }
}