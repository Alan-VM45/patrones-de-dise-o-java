package patrones.comportamiento.visitor;

interface Visitante {
    double visitarProducto(Producto producto);
    double visitarServicio(Servicio servicio);
}

interface ElementoComercial {
    double aceptar(Visitante visitante);
}

final class Producto implements ElementoComercial {
    private final double precio;

    Producto(double precio) { this.precio = precio; }
    double getPrecio() { return precio; }
    public double aceptar(Visitante visitante) { return visitante.visitarProducto(this); }
}

final class Servicio implements ElementoComercial {
    private final double tarifa;

    Servicio(double tarifa) { this.tarifa = tarifa; }
    double getTarifa() { return tarifa; }
    public double aceptar(Visitante visitante) { return visitante.visitarServicio(this); }
}

final class CalculadorImpuestos implements Visitante {
    public double visitarProducto(Producto producto) { return producto.getPrecio() * 0.16; }
    public double visitarServicio(Servicio servicio) { return servicio.getTarifa() * 0.10; }
}

public final class Demo {
    public static void main(String[] args) {
        Visitante impuestos = new CalculadorImpuestos();
        Producto producto = new Producto(100);
        Servicio servicio = new Servicio(100);
        double impuestoProducto = producto.aceptar(impuestos);
        double impuestoServicio = servicio.aceptar(impuestos);
        if (impuestoProducto != 16.0 || impuestoServicio != 10.0) {
            throw new AssertionError("Calculo por tipo de elemento");
        }
        System.out.println("Impuesto sobre producto de $" + producto.getPrecio() + ": $" + impuestoProducto);
        System.out.println("Impuesto sobre servicio de $" + servicio.getTarifa() + ": $" + impuestoServicio);
        System.out.println("El visitante aplica una operacion distinta segun el tipo de elemento.");
    }
}