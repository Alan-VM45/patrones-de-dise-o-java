package patrones.estructurales.adapter;

public final class Demo {
    interface Inventario { int unidadesDisponibles(String isbn); }
    static final class InventarioAntiguo {
        int buscarExistencias(String codigo) { return "LIB-42".equals(codigo) ? 3 : 0; }
    }
    static final class AdaptadorInventario implements Inventario {
        private final InventarioAntiguo antiguo;
        AdaptadorInventario(InventarioAntiguo antiguo) { this.antiguo = antiguo; }
        public int unidadesDisponibles(String isbn) {
            String codigoAntiguo = "9780000000042".equals(isbn) ? "LIB-42" : "SIN-CODIGO";
            return antiguo.buscarExistencias(codigoAntiguo);
        }
    }

    public static void main(String[] args) {
        Inventario inventario = new AdaptadorInventario(new InventarioAntiguo());
        int unidades = inventario.unidadesDisponibles("9780000000042");
        if (unidades != 3) throw new AssertionError("El adaptador debe consultar el inventario antiguo");
        System.out.println("La tienda pregunta por ISBN 9780000000042.");
        System.out.println("El adaptador lo convierte al codigo LIB-42 que entiende el sistema antiguo.");
        System.out.println("Unidades disponibles: " + unidades);
    }
}