package patrones.comportamiento.memento;

public final class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.escribir("Borrador");
        System.out.println("Texto inicial: " + editor.getTexto());
        Memento guardado = editor.guardar();
        editor.escribir("Texto modificado");
        System.out.println("Despues de editar: " + editor.getTexto());
        editor.restaurar(guardado);
        if (!"Borrador".equals(editor.getTexto())) throw new AssertionError("No se restauro el estado");
        System.out.println("Despues de restaurar el memento: " + editor.getTexto());
    }
}