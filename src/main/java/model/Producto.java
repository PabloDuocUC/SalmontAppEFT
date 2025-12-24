package model;

public class Producto implements Registrable{

    private String codigo;
    private String nombre;
    private double precio;

    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Producto: " + nombre);
        System.out.println("Codigo: " + codigo);
        System.out.println("Precio: $" + precio);
    }
}
