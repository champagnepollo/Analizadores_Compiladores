package com.company;
import java.io.FileReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        AnalizadorLexico analizador = new AnalizadorLexico("archivo.txt");
        analizador.imprimir();

    }
}
