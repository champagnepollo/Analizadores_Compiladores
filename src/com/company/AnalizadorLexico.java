package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class AnalizadorLexico {
    private FileReader archivo;
    private int contb=0;
    private int contl=1;
    public String content;
    public char[] buffer;
    public StringBuilder errores= new StringBuilder();
    public String erroress;
    public boolean ultimo=false;

    public AnalizadorLexico(String archivo,String texto) {
        content = "";
        //try {
            //content = new String(Files.readAllBytes(Paths.get(archivo)));
            //buffer=content.toCharArray();
        //} catch (IOException e) {
            //e.printStackTrace();
        //}
        content = texto;
        buffer=content.toCharArray();
        System.out.println(texto);
    }

    public String encontrarPalabra(){
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!(buffer[contb] == ' ' || buffer[contb] == ';' ||buffer[contb] == '\n'||buffer[contb] == '\r'|| buffer[contb] == '{'
                    ||buffer[contb] == '}' ||buffer[contb] == '(' ||buffer[contb] == ')' ||buffer[contb] == ',' )){
                sb.append(buffer[contb]);
                System.out.println("ua");
            if (contb == content.length()-1 ) {
                ultimo=true;
                System.out.println("y");
                break;
            }
            }
            else{
                System.out.println(contl);
                if(buffer[contb] == '\n'||buffer[contb] == '\r'){
                    contl++;
                }
                System.out.println("marca1");
                contb++;
                break;
            }
            System.out.println("marca2");
            contb++;
        }

        return sb.toString();

    }

    public ArrayList<ElementoTablaSimbolos> Analizar(TablaSimbolos tablaSimbolos){
        ArrayList<ElementoTablaSimbolos> tablaSimbolosEncontrados= new ArrayList<>();
        while (contb<content.length()){
            String palabra = encontrarPalabra();
            if(!palabra.equals("")){
                AFD automata = new AFD(palabra+'@');
                if(automata.aceptado){
                    System.out.println(palabra+ " Correcto");
                    errores.append(palabra+ "     Correcto      Linea " + contl);
                    errores.append(System.getProperty("line.separator"));
                }
                else{
                    System.out.println( palabra+" Error lexico");
                    errores.append(palabra+ "     Error Lexico  Linea "+contl);
                    errores.append(System.getProperty("line.separator"));
                }
                for (ElementoTablaSimbolos elemento:
                     automata.palabras) {
                    tablaSimbolosEncontrados.add(elemento);
                    if(!tablaSimbolos.tablaSimbolos.contains(elemento)){
                        tablaSimbolos.agregarElemento(elemento);
                    }
                }
            }
            if(ultimo){
                contb++;
            }
        }
        System.out.println("Tabla de simbolos");
        for (ElementoTablaSimbolos elemento:
             tablaSimbolos.tablaSimbolos) {
            System.out.println(elemento.ER+ " "+ elemento.ComponenteLexico +" " + elemento.Valor );
        }
        System.out.println("");
        System.out.println("Simbolos encontrados");
        for (ElementoTablaSimbolos elemento:
                tablaSimbolosEncontrados) {
            System.out.println(elemento.ER+ " "+ elemento.ComponenteLexico +" " + elemento.Valor );
        }
        erroress=errores.toString();
        return tablaSimbolosEncontrados;
    }


    public void imprimir() {
        System.out.println(content);
    }

}

