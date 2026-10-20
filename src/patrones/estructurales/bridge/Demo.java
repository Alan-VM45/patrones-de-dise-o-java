package patrones.estructurales.bridge;

interface Dispositivo {
    String encender();
}

final class Televisor implements Dispositivo {
    public String encender() { return "Televisor encendido"; }
}

final class Radio implements Dispositivo {
    public String encender() { return "Radio encendida"; }
}

final class ControlRemoto {
    private final Dispositivo dispositivo;

    ControlRemoto(Dispositivo dispositivo) { this.dispositivo = dispositivo; }

    String encender() { return dispositivo.encender(); }
}

public final class Demo {
    public static void main(String[] args) {
        ControlRemoto controlTelevisor = new ControlRemoto(new Televisor());
        ControlRemoto controlRadio = new ControlRemoto(new Radio());
        String televisor = controlTelevisor.encender();
        String radio = controlRadio.encender();
        if (!"Televisor encendido".equals(televisor) || !"Radio encendida".equals(radio)) {
            throw new AssertionError("El control debe funcionar con ambos dispositivos");
        }
        System.out.println("El control remoto enciende un televisor: " + televisor);
        System.out.println("El mismo tipo de control enciende una radio: " + radio);
        System.out.println("El control y el aparato pueden cambiar de forma independiente.");
    }
}