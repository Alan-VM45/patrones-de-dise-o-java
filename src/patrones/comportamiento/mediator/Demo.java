package patrones.comportamiento.mediator;

import java.util.ArrayList;
import java.util.List;

final class MediadorChat {
    private final List<String> mensajes = new ArrayList<>();

    void enviar(String usuario, String mensaje) { mensajes.add(usuario + ": " + mensaje); }
    List<String> getMensajes() { return mensajes; }
}

final class UsuarioChat {
    private final String nombre;
    private final MediadorChat mediador;

    UsuarioChat(String nombre, MediadorChat mediador) {
        this.nombre = nombre;
        this.mediador = mediador;
    }

    void enviar(String mensaje) { mediador.enviar(nombre, mensaje); }
}

public final class Demo {
    public static void main(String[] args) {
        MediadorChat chat = new MediadorChat();
        UsuarioChat ana = new UsuarioChat("Ana", chat);
        UsuarioChat luis = new UsuarioChat("Luis", chat);
        ana.enviar("Hola, Luis");
        luis.enviar("Hola, Ana");
        if (!chat.getMensajes().equals(List.of("Ana: Hola, Luis", "Luis: Hola, Ana"))) {
            throw new AssertionError("El mediador debe registrar los mensajes");
        }
        System.out.println("Ana y Luis envian mensajes a traves del mediador:");
        for (String mensaje : chat.getMensajes()) System.out.println("- " + mensaje);
        System.out.println("Los usuarios se comunican con el mediador, no directamente entre si.");
    }
}