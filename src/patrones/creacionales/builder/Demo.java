package patrones.creacionales.builder;

public final class Demo {
    public static void main(String[] args) {
        Pizza pizza = new PizzaDirector().crearMargarita(new PizzaBuilder());
        comprobar("fina".equals(pizza.getMasa()), "masa");
        comprobar("tomate".equals(pizza.getSalsa()), "salsa");
        comprobar("mozzarella".equals(pizza.getQueso()), "queso");
        System.out.println("El director pide construir una pizza Margarita paso a paso.");
        System.out.println("Pizza terminada: masa " + pizza.getMasa() + ", salsa " + pizza.getSalsa()
            + " y queso " + pizza.getQueso() + ".");
        System.out.println("El Builder reunio los ingredientes y devolvio el objeto completo.");
    }
    private static void comprobar(boolean condicion, String detalle) {
        if (!condicion) throw new AssertionError("Comprobacion fallida: " + detalle);
    }
}