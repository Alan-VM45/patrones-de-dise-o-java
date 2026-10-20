package patrones.estructurales.proxy;

interface ServicioDatos {
    String consultar();
}

final class ServicioReal implements ServicioDatos {
    public String consultar() { return "Datos del servidor"; }
}

final class ServicioProxy implements ServicioDatos {
    private ServicioReal servicio;

    public String consultar() {
        if (servicio == null) servicio = new ServicioReal();
        return servicio.consultar();
    }

    boolean estaCargado() { return servicio != null; }
}

public final class Demo {
    interface Ficha { String descripcion(); }
    static final class FichaRemota implements Ficha {
        private final String isbn;
        FichaRemota(String isbn) { this.isbn = isbn; }
        public String descripcion() { return "Descripcion completa del libro " + isbn; }
    }
    static final class FichaConProxy implements Ficha {
        private final String isbn;
        private FichaRemota fichaReal;
        FichaConProxy(String isbn) { this.isbn = isbn; }
        public String descripcion() {
            if (fichaReal == null) {
                System.out.println("Proxy: carga la ficha detallada solo cuando alguien la solicita.");
                fichaReal = new FichaRemota(isbn);
            }
            return fichaReal.descripcion();
        }
    }

    public static void main(String[] args) {
        FichaConProxy ficha = new FichaConProxy("978-1");
        System.out.println("La lista del catalogo se muestra sin descargar la descripcion completa.");
        System.out.println("El cliente abre el libro: " + ficha.descripcion());
    }
}