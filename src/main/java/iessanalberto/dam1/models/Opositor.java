package iessanalberto.dam1.models;

public class Opositor {
    protected String dni;
    protected String nombre;
    protected String apellidos;
    protected String especialidad;

    public Opositor(String linea) {
        String [] lineaTroceada = linea.split(";");
        this.dni = lineaTroceada[0];
        this.nombre = lineaTroceada[1];
        this.apellidos = lineaTroceada[2];
        this.especialidad = lineaTroceada[3];
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +"\n"
                ;
    }
}
