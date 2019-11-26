package com.company;

import java.util.ArrayList;

public class Expresiones {

    public static ArrayList< Expresion > expresiones = new ArrayList<>();

    public static void add(Expresion tt){

        Expresiones.expresiones.add( tt );
        System.out.println(Expresiones.expresiones.size());
    }




}