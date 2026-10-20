package patrones.comportamiento.interpreter;

interface Expresion {
    int interpretar();
}

final class Numero implements Expresion {
    private final int valor;

    Numero(int valor) { this.valor = valor; }

    public int interpretar() { return valor; }
}

final class Suma implements Expresion {
    private final Expresion izquierda;
    private final Expresion derecha;

    Suma(Expresion izquierda, Expresion derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public int interpretar() { return izquierda.interpretar() + derecha.interpretar(); }
}

public final class Demo {
    public static void main(String[] args) {
        Expresion expresion = new Suma(new Numero(2), new Numero(3));
        int resultado = expresion.interpretar();
        if (resultado != 5) throw new AssertionError("2 + 3 debe ser 5");
        System.out.println("Construimos una expresion con dos numeros: 2 y 3.");
        System.out.println("El interprete evalua la suma y obtiene: " + resultado);
        System.out.println("La expresion se representa como objetos, no como texto analizado.");
    }
}