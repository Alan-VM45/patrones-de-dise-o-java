package patrones.comportamiento.observer;

import java.util.ArrayList;
import java.util.List;

public final class Demo {
    public static void main(String[] args) {
        CanalYoutube canal = new CanalYoutube();
        List<String> recibidos = new ArrayList<>();
        canal.suscribir(recibidos::add);
        canal.subirVideo("Patrones en Java");
        if (!recibidos.equals(List.of("Patrones en Java"))) throw new AssertionError("Fallo de notificacion");
        System.out.println("El canal publica: Patrones en Java");
        System.out.println("Suscriptor notificado: " + recibidos.get(0));
        System.out.println("El canal aviso automaticamente a quien estaba suscrito.");
    }
}