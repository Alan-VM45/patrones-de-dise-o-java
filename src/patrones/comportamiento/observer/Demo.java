package patrones.comportamiento.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class Demo {
    static final class Pedido {
        private final List<Consumer<String>> observadores = new ArrayList<>();
        private String estado = "Recibido";
        void suscribir(Consumer<String> observador) { observadores.add(observador); }
        void cambiarEstado(String nuevoEstado) {
            estado = nuevoEstado;
            for (Consumer<String> observador : observadores) observador.accept(estado);
        }
    }

    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        List<String> avisos = new ArrayList<>();
        pedido.suscribir(avisos::add);
        pedido.cambiarEstado("Enviado");
        pedido.cambiarEstado("Entregado");
        System.out.println("El pedido cambia de estado; el cliente recibe automaticamente:");
        for (String aviso : avisos) System.out.println("- Tu pedido esta " + aviso);
    }
}