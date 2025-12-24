package model;

public abstract class UnidadOperativa implements Registrable {
    protected String nombre;
    protected String comuna;

    public UnidadOperativa(String nombre, String comuna) {
        this.nombre = nombre;
        this.comuna = comuna;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Nombre unidad: " + nombre + ", comuna: " + comuna);
    }

    public String getNombre() { return nombre; }
    public String getComuna() { return comuna; }

    @Override
    public String toString() {
        return nombre + " (" + comuna + ")";
    }
}