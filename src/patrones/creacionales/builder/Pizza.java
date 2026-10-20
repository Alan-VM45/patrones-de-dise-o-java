package patrones.creacionales.builder;

public final class Pizza {
    private final String masa;
    private final String salsa;
    private final String queso;

    Pizza(String masa, String salsa, String queso) {
        this.masa = masa;
        this.salsa = salsa;
        this.queso = queso;
    }

    public String getMasa() { return masa; }
    public String getSalsa() { return salsa; }
    public String getQueso() { return queso; }
}