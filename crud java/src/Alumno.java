public class Alumno extends Personas{

    //Variables
    private int idAlumno;
    private String materia;
    private double nota;

    //Constructor
    public Alumno(String nombre, String apellido, int edad, int idAlumno, String materia, double nota){
        super(nombre, apellido, edad);
        this.idAlumno = idAlumno;
        this.materia = materia;
        this.nota = nota;
    }

    //Getters
    public int getIdAlumno(){
        return idAlumno;
    }

    public String getMateria(){
        return materia;
    }

    public double getNota(){
        return nota;
    }

    //Setters
    public void setIdAlumno(int idAlumno){
        this.idAlumno = idAlumno;
    }

    public void setMateria(String materia){
        this.materia = materia;
    }

    public void setNota (double nota){
        this.nota = nota;
    }

    //Mostrar Alumno
    public void mostrarAlumno(){
        System.out.println("\nNombre: " + getNombre() +
                "\nApellido: " + getApellido() +
                "\nEdad: " + getEdad() +
                "\nID alumno: " + idAlumno +
                "\nMateria: " + materia +
                "\nnota: " + nota);
    }
}

