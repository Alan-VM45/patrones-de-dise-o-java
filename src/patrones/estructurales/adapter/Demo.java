package patrones.estructurales.adapter;

public final class Demo {
    public static void main(String[] args) {
        System.out.println("El cliente pide arrancar un motor mediante la interfaz Motor.conectar().");
        Motor motor = new AdaptadorMotor(new MotorViejo());
        String respuesta = motor.conectar();
        if (!"Arranca".equals(respuesta)) throw new AssertionError("Fallo del adaptador");
        System.out.println("El adaptador traduce esa peticion para el motor viejo.");
        System.out.println("Respuesta del motor: " + respuesta);
    }
}