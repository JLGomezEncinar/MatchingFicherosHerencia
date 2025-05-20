package iessanalberto.dam1;

import iessanalberto.dam1.models.Apto;
import iessanalberto.dam1.models.Notas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;










        public class Main {
            public static void main(String[] args) {
                try (
                        BufferedReader ficheroResultados = new BufferedReader(new FileReader("resultados.txt"));
                        BufferedReader ficheroListados = new BufferedReader(new FileReader("listados.txt"));
                        FileWriter ficheroAprobados = new FileWriter("aprobados.txt");
                        FileWriter ficheroSuspensos = new FileWriter("suspensos.txt");
                        FileWriter ficheroExcluidos = new FileWriter("excluidos.txt");
                        FileWriter ficheroNoPresentados = new FileWriter("nopresentados.txt");)
                {
                    String claveA = ficheroResultados.readLine();
                    String claveB = ficheroListados.readLine();
                    Notas resultados = null;
                    Apto listados = null;
                    while(claveA !=null && claveB !=null){
                        resultados = new Notas(claveA);
                        listados = new Apto(claveB);
                        if (resultados.getDni().compareTo(listados.getDni()) == 0) {
                            if (listados.getIsApto().equals("Apto")&& listados.getEspecialidad().equals("Informática")) {
                                if (resultados.getPractica() >= 4 && resultados.getTeorica() > 4 && resultados.mediaNotas() >= 5) {
                                    ficheroAprobados.write(resultados + ", Nota media: " + resultados.mediaNotas() + "\n");
                                } else {
                                    ficheroSuspensos.write(resultados + ", Nota media: " + resultados.mediaNotas() + "\n");
                                }
                            } else if (listados.getIsApto().equals("No apto")&& listados.getEspecialidad().equals("Informática")){
                                ficheroExcluidos.write(listados.toString());
                            }
                            claveA = ficheroResultados.readLine();
                            claveB = ficheroListados.readLine();
                        } else if (resultados.getDni().compareTo(listados.getDni()) > 0){
                            if (listados.getIsApto().equals("Apto")&& listados.getEspecialidad().equals("Informática")) {
                                ficheroNoPresentados.write(listados.toString());
                            }claveB = ficheroListados.readLine();
                        } else {
                            throw new IllegalArgumentException("Error en la lista de resultados");

                        }
                    }
                    while (claveA != null) {
                        throw new IllegalArgumentException("Error en la lista de resultados");
                    }
                    while (claveB != null){
                        listados = new Apto(claveB);
                        if (listados.getIsApto().equals("Apto")&& listados.getEspecialidad().equals("Informática")) {
                            ficheroNoPresentados.write(listados.toString());
                        }
                        claveB = ficheroListados.readLine();
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);

                }
            }
        }

