
public class Inventario {

    Producto[] productos;

    public Inventario(Producto[] productos) {
        this.productos = productos;
    }

    public int contarCantidad() {
        return productos.length;
    }

    public int contarProductosBajos() {

        int contador = 0;

        for (int i = 0; i < productos.length; i++) {

            if (productos[i].cantidad < 10) {
                contador = contador + 1;
            }

        }

        return contador;
    }

    public void mostrarInventario() {

        System.out.println("Total de productos: " + contarCantidad());

        System.out.println("Productos con menos de 10 unidades: " + contarProductosBajos());

    }

}
