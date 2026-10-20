package patrones.estructurales.flyweight;

import java.util.HashMap;
import java.util.Map;

final class Estilo {
    private final String fuente;
    private final int tamano;

    Estilo(String fuente, int tamano) { this.fuente = fuente; this.tamano = tamano; }

    String describir(String texto) { return texto + " (" + fuente + ", " + tamano + ")"; }
}

final class FabricaEstilos {
    private final Map<String, Estilo> estilos = new HashMap<>();

    Estilo obtener(String fuente, int tamano) {
        String clave = fuente + ":" + tamano;
        if (!estilos.containsKey(clave)) estilos.put(clave, new Estilo(fuente, tamano));
        return estilos.get(clave);
    }
}

final class Texto {
    private final String contenido;
    private final Estilo estilo;

    Texto(String contenido, Estilo estilo) { this.contenido = contenido; this.estilo = estilo; }

    String mostrar() { return estilo.describir(contenido); }
    Estilo getEstilo() { return estilo; }
}

public final class Demo {
    public static void main(String[] args) {
        FabricaEstilos fabrica = new FabricaEstilos();
        Texto primero = new Texto("Hola", fabrica.obtener("Serif", 12));
        Texto segundo = new Texto("Mundo", fabrica.obtener("Serif", 12));
        if (primero.getEstilo() != segundo.getEstilo()) throw new AssertionError("El estilo debe compartirse");
        System.out.println(primero.mostrar());
        System.out.println(segundo.mostrar());
        System.out.println("Ambos textos comparten el mismo objeto de estilo: "
            + (primero.getEstilo() == segundo.getEstilo()));
    }
}