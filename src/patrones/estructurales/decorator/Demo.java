package patrones.estructurales.decorator;

public final class Demo {
    public static void main(String[] args) {
        String mensaje = "Pedido listo";
        Notificador base = new NotificadorBase();
        Notificador notificador = new DecoradorSMS(base);
        String resultadoBase = base.enviar(mensaje);
        String resultado = notificador.enviar(mensaje);
        if (!"Email: Pedido listo | SMS: Pedido listo".equals(resultado)) {
            throw new AssertionError("El decorador debe enviar por email y SMS");
        }
        System.out.println("Sin decorador: " + resultadoBase);
        System.out.println("Envolviendo el notificador con DecoradorSMS: " + resultado);
        System.out.println("El objeto recibe SMS sin modificar el notificador base.");
    }
}