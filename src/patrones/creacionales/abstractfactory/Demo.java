package patrones.creacionales.abstractfactory;

interface Boton {
    String dibujar();
}

interface Casilla {
    String dibujar();
}

interface FabricaInterfaz {
    Boton crearBoton();
    Casilla crearCasilla();
}

final class FabricaClara implements FabricaInterfaz {
    public Boton crearBoton() { return () -> "Boton claro"; }
    public Casilla crearCasilla() { return () -> "Casilla clara"; }
}

final class FabricaOscura implements FabricaInterfaz {
    public Boton crearBoton() { return () -> "Boton oscuro"; }
    public Casilla crearCasilla() { return () -> "Casilla oscura"; }
}

public final class Demo {
    public static void main(String[] args) {
        FabricaInterfaz fabricaClara = new FabricaClara();
        FabricaInterfaz fabricaOscura = new FabricaOscura();
        String clara = fabricaClara.crearBoton().dibujar() + " | " + fabricaClara.crearCasilla().dibujar();
        String oscura = fabricaOscura.crearBoton().dibujar() + " | " + fabricaOscura.crearCasilla().dibujar();
        if (!"Boton claro | Casilla clara".equals(clara) || !"Boton oscuro | Casilla oscura".equals(oscura)) {
            throw new AssertionError("Cada fabrica debe crear una familia consistente");
        }
        System.out.println("La fabrica clara crea: " + clara);
        System.out.println("La fabrica oscura crea: " + oscura);
        System.out.println("Al cambiar de fabrica, cambian juntos los componentes de la interfaz.");
    }
}