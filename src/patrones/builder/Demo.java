package patrones.builder;

public final class Demo {
    public static void main(String[] args) {
        Pizza pizza = new PizzaDirector().crearMargarita(new PizzaBuilder());
        comprobar("fina".equals(pizza.getMasa()), "masa");
        comprobar("tomate".equals(pizza.getSalsa()), "salsa");
        comprobar("mozzarella".equals(pizza.getQueso()), "queso");
        System.out.println("Builder: OK");
    }
    private static void comprobar(boolean condicion, String detalle) {
        if (!condicion) throw new AssertionError("Comprobacion fallida: " + detalle);
    }
}