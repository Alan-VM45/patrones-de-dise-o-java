package patrones.comportamiento.iterator;

import java.util.Arrays;
import java.util.List;

final class IteradorCatalogo {
    private final List<String> titulos;
    private int posicion;

    IteradorCatalogo(List<String> titulos) { this.titulos = titulos; }

    boolean tieneSiguiente() { return posicion < titulos.size(); }

    String siguiente() {
        if (!tieneSiguiente()) throw new IllegalStateException("No quedan elementos");
        return titulos.get(posicion++);
    }
}

final class Catalogo {
    private final List<String> titulos;

    Catalogo(String... titulos) { this.titulos = Arrays.asList(titulos); }

    IteradorCatalogo iterador() { return new IteradorCatalogo(titulos); }
}

public final class Demo {
    public static void main(String[] args) {
        IteradorCatalogo iterador = new Catalogo("Java practico", "Diseno de software", "Bases de datos").iterador();
        System.out.println("La tienda recorre el catalogo sin exponer su lista interna:");
        while (iterador.tieneSiguiente()) {
            System.out.println("- " + iterador.siguiente());
        }
        System.out.println("Fin del catalogo.");
    }
}