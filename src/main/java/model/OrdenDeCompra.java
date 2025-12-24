package model;

import java.util.ArrayList;
import java.util.List;

public class OrdenDeCompra {
    private static int contadorOrdenes = 1;
    private int numero;
    private Cliente cliente;
    private List<Producto> productos;
    private double total;

    public OrdenDeCompra(Cliente cliente) {
        this.numero = contadorOrdenes++;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        total += producto.getPrecio();
    }

    public int getNumero() { return numero; }
    public Cliente getCliente() { return cliente; }
    public List<Producto> getProductos() { return productos; }
    public double getTotal() { return total; }

    @Override
    public String toString() {
        return "Orden #" + numero + " - Cliente: " + cliente.getNombre() + " - Total: $" + total;
    }
}