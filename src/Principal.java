
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Producto producto1 = new Producto("Arroz", 3000, 15);
        Producto producto2 = new Producto("Leche", 4500, 5);
        Producto producto3 = new Producto("Huevos", 12000, 8);
        Producto producto4 = new Producto("Aceite", 9000, 20);
        Producto producto5 = new Producto("Azucar", 4000, 3);

        Producto[] productos = {
            producto1, producto2, producto3, producto4, producto5
        };

        Inventario inventario = new Inventario(productos);

        Empleado empleado1 = new Empleado("Emmanuel", "Administrador", 1500000);
        Empleado empleado2 = new Empleado("Carlos", "Cajero", 1400000);

        Empleado[] empleados = {empleado1, empleado2};

        Venta[] ventas = {
            new Venta(1, 1, "2026-11-01", "Cliente 1"),
            new Venta(2, 2, "2026-11-02", "Cliente 2"),
            new Venta(3, 1, "2026-11-03", "Cliente 3"),
            new Venta(4, 2, "2026-11-04", "Cliente 4"),
            new Venta(5, 1, "2026-11-05", "Cliente 5")
        };

        DetalleVenta[] detalles = {
            new DetalleVenta(1, 1, 1, 2, 3000),
            new DetalleVenta(2, 1, 2, 1, 4500),
            new DetalleVenta(3, 2, 3, 1, 12000),
            new DetalleVenta(4, 3, 4, 2, 9000),
            new DetalleVenta(5, 4, 5, 3, 4000),
            new DetalleVenta(6, 5, 1, 4, 3000)
        };

        int opcion;

        do {

            System.out.println("\n===== MINI MERCADO EL RINCONCITO =====");
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Contar productos");
            System.out.println("4. Productos con pocas unidades");
            System.out.println("5. Salir");
            System.out.println("6. Consultar SQL Server");
            System.out.println("7. Mostrar ventas");
            System.out.println("8. Mostrar detalles de ventas");
            System.out.print("Seleccione una opcion: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    inventario.mostrarInventario();
                    break;

                case 2:
                    for (int i = 0; i < empleados.length; i++) {
                        empleados[i].mostrarEmpleado();
                    }
                    break;

                case 3:
                    System.out.println("Total de productos: "
                            + inventario.contarCantidad());
                    break;

                case 4:
                    System.out.println("Productos con menos de 10 unidades: "
                            + inventario.contarProductosBajos());
                    break;

                case 5:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;

                case 6:

                    String url = "jdbc:sqlserver://localhost:1433;"
                            + "databaseName=MiniMercadoElRinconcito;"
                            + "integratedSecurity=true;"
                            + "encrypt=true;"
                            + "trustServerCertificate=true;";

                    try (Connection conexion = DriverManager.getConnection(url)) {

                        System.out.println("\nConexion exitosa con SQL Server!");

                        System.out.println("\n===== PRODUCTOS =====");
                        consultarTabla(conexion, "Producto");

                        System.out.println("\n===== EMPLEADOS =====");
                        consultarTabla(conexion, "Empleado");

                        System.out.println("\n===== INVENTARIO =====");
                        consultarTabla(conexion, "Inventario");

                        System.out.println("\n===== VENTAS =====");
                        consultarTabla(conexion, "Venta");

                        System.out.println("\n===== DETALLES DE VENTAS =====");
                        consultarTabla(conexion, "DetalleVenta");

                    } catch (SQLException e) {
                        System.out.println("Error al conectar o consultar SQL Server:");
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("\n===== LISTA DE VENTAS =====");

                    for (int i = 0; i < ventas.length; i++) {
                        ventas[i].mostrarVenta();
                        System.out.println("--------------------");
                    }
                    break;

                case 8:
                    System.out.println("\n===== DETALLES DE VENTAS =====");

                    for (int i = 0; i < detalles.length; i++) {
                        detalles[i].mostrarDetalle();
                        System.out.println("--------------------");
                    }
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        entrada.close();
    }

    public static void consultarTabla(Connection conexion, String tabla)
            throws SQLException {

        String sql = "SELECT * FROM " + tabla;

        try (Statement consulta = conexion.createStatement();
             ResultSet resultado = consulta.executeQuery(sql)) {

            ResultSetMetaData columnas = resultado.getMetaData();

            int cantidadColumnas = columnas.getColumnCount();

            for (int i = 1; i <= cantidadColumnas; i++) {
                System.out.print(columnas.getColumnName(i) + "\t");
            }

            System.out.println();

            while (resultado.next()) {
                for (int i = 1; i <= cantidadColumnas; i++) {
                    System.out.print(resultado.getObject(i) + "\t");
                }
                System.out.println();
            }
        }
    }
}
