package patrones.decorator;

public final class Demo {
    public static void main(String[] args) {
        Notificador notificador = new DecoradorSMS(new NotificadorBase());
        String resultado = notificador.enviar("Pedido listo");
        if (!"Email: Pedido listo | SMS: Pedido listo".equals(resultado)) {
            throw new AssertionError("El decorador debe enviar por email y SMS");
        }
        System.out.println("Decorator: OK");
    }
}