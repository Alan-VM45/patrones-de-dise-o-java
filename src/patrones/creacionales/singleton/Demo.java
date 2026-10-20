package patrones.creacionales.singleton;

final class Configuracion {
    private static final Configuracion INSTANCIA = new Configuracion();
    private final double impuesto = 0.16;

    private Configuracion() {}

    static Configuracion obtenerInstancia() { return INSTANCIA; }
    double getImpuesto() { return impuesto; }
}

public final class Demo {
    public static void main(String[] args) {
        Configuracion primera = Configuracion.obtenerInstancia();
        Configuracion segunda = Configuracion.obtenerInstancia();
        if (primera != segunda || primera.getImpuesto() != 0.16) throw new AssertionError("Singleton");
        System.out.println("Dos partes de la libreria consultan la tasa de impuesto: "
            + primera.getImpuesto() + " y " + segunda.getImpuesto());
        System.out.println("Ambas usan la misma configuracion compartida: " + (primera == segunda));
    }
}