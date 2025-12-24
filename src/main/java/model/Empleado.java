package model;

import util.MiExcepcion;
public class Empleado extends Persona{

    private String cargo;
    private double salario;

    public Empleado(String rut, String nombre, Direccion direccion, String cargo, double salario)
            throws MiExcepcion {
        super(rut, nombre, direccion);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Datos de empleado: ");
        super.mostrarResumen();
        System.out.println("Cargo: " + cargo);
        System.out.println("Sueldo: $" + salario);
    }


}
