package patrones.creacionales.factorymethod;

interface Documento {
    String exportar(String contenido);
}

final class DocumentoPDF implements Documento {
    public String exportar(String contenido) { return "PDF: " + contenido; }
}

final class DocumentoTexto implements Documento {
    public String exportar(String contenido) { return "TXT: " + contenido; }
}

abstract class CreadorDocumento {
    protected abstract Documento crearDocumento();

    String exportar(String contenido) { return crearDocumento().exportar(contenido); }
}

final class CreadorPDF extends CreadorDocumento {
    protected Documento crearDocumento() { return new DocumentoPDF(); }
}

final class CreadorTexto extends CreadorDocumento {
    protected Documento crearDocumento() { return new DocumentoTexto(); }
}

public final class Demo {
    public static void main(String[] args) {
        String pdf = new CreadorPDF().exportar("informe");
        String texto = new CreadorTexto().exportar("informe");
        if (!"PDF: informe".equals(pdf) || !"TXT: informe".equals(texto)) {
            throw new AssertionError("Cada creador debe producir su formato");
        }
        System.out.println("El creador PDF decide que documento crear: " + pdf);
        System.out.println("El creador de texto decide que documento crear: " + texto);
    }
}