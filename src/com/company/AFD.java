package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AFD {
 public FileReader archivo;
 public int _character;

    public AFD(String archivo) {
            String content = "";
            try
            {
                content = new String (Files.readAllBytes(Paths.get(archivo)));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }


    public void imprimir(){
        try {
            int _character;
            while ((_character = archivo.read()) != -1) {
                System.out.print((char) _character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void q0(){
        try {
            if((_character = archivo.read()) !=-1 &&  (Character.isLetter((char) _character))){
             q1();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void q1(){
        try {
            if((_character = archivo.read()) !=-1 &&  (Character.isLetter((char) _character))){
                System.out.print((char) _character);
                q1();
            }
            else{
                System.out.println("Esta correcto");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
