package app;

import data.GestorUnidades;
import model.*;
import util.MiExcepcion;

import javax.swing.*;
import java.util.List;

public class Main {
    private static GestorUnidades gestor;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        System.out.println("Bienvenido a SalmontAPP");

        gestor = new GestorUnidades();

        System.out.println("\nDemostracion de instanceof:");
        gestor.mostrarConInstanceof();

        System.out.println("\nIniciando interfaz grafica...");

        iniciarInterfaz();
    }

    private static void iniciarInterfaz() {
        boolean continuar = true;

        while (continuar) {
            String[] opciones = {
                    "Agregar Empleado",
                    "Agregar Cliente",
                    "Agregar Proveedor",
                    "Agregar Producto",
                    "Crear Orden de Compra",
                    "Mostrar Resumen",
                    "Ver Ordenes",
                    "Demostrar Polimorfismo (instanceof)",
                    "Salir"
            };

            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "SALMONTTAPP\nSeleccione una opcion:",
                    "..:Menu Principal:..",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (opcion) {
                case 0: agregarEmpleado(); break;
                case 1: agregarCliente(); break;
                case 2: agregarProveedor(); break;
                case 3: agregarProducto(); break;
                case 4: crearOrdenCompra(); break;
                case 5: mostrarResumen(); break;
                case 6: verOrdenes(); break;
                case 7: demostrarPolimorfismo(); break;
                case 8:
                case -1:
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Gracias por usar gestor de SalmontAPP.");
                    break;
            }
        }
    }

    private static void demostrarPolimorfismo() {
        String reporte = gestor.generarReportePolimorfico();
        JTextArea area = new JTextArea(reporte, 20, 60);
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        JOptionPane.showMessageDialog(null, scroll, "Demostración de Polimorfismo (instanceof)",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static void agregarEmpleado() {
        try {
            String rut = JOptionPane.showInputDialog("RUT del empleado:");
            if (rut == null || rut.trim().isEmpty()) return;

            String nombre = JOptionPane.showInputDialog("Nombre del empleado:");
            if (nombre == null || nombre.trim().isEmpty()) return;

            String calle = JOptionPane.showInputDialog("Calle:");
            if (calle == null || calle.trim().isEmpty()) return;
            String numero = JOptionPane.showInputDialog("Numero:");
            if (numero == null || numero.trim().isEmpty()) return;
            String ciudad = JOptionPane.showInputDialog("Ciudad:");
            if (ciudad == null || ciudad.trim().isEmpty()) return;

            Direccion direccion = new Direccion(calle, ciudad, numero);
            String cargo = JOptionPane.showInputDialog("Puesto de trabajo de " + nombre + ":");
            if (cargo == null || cargo.trim().isEmpty()) return;

            String salarioTexto = JOptionPane.showInputDialog("Salario de " + nombre + ":");
            if (salarioTexto == null || salarioTexto.trim().isEmpty()) return;
            double salario = Double.parseDouble(salarioTexto);

            Empleado nuevoEmpleado = new Empleado(rut, nombre, direccion, cargo, salario);
            gestor.agregarPersona(nuevoEmpleado);
            JOptionPane.showMessageDialog(null, "Empleado agregado: " + nombre);

        } catch (MiExcepcion e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese datos validos.");
        }
    }

    private static void agregarCliente() {
        try {
            String rut = JOptionPane.showInputDialog("RUT del cliente:");
            if (rut == null || rut.trim().isEmpty()) return;

            String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
            if (nombre == null || nombre.trim().isEmpty()) return;

            String calle = JOptionPane.showInputDialog("Calle:");
            if (calle == null || calle.trim().isEmpty()) return;
            String numero = JOptionPane.showInputDialog("Numero:");
            if (numero == null || numero.trim().isEmpty()) return;
            String ciudad = JOptionPane.showInputDialog("Ciudad:");
            if (ciudad == null || ciudad.trim().isEmpty()) return;

            Direccion direccion = new Direccion(calle, ciudad, numero);
            String telefono = JOptionPane.showInputDialog("Telefono del cliente:");

            Cliente nuevoCliente = new Cliente(rut, nombre, direccion, telefono);
            gestor.agregarPersona(nuevoCliente);
            JOptionPane.showMessageDialog(null, "Cliente agregado: " + nombre);

        } catch (MiExcepcion e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese datos validos.");
        }
    }

    private static void agregarProveedor() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del proveedor:");
            if (nombre == null || nombre.trim().isEmpty()) return;

            String producto = JOptionPane.showInputDialog("Producto ofrecido por " + nombre + ":");
            if (producto == null || producto.trim().isEmpty()) return;

            String aniosTexto = JOptionPane.showInputDialog("Años de servicio de " + nombre + ":");
            if (aniosTexto == null || aniosTexto.trim().isEmpty()) return;
            int anios = Integer.parseInt(aniosTexto);

            Proveedor nuevoProveedor = new Proveedor(nombre, producto, anios);
            gestor.agregarProveedor(nuevoProveedor);
            JOptionPane.showMessageDialog(null, "Proveedor agregado: " + nombre);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese datos validos.");
        }
    }

    private static void agregarProducto() {
        try {
            String codigo = JOptionPane.showInputDialog("Codigo del producto:");
            if (codigo == null || codigo.trim().isEmpty()) return;

            String nombre = JOptionPane.showInputDialog("Nombre del producto:");
            if (nombre == null || nombre.trim().isEmpty()) return;

            String precioTexto = JOptionPane.showInputDialog("Precio del producto:");
            if (precioTexto == null || precioTexto.trim().isEmpty()) return;
            double precio = Double.parseDouble(precioTexto);

            Producto nuevoProducto = new Producto(codigo, nombre, precio);
            gestor.agregarProducto(nuevoProducto);
            JOptionPane.showMessageDialog(null, "Producto agregado: " + nombre);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese datos validos.");
        }
    }

    private static void crearOrdenCompra() {
        try {
            String rutCliente = JOptionPane.showInputDialog("RUT del cliente para la orden:");
            if (rutCliente == null || rutCliente.trim().isEmpty()) return;

            Persona persona = gestor.buscarPersonaPorRut(rutCliente);
            if (!(persona instanceof Cliente)) {
                JOptionPane.showMessageDialog(null, "No se encontro cliente con ese RUT.");
                return;
            }

            Cliente cliente = (Cliente) persona;
            OrdenDeCompra orden = new OrdenDeCompra(cliente);

            List<Producto> productos = gestor.getProductos();
            if (productos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay productos registrados.");
                return;
            }

            boolean agregarMas = true;
            while (agregarMas) {
                StringBuilder lista = new StringBuilder("Productos disponibles:\n");
                for (int i = 0; i < productos.size(); i++) {
                    lista.append(i + 1).append(". ").append(productos.get(i).getNombre())
                            .append(" - $").append(productos.get(i).getPrecio()).append("\n");
                }
                lista.append("0. Terminar\n");
                String seleccion = JOptionPane.showInputDialog(lista.toString() + "Ingrese numero del producto:");
                if (seleccion == null || seleccion.trim().isEmpty()) return;
                int opcion = Integer.parseInt(seleccion);
                if (opcion == 0) {
                    agregarMas = false;
                } else if (opcion > 0 && opcion <= productos.size()) {
                    orden.agregarProducto(productos.get(opcion - 1));
                    JOptionPane.showMessageDialog(null, "Producto agregado.");
                }
            }

            gestor.agregarOrden(orden);
            JOptionPane.showMessageDialog(null, "Orden #" + orden.getNumero() + " creada.\nTotal: $" + orden.getTotal());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private static void mostrarResumen() {
        List<Registrable> entidades = gestor.getUnidades();
        if (entidades.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay entidades.");
            return;
        }

        int centros = 0, plantas = 0, proveedores = 0, empleados = 0, clientes = 0, productos = 0;
        StringBuilder resumen = new StringBuilder("..:RESUMEN DEL SISTEMA:..\n\n");

        for (Registrable entidad : entidades) {
            if (entidad instanceof CentroCultivo) {
                centros++;
                CentroCultivo c = (CentroCultivo) entidad;
                resumen.append("Centro: ").append(c.getNombre()).append("\n");
            } else if (entidad instanceof PlantaProceso) {
                plantas++;
                PlantaProceso p = (PlantaProceso) entidad;
                resumen.append("Planta: ").append(p.getNombre()).append("\n");
            } else if (entidad instanceof Proveedor) {
                proveedores++;
                Proveedor pr = (Proveedor) entidad;
                resumen.append("Proveedor: ").append(pr.getNombre()).append("\n");
            } else if (entidad instanceof Empleado) {
                empleados++;
                Empleado e = (Empleado) entidad;
                resumen.append("Empleado: ").append(e.getNombre()).append("\n");
            } else if (entidad instanceof Cliente) {
                clientes++;
                Cliente c = (Cliente) entidad;
                resumen.append("Cliente: ").append(c.getNombre()).append("\n");
            } else if (entidad instanceof Producto) {
                productos++;
                Producto p = (Producto) entidad;
                resumen.append("Producto: ").append(p.getNombre()).append("\n");
            }
        }

        resumen.append("\n..:RESUMEN SALMONTTAPP:..\n");
        resumen.append("Centros: ").append(centros).append("\n");
        resumen.append("Plantas: ").append(plantas).append("\n");
        resumen.append("Proveedores: ").append(proveedores).append("\n");
        resumen.append("Empleados: ").append(empleados).append("\n");
        resumen.append("Clientes: ").append(clientes).append("\n");
        resumen.append("Productos: ").append(productos).append("\n");
        resumen.append("Total: ").append(entidades.size()).append(" entidades.");

        JTextArea area = new JTextArea(resumen.toString(), 20, 50);
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        JOptionPane.showMessageDialog(null, scroll, "Resumen", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void verOrdenes() {
        List<OrdenDeCompra> ordenes = gestor.getOrdenes();
        if (ordenes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ordenes pendientes.");
            return;
        }

        StringBuilder sb = new StringBuilder("Ordenes de Compra Pendientes:\n\n");
        for (OrdenDeCompra orden : ordenes) {
            sb.append(orden.toString()).append("\n");
        }

        JTextArea area = new JTextArea(sb.toString(), 15, 40);
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        JOptionPane.showMessageDialog(null, scroll, "Ordenes", JOptionPane.INFORMATION_MESSAGE);
    }
}