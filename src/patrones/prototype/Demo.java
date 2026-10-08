package patrones.prototype;

public final class Demo {
    public static void main(String[] args) {
        Documento original = new Documento("contrato");
        original.agregarDato("usuario", "Ana");
        Documento copia = original.clone();
        copia.agregarDato("usuario", "Luis");
        comprobar("Ana".equals(original.getDato("usuario")), "la copia no modifica el original");
        comprobar("Luis".equals(copia.getDato("usuario")), "la copia conserva su dato");
        comprobar(original != copia, "instancias distintas");
        System.out.println("Prototype: OK");
    }
    private static void comprobar(boolean condicion, String detalle) {
        if (!condicion) throw new AssertionError("Comprobacion fallida: " + detalle);
    }
}