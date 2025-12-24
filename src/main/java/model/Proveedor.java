package model;

public class Proveedor implements Registrable{

    private String nombre;
    private String producto;
    private int aniosServicio;

    public Proveedor(String nombre, String producto, int aniosServicio) {
        this.nombre = nombre;
        this.producto = producto;
        this.aniosServicio = aniosServicio;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Nombre de proveedor: " + nombre);
        System.out.println("Producto ofrecido: " + producto);
        System.out.println("Años de servicio: " + aniosServicio);
    }

    public String getNombre() {
        return nombre;
    }

    public String getProducto() {
        return producto;
    }

    public int getAniosServicio() {
        return aniosServicio;
    }
}
