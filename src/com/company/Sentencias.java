package com.company;

import java.util.ArrayList;

public class Sentencias {

    public static ArrayList<Sentencia> expresiones = new ArrayList<>();

    public static void add(Sentencia tt){

        Sentencias.expresiones.add( tt );
        System.out.println(Sentencias.expresiones.size());
    }
}