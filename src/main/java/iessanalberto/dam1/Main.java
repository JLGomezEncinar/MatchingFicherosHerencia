package iessanalberto.dam1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;





import models.Apto;
import models.Notas;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
                        if (resultados.getDni().equals(listados.getDni())) {
                            if (listados.getIsApto().equals("APTO")&& listados.getEspecialidad().equals("Informática")) {
                                if (resultados.getPractica() >= 4 && resultados.getTeorica() > 4 && resultados.mediaNotas() >= 5) {
                                    ficheroAprobados.write(resultados.toString() + ", Nota media: " + resultados.mediaNotas() + "\n");
                                } else {
                                    ficheroSuspensos.write(resultados.toString() + ", Nota media: " + resultados.mediaNotas() + "\n");
                                }
                            } else if (listados.getIsApto().equals("NO APTO")&& listados.getEspecialidad().equals("Informática")){
                                ficheroExcluidos.write(listados.toString());
                            }
                            claveA = ficheroResultados.readLine();
                            claveB = ficheroListados.readLine();
                        } else if (Integer.parseInt(resultados.getDni().substring(0,resultados.getDni().length()-1))>Integer.parseInt(listados.getDni().substring(0,listados.getDni().length()-1))){
                            if (listados.getIsApto().equals("APTO")&& listados.getEspecialidad().equals("Informática")) {
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
                        if (listados.getIsApto().equals("APTO")&& resultados.getEspecialidad().equals("Informática")) {
                            ficheroNoPresentados.write(listados.getDni()+listados.getNombre()+listados.getApellidos()+"\n");
                        }
                        claveB = ficheroListados.readLine();
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);

                }
            }
        }

