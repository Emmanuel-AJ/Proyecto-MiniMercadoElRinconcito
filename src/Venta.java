
public class Venta {

    int idVenta;
    int idEmpleado;
    String fecha;
    String cliente;

    public Venta(int idVenta, int idEmpleado, String fecha, String cliente) {
        this.idVenta = idVenta;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public void mostrarVenta() {

        System.out.println("ID Venta: " + idVenta);
        System.out.println("ID Empleado: " + idEmpleado);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente);

    }

}
