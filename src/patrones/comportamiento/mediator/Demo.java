package patrones.comportamiento.mediator;

import java.util.ArrayList;
import java.util.List;

final class CoordinadorCheckout {
    private final List<String> eventos = new ArrayList<>();
    void actualizarDireccion(String direccion) { eventos.add("Direccion: " + direccion); }
    void seleccionarEnvio(String envio) { eventos.add("Envio: " + envio); }
    void seleccionarPago(String pago) { eventos.add("Pago: " + pago); }
    List<String> getEventos() { return eventos; }
}

public final class Demo {
    public static void main(String[] args) {
        CoordinadorCheckout checkout = new CoordinadorCheckout();
        checkout.actualizarDireccion("Calle Sol 20");
        checkout.seleccionarEnvio("Entrega express");
        checkout.seleccionarPago("Tarjeta terminada en 1234");
        System.out.println("El checkout coordina los componentes del formulario:");
        for (String evento : checkout.getEventos()) System.out.println("- " + evento);
        System.out.println("Cada componente informa al coordinador, no necesita conocer a los demas.");
    }
}