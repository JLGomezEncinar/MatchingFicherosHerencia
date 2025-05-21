package iessanalberto.dam1.models;

public class Notas extends Opositor{
    private float practica;
    private float teorica;

    public Notas(String linea) {
        super(linea);
        String [] lineaTroceada = linea.split(";");
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
