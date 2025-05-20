package iessanalberto.dam1.models;

public class Apto extends Opositor {
    private String isApto;

    public Apto(String linea) {
        String [] lineaTroceada = linea.split(";");
        this.dni = lineaTroceada[0];
        this.nombre = lineaTroceada[1];
        this.apellidos = lineaTroceada[2];
        this.especialidad = lineaTroceada[3];
        this.isApto = lineaTroceada[4];

    }

    public String getIsApto() {
        return isApto;
    }
}
