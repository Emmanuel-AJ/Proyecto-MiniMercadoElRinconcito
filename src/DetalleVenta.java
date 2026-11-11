
public class DetalleVenta {

    int idDetalle;
    int idVenta;
    int idProducto;
    int cantidad;
    double precioUnitario;

    public DetalleVenta(int idDetalle, int idVenta, int idProducto,
            int cantidad, double precioUnitario) {

        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;

    }

    public void mostrarDetalle() {

        System.out.println("ID Detalle: " + idDetalle);
        System.out.println("ID Venta: " + idVenta);
        System.out.println("ID Producto: " + idProducto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio Unitario: " + precioUnitario);

    }

}
