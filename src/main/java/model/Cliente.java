package model;

import util.MiExcepcion;

public class Cliente extends Persona {
    private String telefono;

    public Cliente(String rut, String nombre, Direccion direccion, String telefono)
            throws MiExcepcion {
        super(rut, nombre, direccion);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Datos de Cliente: ");
        super.mostrarResumen();
        System.out.println("Telefono: " + telefono);
    }
}
