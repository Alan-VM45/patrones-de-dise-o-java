package patrones.chain;

public final class Demo {
    public static void main(String[] args) {
        Manejador supervisor = new Supervisor();
        Manejador gerente = new Gerente();
        Manejador director = new Director();
        supervisor.setSiguiente(gerente).setSiguiente(director);
        comprobar("Supervisor".equals(supervisor.manejar(new Solicitud(50))), "solicitud pequena");
        comprobar("Gerente".equals(supervisor.manejar(new Solicitud(500))), "solicitud mediana");
        comprobar("Director".equals(supervisor.manejar(new Solicitud(5000))), "solicitud grande");
        System.out.println("Chain of Responsibility: OK");
    }
    private static void comprobar(boolean condicion, String detalle) {
        if (!condicion) throw new AssertionError("Comprobacion fallida: " + detalle);
    }
}