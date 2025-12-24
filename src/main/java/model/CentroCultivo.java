package model;

public class CentroCultivo extends UnidadOperativa {

    private double toneladasProduccion;

    public CentroCultivo(String nombre, String comuna, double toneladasProduccion) {
        super(nombre, comuna);
        this.toneladasProduccion = toneladasProduccion;
    }

    public double getToneladasProduccion() { return toneladasProduccion; }

    @Override
    public void mostrarResumen() {
        System.out.println("Nombre centro de cultivo: " + nombre);
        System.out.println("Comuna: " + comuna);
        System.out.println("Produccion total: " + toneladasProduccion + " ton");
    }
}