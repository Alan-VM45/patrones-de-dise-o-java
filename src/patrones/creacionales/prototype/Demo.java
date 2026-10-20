package patrones.creacionales.prototype;

public final class Demo {
    public static void main(String[] args) {
        Documento original = new Documento("contrato");
        original.agregarDato("usuario", "Ana");
        System.out.println("Original antes de copiar: contrato para " + original.getDato("usuario"));
        Documento copia = original.clone();
        System.out.println("Se clono el documento. Original y copia son objetos distintos: " + (original != copia));
        copia.agregarDato("usuario", "Luis");
        comprobar("Ana".equals(original.getDato("usuario")), "la copia no modifica el original");
        comprobar("Luis".equals(copia.getDato("usuario")), "la copia conserva su dato");
        comprobar(original != copia, "instancias distintas");
        System.out.println("Despues de editar la copia:");
        System.out.println("  Original: contrato para " + original.getDato("usuario"));
        System.out.println("  Copia:    contrato para " + copia.getDato("usuario"));
    }
    private static void comprobar(boolean condicion, String detalle) {
        if (!condicion) throw new AssertionError("Comprobacion fallida: " + detalle);
    }
}