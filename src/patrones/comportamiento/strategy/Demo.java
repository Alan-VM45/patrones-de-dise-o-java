package patrones.comportamiento.strategy;

public final class Demo {
    interface EstrategiaEnvio { double calcular(double distanciaKm); String nombre(); }
    static final class EnvioEstandar implements EstrategiaEnvio {
        public double calcular(double km) { return 50 + km * 2; }
        public String nombre() { return "Estandar"; }
    }
    static final class EnvioExpress implements EstrategiaEnvio {
        public double calcular(double km) { return 120 + km * 4; }
        public String nombre() { return "Express"; }
    }
    static final class CotizadorEnvio {
        private EstrategiaEnvio estrategia;
        CotizadorEnvio(EstrategiaEnvio estrategia) { this.estrategia = estrategia; }
        void cambiarEstrategia(EstrategiaEnvio estrategia) { this.estrategia = estrategia; }
        double cotizar(double km) { return estrategia.calcular(km); }
        String nombreEstrategia() { return estrategia.nombre(); }
    }

    public static void main(String[] args) {
        CotizadorEnvio cotizador = new CotizadorEnvio(new EnvioEstandar());
        System.out.println("A 20 km, envio " + cotizador.nombreEstrategia() + ": $" + cotizador.cotizar(20));
        cotizador.cambiarEstrategia(new EnvioExpress());
        System.out.println("El cliente cambia a envio " + cotizador.nombreEstrategia() + ": $" + cotizador.cotizar(20));
        System.out.println("Se cambia la regla de calculo sin cambiar el proceso de compra.");
    }
}