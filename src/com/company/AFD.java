package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

public class AFD {
    public  String text;
    public char[] cadena;
    public int cont;
    public int conte;
    public boolean aceptado=true;
    public TablaSimbolos tablaSimbolos ;
    public ArrayList<ElementoTablaSimbolos> palabras;
    String palabraActual="";


    public AFD(String text) {
        this.tablaSimbolos= new TablaSimbolos();
        this.palabras= new ArrayList<>();
        this.text = text;
        this.cadena= text.toCharArray();
        conte=0;
        cont=0;
        q0();

    }


    public void q0(){
        if(cont<cadena.length) {
            if (Character.isLetter(cadena[cont]) || cadena[cont]== '$') {
                palabraActual+=cadena[cont];
                cont++;
                q1();

            }
            else if (Character.isDigit(cadena[cont])) {
                palabraActual+=cadena[cont];
                cont++;
                q1n();

            }

            else if (cadena[cont] == '_') {
                cont++;
                q2();
            }
            else if (cadena[cont] == '.') {
                palabraActual+=cadena[cont];
                cont++;
                q1n2();
            }
            else if (cadena[cont] == '<') {
                palabraActual+=cadena[cont];
                cont++;
                q4();
            }
            else if (cadena[cont] == '>') {
                palabraActual+=cadena[cont];
                cont++;
                q5();
            }
            else if (cadena[cont] == '=') {
                palabraActual+=cadena[cont];
                cont++;
                q6();
            }

            else if (cadena[cont] == '!') {
                palabraActual+=cadena[cont];
                cont++;
                q7();
            }
            else if (cadena[cont] == '&') {
                palabraActual+=cadena[cont];
                cont++;
                q8();
            }
            else if (cadena[cont] == '|') {
                palabraActual+=cadena[cont];
                cont++;
                q9();
            }
            else if (cadena[cont] == '^') {
                palabraActual+=cadena[cont];
                cont++;
                q10();
            }
            else if (cadena[cont] == '+' || cadena[cont] == '-' ||cadena[cont] == '*'||cadena[cont] == '/'
                    || cadena[cont] == '%') {
                palabraActual+=cadena[cont];
                cont++;
                q3();
            }
            else if (cadena[cont] == '[') {
                palabraActual+=cadena[cont];
                cont++;
                q11();
            }
            else{
                if(cadena[cont]!='@'){
                    aceptado=false;
                }
                cont++;
                q0();
            }
        }
        }

    public void q1(){
        if (cont<cadena.length) {
            if (Character.isLetterOrDigit(cadena[cont]) || cadena[cont] == '_' || cadena[cont]=='$') {
                palabraActual+=cadena[cont];
                cont++;
                q1();
            } else {
                if(tablaSimbolos.tablaSimbolos.contains(new ElementoTablaSimbolos(palabraActual,"",null))){
                    palabras.add(new ElementoTablaSimbolos(palabraActual,palabraActual,null));
                }
                else{
                    palabras.add(new ElementoTablaSimbolos(palabraActual,"id",null));
                }
                palabraActual="";
                q0();

                //palabras.add(new ElementoTablaSimbolos(palabraActual,"id",null));
                //palabraActual="";
                //q0();

            }
        }
    }
    public void q1n(){
        if (cont<cadena.length) {
            if (Character.isDigit(cadena[cont])) {
                palabraActual+=cadena[cont];
                cont++;
                q1n();
            }
            else if(Character.isLetter(cadena[cont])){
                palabraActual="";
                aceptado=false;
                cont=cadena.length-1;
            }
            else if(cadena[cont]=='.'){
                palabraActual+=cadena[cont];
                cont++;
                q1n2();
            }
            else {
                palabras.add(new ElementoTablaSimbolos(palabraActual,"int",null));
                palabraActual="";
                q0();

            }
        }
    }
    public void q1n2(){
        if (cont<cadena.length) {
            if (Character.isDigit(cadena[cont])) {
                palabraActual += cadena[cont];
                cont++;
                q1n3();
            }
            else {
                palabraActual="";
                aceptado=false;
                cont=cadena.length-1;
            }
        }
    }
    public void q1n3(){
        if (cont<cadena.length) {
            if (Character.isDigit(cadena[cont])) {
                palabraActual += cadena[cont];
                cont++;
                q1n3();
            }
            else if(Character.isLetter(cadena[cont]) || cadena[cont]=='_' || cadena[cont]=='$'){
                palabraActual="";
                aceptado=false;
                cont=cadena.length-1;
            }
            else {
                palabras.add(new ElementoTablaSimbolos(palabraActual,"double",null));
                palabraActual="";
                q0();
            }
        }
    }
    public void q2(){
        if(cont<cadena.length) {
            if (cadena[cont] == '_') {
                cont++;
                q2();
            } else if (Character.isLetterOrDigit(cadena[cont]) || cadena[cont]=='$') {
                palabraActual+=cadena[cont];
                cont++;
                q1();
            } else {
                palabraActual="";
                aceptado=false;
                cont=cadena.length-1;
            }
        }
    }
    public void q3(){
        if(cont<cadena.length) {
            if (cadena[cont] == '=') {
                palabraActual+=cadena[cont];
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opas",null));
                palabraActual="";
                cont++;
                q0();
            }
            else {
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opa",null));
                palabraActual="";
                q0();
            }
        }
        }

    public void q4(){
        if(cont<cadena.length) {
            if (cadena[cont] == '=' ||cadena[cont] == '>') {
                palabraActual+=cadena[cont];
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opr",null));
                palabraActual="";
                cont++;
                q0();
            } else {
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opr",null));
                palabraActual="";
                q0();
            }
        }
    }
    public void q5(){
        if(cont<cadena.length) {
            if (cadena[cont] == '=') {
                palabraActual+=cadena[cont];
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opr",null));
                palabraActual="";
                cont++;
                q0();
            } else {
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opr",null));
                palabraActual="";
                q0();
            }
        }
    }
    public void q6(){
        if(cont<cadena.length) {
            if (cadena[cont] == '=') {
                palabraActual+=cadena[cont];
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opr",null));
                palabraActual="";
                cont++;
                q0();
            } else {
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opas",null));
                palabraActual="";
                q0();
            }
        }
    }
    public void q7(){
        if(cont<cadena.length) {
            if (cadena[cont] == '=') {
                palabraActual+=cadena[cont];
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opr",null));
                palabraActual="";
                cont++;
                q0();
            } else {
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opb",null));
                palabraActual="";
                q0();
            }
        }
    }
    public void q8(){
        if(cont<cadena.length) {
            if (cadena[cont] == '&') {
                palabraActual+=cadena[cont];
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opb",null));
                palabraActual="";
                cont++;
                q0();
            }
            else if(cadena[cont] == '='){
                palabraActual+=cadena[cont];
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opas",null));
                palabraActual="";
                cont++;
                q0();
            }else {
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opb",null));
                palabraActual="";
                q0();
            }
        }
    }
    public void q9(){
        if(cont<cadena.length) {
            if (cadena[cont] == '|') {
                palabraActual+=cadena[cont];
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opb",null));
                palabraActual="";
                cont++;
                q0();
            }
            else if(cadena[cont] == '='){
                palabraActual+=cadena[cont];
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opas",null));
                palabraActual="";
                cont++;
                q0();
            }
            else {
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opb",null));
                palabraActual="";
                q0();
            }
        }
    }
    public void q10(){
        if(cont<cadena.length) {
            if (cadena[cont] == '=') {
                palabraActual+=cadena[cont];
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opas",null));
                palabraActual="";
                cont++;
                q0();
            }
            else {
                palabras.add(new ElementoTablaSimbolos(palabraActual,"opb",null));
                palabraActual="";
                q0();
            }
        }
    }
    public void q11(){
        if(cont<cadena.length) {
            if (cadena[cont] == ']') {
                palabraActual+=cadena[cont];
                cont++;
                q12();
            }
            else if(Character.isDigit(cadena[cont])){
                palabraActual+=cadena[cont];
                cont++;
                q14();
            }
            else {
                palabraActual="";
                aceptado=false;
                cont=cadena.length-1;
            }
        }
    }

    public void q12(){
        if(cont<cadena.length) {
            if (cadena[cont] == '[') {
                palabraActual+=cadena[cont];
                cont++;
                q11();
            }
            else {
                palabras.add(new ElementoTablaSimbolos(palabraActual,"arraydec",null));
                palabraActual="";
                q0();
            }
        }
    }
    public void q14(){
        if(cont<cadena.length) {
            if(Character.isDigit(cadena[cont])){
                palabraActual+=cadena[cont];
                cont++;
                q14();
            }
            else if (cadena[cont] == ']') {
                palabraActual+=cadena[cont];
                cont++;
                q12();
            }
            else {
                palabraActual="";
                aceptado=false;
                cont=cadena.length-1;
            }
        }
    }




}
