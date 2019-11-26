package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class AnalizadorLexico {
    public String content;
    public char[] buffer;
    public StringBuilder errores= new StringBuilder();
    public String erroress = "Errores lexicos encontrados\n";

    public AnalizadorLexico(String archivo,String texto) {
        content = "";
        content = texto;
        buffer=content.toCharArray();
        System.out.println(texto);
    }

    public ArrayList<ElementoTablaSimbolos> Analizar(TablaSimbolos tablaSimbolos){
        ArrayList<ElementoTablaSimbolos> tablaSimbolosEncontrados= new ArrayList<>();
            String palabra = content;
                AFD automata = new AFD(palabra+'@');
                for (ElementoTablaSimbolos elemento:
                        automata.palabras) {
                    tablaSimbolosEncontrados.add(elemento);
                    if(!tablaSimbolos.tablaSimbolos.contains(elemento)){
                        tablaSimbolos.agregarElemento(elemento);
                    }
                }
        erroress+=automata.errores;
        return tablaSimbolosEncontrados;
    }

    public void imprimir() {
        System.out.println(content);
    }

}

