package patrones.creacionales.abstractfactory;

public final class Demo {
    interface Impuestos { double calcular(double subtotal); }
    interface Envio { double calcular(double pesoKg); }
    interface PoliticaRegional { Impuestos crearImpuestos(); Envio crearEnvio(); }

    static final class PoliticaMexico implements PoliticaRegional {
        public Impuestos crearImpuestos() { return subtotal -> subtotal * 0.16; }
        public Envio crearEnvio() { return peso -> 80 + peso * 15; }
    }

    static final class PoliticaArgentina implements PoliticaRegional {
        public Impuestos crearImpuestos() { return subtotal -> subtotal * 0.21; }
        public Envio crearEnvio() { return peso -> 1200 + peso * 250; }
    }

    public static void main(String[] args) {
        double subtotal = 500;
        double peso = 2;
        PoliticaRegional[] politicas = {new PoliticaMexico(), new PoliticaArgentina()};
        String[] regiones = {"Mexico", "Argentina"};
        double[] impuestosEsperados = {80, 105};
        double[] enviosEsperados = {110, 1700};
        for (int i = 0; i < politicas.length; i++) {
            double impuestos = politicas[i].crearImpuestos().calcular(subtotal);
            double envio = politicas[i].crearEnvio().calcular(peso);
            if (impuestos != impuestosEsperados[i] || envio != enviosEsperados[i]) {
                throw new AssertionError("Reglas regionales incorrectas para " + regiones[i]);
            }
            System.out.println("Pedido para " + regiones[i] + ": subtotal $" + subtotal
                    + ", impuesto $" + impuestos + ", envio $" + envio);
        }
        System.out.println("La fabrica cambia el conjunto de reglas segun la region del pedido.");
    }
}