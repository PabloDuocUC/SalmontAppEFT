package data;

import model.*;
import util.MiExcepcion;
import java.io.*;
import java.util.*;

public class GestorUnidades {
    private List<Persona> personas;
    private List<Producto> productos;
    private List<Proveedor> proveedores;
    private List<OrdenDeCompra> ordenes;

    // Lista para todas las entidades (polimorfismo)
    private List<Registrable> todasLasEntidades;

    public GestorUnidades() {
        personas = new ArrayList<>();
        productos = new ArrayList<>();
        proveedores = new ArrayList<>();
        ordenes = new ArrayList<>();
        todasLasEntidades = new ArrayList<>();

        // Solo carga datos de archivos
        cargarDatosDesdeArchivos();
    }

    // metodo para cargar datos desde archivos .txt
    private void cargarDatosDesdeArchivos() {
        cargarPersonas();
        cargarProductos();
        cargarProveedores();
    }

    private void cargarPersonas() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/personas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 8) {
                    Direccion dir = new Direccion(datos[2], datos[3], datos[4]);
                    if (datos[5].equals("Empleado")) {
                        Empleado emp = new Empleado(datos[0], datos[1], dir,
                                datos[6], Double.parseDouble(datos[7]));
                        personas.add(emp);
                        todasLasEntidades.add(emp);
                    } else if (datos[5].equals("Cliente")) {
                        Cliente cli = new Cliente(datos[0], datos[1], dir, datos[6]);
                        personas.add(cli);
                        todasLasEntidades.add(cli);
                    }
                }
            }
        } catch (IOException | MiExcepcion e) {
            System.out.println("Error al cargar personas: " + e.getMessage());
        }
    }

    private void cargarProductos() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/productos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 3) {
                    Producto prod = new Producto(datos[0], datos[1],
                            Double.parseDouble(datos[2]));
                    productos.add(prod);
                    todasLasEntidades.add(prod);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar productos: " + e.getMessage());
        }
    }

    private void cargarProveedores() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/proveedores.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 3) {
                    Proveedor prov = new Proveedor(datos[0], datos[1],
                            Integer.parseInt(datos[2]));
                    proveedores.add(prov);
                    todasLasEntidades.add(prov);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar proveedores: " + e.getMessage());
        }
    }

    // Métodos para agregar nuevos elementos
    public void agregarPersona(Persona p) {
        personas.add(p);
        todasLasEntidades.add(p);
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
        todasLasEntidades.add(p);
    }

    public void agregarProveedor(Proveedor p) {
        proveedores.add(p);
        todasLasEntidades.add(p);
    }

    public void agregarOrden(OrdenDeCompra o) {
        ordenes.add(o);
    }

    // metodo para mostrar instanceof en consola
    public void mostrarConInstanceof() {
        System.out.println("=== DEMOSTRACIÓN DE INSTANCEOF ===");
        for (Registrable entidad : todasLasEntidades) {
            if (entidad instanceof Empleado) {
                System.out.println("EMPLEADO: " + ((Empleado)entidad).getNombre());
            } else if (entidad instanceof Cliente) {
                System.out.println("CLIENTE: " + ((Cliente)entidad).getNombre());
            } else if (entidad instanceof Producto) {
                System.out.println("PRODUCTO: " + ((Producto)entidad).getNombre());
            } else if (entidad instanceof Proveedor) {
                System.out.println("PROVEEDOR: " + ((Proveedor)entidad).getNombre());
            }
        }
    }

    // metodo para generar reporte de polimorfismo
    public String generarReportePolimorfico() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DEMOSTRACIÓN DE POLIMORFISMO (instanceof) ===\n\n");

        for (Registrable entidad : todasLasEntidades) {
            if (entidad instanceof Empleado) {
                sb.append("EMPLEADO: ").append(((Empleado)entidad).getNombre())
                        .append(" - RUT: ").append(((Empleado)entidad).getRut()).append("\n");
            } else if (entidad instanceof Cliente) {
                sb.append("CLIENTE: ").append(((Cliente)entidad).getNombre())
                        .append(" - Tel: ").append(((Cliente)entidad).getTelefono()).append("\n");
            } else if (entidad instanceof Producto) {
                sb.append("PRODUCTO: ").append(((Producto)entidad).getNombre())
                        .append(" - $").append(((Producto)entidad).getPrecio()).append("\n");
            } else if (entidad instanceof Proveedor) {
                sb.append("PROVEEDOR: ").append(((Proveedor)entidad).getNombre())
                        .append(" - Años: ").append(((Proveedor)entidad).getAniosServicio()).append("\n");
            }
        }

        sb.append("\nTotal entidades: ").append(todasLasEntidades.size());
        return sb.toString();
    }

    // Getters
    public List<Persona> getPersonas() {
        return personas;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<OrdenDeCompra> getOrdenes() {
        return ordenes;
    }

    public List<Registrable> getUnidades() {
        return todasLasEntidades;
    }

    public Persona buscarPersonaPorRut(String rut) {
        for (Persona p : personas) {
            if (p.getRut().equals(rut)) {
                return p;
            }
        }
        return null;
    }
}