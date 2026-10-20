package patrones.comportamiento.chain;

public final class Demo {
    public static void main(String[] args) {
        Manejador supervisor = new Supervisor();
        Manejador gerente = new Gerente();
        Manejador director = new Director();
        supervisor.setSiguiente(gerente).setSiguiente(director);

        System.out.println("Cadena: Supervisor -> Gerente -> Director");
        comprobarResultado(supervisor, 50, "Supervisor");
        comprobarResultado(supervisor, 500, "Gerente");
        comprobarResultado(supervisor, 5000, "Director");
        System.out.println("Resumen: el supervisor atendio $50, el gerente $500 y el director $5000.");
    }

    private static void comprobarResultado(Manejador inicio, int monto, String responsableEsperado) {
        System.out.println("\nNueva solicitud: $" + monto);
        String responsable = inicio.manejar(new Solicitud(monto));
        comprobar(responsableEsperado.equals(responsable), "responsable de solicitud por $" + monto);
        System.out.println("Resultado: la solicitud queda a cargo de " + responsable + ".");
    }

    private static void comprobar(boolean condicion, String detalle) {
        if (!condicion) throw new AssertionError("Comprobacion fallida: " + detalle);
    }
}