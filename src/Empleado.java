
public class Empleado {

    String nombre;
    String cargo;
    double salario;

    public Empleado(String nombre, String cargo, double salario) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int contarCantidad() {
        return 1;
    }

    public void mostrarEmpleado() {

        System.out.println("Nombre: " + nombre);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salario: " + salario);

    }

}
