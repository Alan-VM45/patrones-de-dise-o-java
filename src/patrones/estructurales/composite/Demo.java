package patrones.estructurales.composite;

import java.util.ArrayList;
import java.util.List;

interface ElementoCatalogo {
    double precio();
}

final class Producto implements ElementoCatalogo {
    private final double precio;

    Producto(double precio) { this.precio = precio; }

    public double precio() { return precio; }
}

final class Caja implements ElementoCatalogo {
    private final List<ElementoCatalogo> elementos = new ArrayList<>();

    void agregar(ElementoCatalogo elemento) { elementos.add(elemento); }

    public double precio() {
        double total = 0;
        for (ElementoCatalogo elemento : elementos) total += elemento.precio();
        return total;
    }
}

public final class Demo {
    public static void main(String[] args) {
        ElementoCatalogo productoA = new Producto(12.5);
        ElementoCatalogo productoB = new Producto(7.5);
        Caja caja = new Caja();
        caja.agregar(productoA);
        caja.agregar(productoB);
        if (caja.precio() != 20.0) throw new AssertionError("Precio de la composicion");
        System.out.println("Producto A: $" + productoA.precio());
        System.out.println("Producto B: $" + productoB.precio());
        System.out.println("La caja contiene ambos productos; precio total: $" + caja.precio());
        System.out.println("Producto y caja se consultan con el mismo metodo precio().");
    }
}