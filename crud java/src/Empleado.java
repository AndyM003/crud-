public class Empleado extends Personas{
    //Variables
    private int idCarnet;
    private double sueldo;

    //Constructor
    public Empleado(String nombre, String apellido, int edad, int idCarnet, double sueldo){
        super(nombre, apellido, edad);
        this.idCarnet = idCarnet;
        this.sueldo = sueldo;
    }

    //Getters
    public int getIdCarnet(){
        return idCarnet;
    }

    public double getSueldo() {
        return sueldo;
    }

    //Setters
    public void setIdCarnet(int idCarnet){
        this.idCarnet = idCarnet;
    }

    public void setSueldo(double sueldo){
        this.sueldo = sueldo;
    }

    //Metodo mostrar
    public void mostrarEmpleado(){
        System.out.println("\nNombre: " + getNombre() +
                "\nApellido: " + getApellido() +
                "\nEdad: " + getEdad() +
                "\nID carnet: " + idCarnet +
                "\nSueldo: " + sueldo);
    }

}
