package patrones.prototype;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Documento implements Cloneable {
    private final String plantilla;
    private final Map<String, String> datos;

    public Documento(String plantilla) { this(plantilla, new LinkedHashMap<>()); }
    private Documento(String plantilla, Map<String, String> datos) {
        this.plantilla = plantilla;
        this.datos = datos;
    }
    public void agregarDato(String clave, String valor) { datos.put(clave, valor); }
    public String getDato(String clave) { return datos.get(clave); }
    public String getPlantilla() { return plantilla; }
    @Override
    public Documento clone() { return new Documento(plantilla, new LinkedHashMap<>(datos)); }
}