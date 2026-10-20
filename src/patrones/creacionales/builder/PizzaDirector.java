package patrones.creacionales.builder;

public final class PizzaDirector {
    public Pizza crearMargarita(PizzaBuilder builder) {
        return builder.buildMasa("fina").buildSalsa("tomate").buildQueso("mozzarella").build();
    }
}