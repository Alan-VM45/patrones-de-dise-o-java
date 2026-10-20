package patrones.comportamiento.iterator;

import java.util.Arrays;
import java.util.List;

final class IteradorPalabras {
    private final List<String> palabras;
    private int posicion;

    IteradorPalabras(List<String> palabras) { this.palabras = palabras; }

    boolean tieneSiguiente() { return posicion < palabras.size(); }

    String siguiente() {
        if (!tieneSiguiente()) throw new IllegalStateException("No quedan elementos");
        return palabras.get(posicion++);
    }
}

final class ColeccionPalabras {
    private final List<String> palabras;

    ColeccionPalabras(String... palabras) { this.palabras = Arrays.asList(palabras); }

    IteradorPalabras iterador() { return new IteradorPalabras(palabras); }
}

public final class Demo {
    public static void main(String[] args) {
        IteradorPalabras iterador = new ColeccionPalabras("uno", "dos").iterador();
        System.out.println("Recorriendo la coleccion sin acceder a su lista interna:");
        String[] esperadas = {"uno", "dos"};
        int indice = 0;
        while (iterador.tieneSiguiente()) {
            String palabra = iterador.siguiente();
            System.out.println("- " + palabra);
            if (!esperadas[indice++].equals(palabra)) throw new AssertionError("Orden del iterador");
        }
        if (indice != esperadas.length) throw new AssertionError("Faltan elementos");
        System.out.println("Fin del recorrido: no quedan elementos.");
    }
}