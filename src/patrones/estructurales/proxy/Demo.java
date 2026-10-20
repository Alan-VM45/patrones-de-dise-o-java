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
    public static void main(String[] args) {
        ServicioProxy proxy = new ServicioProxy();
        if (proxy.estaCargado()) throw new AssertionError("La carga debe ser diferida");
        System.out.println("Antes de consultar, el servicio real esta cargado: " + proxy.estaCargado());
        String datos = proxy.consultar();
        if (!"Datos del servidor".equals(datos) || !proxy.estaCargado()) {
            throw new AssertionError("El proxy debe controlar el acceso");
        }
        System.out.println("El cliente consulta a traves del proxy y recibe: " + datos);
        System.out.println("Despues de la consulta, el servicio real esta cargado: " + proxy.estaCargado());
    }
}