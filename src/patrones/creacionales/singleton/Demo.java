package patrones.creacionales.singleton;

final class Configuracion {
    private static final Configuracion INSTANCIA = new Configuracion();
    private String idioma = "es";

    private Configuracion() {}

    static Configuracion obtenerInstancia() { return INSTANCIA; }
    String getIdioma() { return idioma; }
}

public final class Demo {
    public static void main(String[] args) {
        Configuracion primera = Configuracion.obtenerInstancia();
        Configuracion segunda = Configuracion.obtenerInstancia();
        if (primera != segunda || !"es".equals(primera.getIdioma())) throw new AssertionError("Singleton");
        System.out.println("Primera consulta: configuracion en idioma " + primera.getIdioma() + ".");
        System.out.println("Segunda consulta devolvio la misma instancia: " + (primera == segunda));
    }
}