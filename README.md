# 🐟 Sistema de Gestión Salmontt - Evaluación Final Transversal

## 📋 Descripción del Proyecto

Prototipo de software modular para la empresa salmonera Salmontt que implementa los principios de Programación Orientada a Objetos para gestionar empleados, clientes, proveedores, productos y órdenes de compra.

## 🚀 Características Técnicas

- ✅ **Encapsulamiento**: Atributos privados con getters/setters
- ✅ **Herencia**: Jerarquía Persona → Empleado/Cliente
- ✅ **Polimorfismo**: Interfaz Registrable implementada por múltiples clases
- ✅ **Colecciones**: ArrayList para gestión de entidades
- ✅ **Archivos externos**: Carga de datos desde .txt
- ✅ **GUI**: Menú interactivo con JOptionPane

## 📥 Instrucciones de Ejecución

1. **Crear estructura de carpetas** como se muestra arriba
2. **Copiar archivos .txt** en carpeta `data/`:

personas.txt
productos.txt
proveedores.txt

3. **Ejecutar** `Main.java` desde el paquete `app`

## 📊 Funcionalidades

1. Agregar Empleado/Cliente/Proveedor/Producto
2. Crear Órdenes de Compra
3. Mostrar Resumen del Sistema
4. Demostración de Polimorfismo (instanceof)

## 🧪 Datos de Prueba

El sistema carga automáticamente desde archivos `.txt` en formato:
personas.txt: RUT;Nombre;Calle;Ciudad;Número;Tipo;InfoExtra
productos.txt: Código;Nombre;Precio
proveedores.txt: Nombre;Producto;AñosServicio


## 📝 Principios POO Aplicados

| Principio | Implementación |
|-----------|----------------|
| Encapsulamiento | Atributos private con getters/setters |
| Herencia | Persona → Empleado, Persona → Cliente |
| Polimorfismo | Método mostrarResumen() @Override |
| Composición | Persona tiene Direccion |
| Interfaces | Registrable implementada por 5+ clases |

## 📚 Información Académica

**Asignatura**: Desarrollo Orientado a Objetos I
**Institución**: Duoc UC - Escuela de Informática y Telecomunicaciones  
**Modalidad**: Online  
**Evaluación**: Final Transversal (EFT)

## 👨‍💻 Estudiante

Pablo Nicolás Alonso Gallardo Gallardo  
2do Bimestre
