package iessanalberto.dam1.models;

public class Notas extends Opositor{
    private float practica;
    private float teorica;

    public Notas(String linea) {
        String [] lineaTroceada = linea.split(";");
        this.dni = lineaTroceada[0];
        this.nombre = lineaTroceada[1];
        this.apellidos = lineaTroceada[2];
        this.especialidad = lineaTroceada[3];
        this.practica = Float.parseFloat(lineaTroceada[4]);
        this.teorica = Float.parseFloat(lineaTroceada[5]);
    }

    public float getPractica() {
        return practica;
    }

    public float getTeorica() {
        return teorica;
    }
    public float mediaNotas() {
        return (practica+teorica)/2;
    }

    @Override
    public String toString() {
        return

                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                        ", practica=" + practica + '\'' +
                        ", teorica=" + teorica
                ;
    }
}
