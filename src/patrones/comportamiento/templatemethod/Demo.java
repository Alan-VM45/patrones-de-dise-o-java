package patrones.comportamiento.templatemethod;

abstract class BebidaCaliente {
    final String preparar() {
        return "Hervir agua, " + prepararIngrediente() + ", " + agregarCondimentos();
    }

    protected abstract String prepararIngrediente();
    protected abstract String agregarCondimentos();
}

final class Cafe extends BebidaCaliente {
    protected String prepararIngrediente() { return "filtrar cafe"; }
    protected String agregarCondimentos() { return "agregar azucar"; }
}

final class Te extends BebidaCaliente {
    protected String prepararIngrediente() { return "infusionar te"; }
    protected String agregarCondimentos() { return "agregar limon"; }
}

public final class Demo {
    public static void main(String[] args) {
        String cafe = new Cafe().preparar();
        String te = new Te().preparar();
        if (!cafe.contains("filtrar cafe") || !cafe.startsWith("Hervir agua")) {
            throw new AssertionError("El algoritmo base debe conservar su orden");
        }
        if (!te.contains("infusionar te") || !te.startsWith("Hervir agua")) {
            throw new AssertionError("El te debe conservar los pasos comunes");
        }
        System.out.println("Preparacion de cafe: " + cafe);
        System.out.println("Preparacion de te: " + te);
        System.out.println("Ambas bebidas hierven agua, pero personalizan los otros pasos.");
    }
}