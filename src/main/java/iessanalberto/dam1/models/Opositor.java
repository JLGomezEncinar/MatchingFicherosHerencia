package iessanalberto.dam1.models;

public class Opositor {
    protected String dni;
    protected String nombre;
    protected String apellidos;
    protected String especialidad;

    public Opositor() {
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
