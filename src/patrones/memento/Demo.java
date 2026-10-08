package patrones.memento;

public final class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.escribir("Borrador");
        Memento guardado = editor.guardar();
        editor.escribir("Texto modificado");
        editor.restaurar(guardado);
        if (!"Borrador".equals(editor.getTexto())) throw new AssertionError("No se restauro el estado");
        System.out.println("Memento: OK");
    }
}