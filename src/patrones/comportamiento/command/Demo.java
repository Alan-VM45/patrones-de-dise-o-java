package patrones.comportamiento.command;

interface Comando {
    void ejecutar();
}

final class Luz {
    private boolean encendida;

    void encender() { encendida = true; }
    boolean estaEncendida() { return encendida; }
}

final class EncenderLuz implements Comando {
    private final Luz luz;

    EncenderLuz(Luz luz) { this.luz = luz; }

    public void ejecutar() { luz.encender(); }
}

final class Interruptor {
    private final Comando comando;

    Interruptor(Comando comando) { this.comando = comando; }

    void presionar() { comando.ejecutar(); }
}

public final class Demo {
    public static void main(String[] args) {
        Luz luz = new Luz();
        Interruptor interruptor = new Interruptor(new EncenderLuz(luz));
        System.out.println("Estado inicial de la luz: " + (luz.estaEncendida() ? "encendida" : "apagada"));
        System.out.println("Se presiona el interruptor; este ejecuta el comando EncenderLuz.");
        interruptor.presionar();
        if (!luz.estaEncendida()) throw new AssertionError("El comando debe encender la luz");
        System.out.println("Estado final de la luz: " + (luz.estaEncendida() ? "encendida" : "apagada"));
    }
}