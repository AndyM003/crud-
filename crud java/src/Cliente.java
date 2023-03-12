public class Cliente extends Personas{

    //Variables
    private int factura;
    private String producto;
    private double precio;

    //Constructor
    public Cliente(String nombre, String apellido, int edad, int factura, String producto, double precio){
        super(nombre, apellido, edad);
        this.factura = factura;
        this.producto = producto;
        this.precio = precio;
    }

    //Getters
    public int getFactura(){
        return factura;
    }

    public String getProducto(){
        return producto;
    }

    public double getPrecio() {
        return precio;
    }

    //Setters
    public void setFactura(int factura) {
        this.factura = factura;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //Metodos
    public void mostrarCliente(){
        System.out.println("\nNombre: " + getNombre() +
                "\nApellido: " + getApellido() +
                "\nEdad: " + getEdad() +
                "\nFactura: " + factura +
                "\nProducto: " + producto +
                "\nPrecio: " + precio);
    }
}
