package model;
import util.MiExcepcion;

public abstract class Persona implements Registrable{
    private String rut;
    private String nombre;
    private Direccion direccion;

    public Persona(String rut, String nombre, Direccion direccion) throws MiExcepcion { //Utilizamos excepcion en constructor
        if (rut == null || rut.trim().isEmpty()) {
            throw new MiExcepcion("RUT no puede estar vacio");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new MiExcepcion("Nombre no puede estar vacio");
        }

        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    @Override //Polimorfismo para Persona
    public void mostrarResumen() {
        System.out.println("Persona: " + nombre + " (RUT: " + rut + ")");
        System.out.println("Direccion: " + direccion);
    }

    @Override
    public String toString() {
        return nombre + " (RUT: " + rut + ")";
    }
}
