package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AnalizadorLexico {
    private FileReader archivo;
    private int _character;
    private String content;

    public AnalizadorLexico(String archivo) {
        content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(archivo)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void imprimir() {
        System.out.println(content);
    }

}

