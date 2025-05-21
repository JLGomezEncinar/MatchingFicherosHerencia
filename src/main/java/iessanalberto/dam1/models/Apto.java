package iessanalberto.dam1.models;

public class Apto extends Opositor {
    private String isApto;

    public Apto(String linea) {
        super(linea);
        String [] lineaTroceada = linea.split(";");
        this.isApto = lineaTroceada[4];

    }

    public String getIsApto() {
        return isApto;
    }
}
