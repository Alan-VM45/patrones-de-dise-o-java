package patrones.builder;

public final class PizzaBuilder {
    private String masa;
    private String salsa;
    private String queso;

    public PizzaBuilder buildMasa(String masa) { this.masa = masa; return this; }
    public PizzaBuilder buildSalsa(String salsa) { this.salsa = salsa; return this; }
    public PizzaBuilder buildQueso(String queso) { this.queso = queso; return this; }

    public Pizza build() {
        if (masa == null || salsa == null || queso == null) {
            throw new IllegalStateException("Faltan ingredientes para construir la pizza");
        }
        return new Pizza(masa, salsa, queso);
    }
}