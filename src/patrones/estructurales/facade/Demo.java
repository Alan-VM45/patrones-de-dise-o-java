package patrones.estructurales.facade;

public final class Demo {
    public static void main(String[] args) {
        Luces luces = new Luces();
        Proyector proyector = new Proyector();
        Audio audio = new Audio();
        CineFacade cine = new CineFacade(luces, proyector, audio);
        cine.verPelicula("Metropolis");
        comprobar(luces.estanTenues(), "luces atenuadas");
        comprobar(proyector.estaEncendido(), "proyector encendido");
        comprobar(audio.getVolumen() == 80, "volumen configurado");
        comprobar("Metropolis".equals(cine.getPeliculaActual()), "pelicula seleccionada");
        System.out.println("Pedimos ver '" + cine.getPeliculaActual() + "' con una sola llamada a CineFacade.");
        System.out.println("La fachada dejo las luces tenues: " + luces.estanTenues());
        System.out.println("El proyector esta encendido: " + proyector.estaEncendido());
        System.out.println("El volumen quedo en: " + audio.getVolumen());
        System.out.println("CineFacade coordino los subsistemas por nosotros.");
    }
    private static void comprobar(boolean condicion, String detalle) {
        if (!condicion) throw new AssertionError("Comprobacion fallida: " + detalle);
    }
}