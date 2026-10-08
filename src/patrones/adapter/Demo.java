package patrones.adapter;

public final class Demo {
    public static void main(String[] args) {
        Motor motor = new AdaptadorMotor(new MotorViejo());
        if (!"Arranca".equals(motor.conectar())) throw new AssertionError("Fallo del adaptador");
        System.out.println("Adapter: OK");
    }
}