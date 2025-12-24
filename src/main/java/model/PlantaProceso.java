package model;

public class PlantaProceso extends UnidadOperativa {

    private double capacidadProceso;

    public PlantaProceso(String nombre, String comuna, double capacidadProceso) {
        super(nombre, comuna);
        this.capacidadProceso = capacidadProceso;
    }

    public double getCapacidadProceso() { return capacidadProceso; }

    @Override
    public void mostrarResumen() {
        System.out.println("Nombre planta de proceso: " + nombre);
        System.out.println("Comuna: " + comuna);
        System.out.println("Capacidad maxima: " + capacidadProceso + " toneladas por día");
    }

}