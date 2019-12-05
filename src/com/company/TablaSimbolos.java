package com.company;

import java.util.ArrayList;

public class TablaSimbolos {
    public static ArrayList<ElementoTablaSimbolos> tablaSimbolos;

    public TablaSimbolos() {
        this.tablaSimbolos = new ArrayList<>();
//        tablaSimbolos.add(new ElementoTablaSimbolos("char|double|float|int|long|short|string","tipo"));
//        tablaSimbolos.add(new ElementoTablaSimbolos("","reservada"));
        tablaSimbolos.add(new ElementoTablaSimbolos("abstract","modif"));
        tablaSimbolos.add(new ElementoTablaSimbolos("assert","assert"));
        tablaSimbolos.add(new ElementoTablaSimbolos("true","boolean"));
        tablaSimbolos.add(new ElementoTablaSimbolos("false","boolean"));
        tablaSimbolos.add(new ElementoTablaSimbolos("boolean","tipo"));
        tablaSimbolos.add(new ElementoTablaSimbolos("break","break"));
        tablaSimbolos.add(new ElementoTablaSimbolos("byte","byte"));
        tablaSimbolos.add(new ElementoTablaSimbolos("case","case"));
        tablaSimbolos.add(new ElementoTablaSimbolos("catch","catch"));
        tablaSimbolos.add(new ElementoTablaSimbolos("char","tipo"));
        tablaSimbolos.add(new ElementoTablaSimbolos("class","class"));
        tablaSimbolos.add(new ElementoTablaSimbolos("const","const"));
        tablaSimbolos.add(new ElementoTablaSimbolos("continue","continue"));
        tablaSimbolos.add(new ElementoTablaSimbolos("default","default"));
        tablaSimbolos.add(new ElementoTablaSimbolos("do","do"));
        tablaSimbolos.add(new ElementoTablaSimbolos("double","tipo"));
        tablaSimbolos.add(new ElementoTablaSimbolos("else","else"));
        tablaSimbolos.add(new ElementoTablaSimbolos("enum","enum"));
        tablaSimbolos.add(new ElementoTablaSimbolos("extends","extends"));
        tablaSimbolos.add(new ElementoTablaSimbolos("final","modif"));
        tablaSimbolos.add(new ElementoTablaSimbolos("finally","finally"));
        tablaSimbolos.add(new ElementoTablaSimbolos("float","tipo"));
        tablaSimbolos.add(new ElementoTablaSimbolos("for","for"));
        tablaSimbolos.add(new ElementoTablaSimbolos("goto","goto"));
        tablaSimbolos.add(new ElementoTablaSimbolos("if","if"));
        tablaSimbolos.add(new ElementoTablaSimbolos("implements","implements"));
        tablaSimbolos.add(new ElementoTablaSimbolos("import","import"));
        tablaSimbolos.add(new ElementoTablaSimbolos("instanceof","instanceof"));
        tablaSimbolos.add(new ElementoTablaSimbolos("int","tipo"));
        tablaSimbolos.add(new ElementoTablaSimbolos("interface","interface"));
        tablaSimbolos.add(new ElementoTablaSimbolos("long","tipo"));
        tablaSimbolos.add(new ElementoTablaSimbolos("native","native"));
        tablaSimbolos.add(new ElementoTablaSimbolos("new","new"));
        tablaSimbolos.add(new ElementoTablaSimbolos("package","package"));
        tablaSimbolos.add(new ElementoTablaSimbolos("private","modif"));
        tablaSimbolos.add(new ElementoTablaSimbolos("protected","modif"));
        tablaSimbolos.add(new ElementoTablaSimbolos("public","public"));
        tablaSimbolos.add(new ElementoTablaSimbolos("return","modif"));
        tablaSimbolos.add(new ElementoTablaSimbolos("short","tipo"));
        tablaSimbolos.add(new ElementoTablaSimbolos("static","modif"));
        tablaSimbolos.add(new ElementoTablaSimbolos("strictfp","strictfp"));
        tablaSimbolos.add(new ElementoTablaSimbolos("super","super"));
        tablaSimbolos.add(new ElementoTablaSimbolos("switch","switch"));
        tablaSimbolos.add(new ElementoTablaSimbolos("synchronized","synchronized"));
        tablaSimbolos.add(new ElementoTablaSimbolos("this","this"));
        tablaSimbolos.add(new ElementoTablaSimbolos("throw","throw"));
        tablaSimbolos.add(new ElementoTablaSimbolos("throws","throws"));
        tablaSimbolos.add(new ElementoTablaSimbolos("transient","modif"));
        tablaSimbolos.add(new ElementoTablaSimbolos("try","try"));
        tablaSimbolos.add(new ElementoTablaSimbolos("void","tipo"));
        tablaSimbolos.add(new ElementoTablaSimbolos("volatile","modif"));
        tablaSimbolos.add(new ElementoTablaSimbolos("while","while"));
        tablaSimbolos.add(new ElementoTablaSimbolos("+","opa"));
        tablaSimbolos.add(new ElementoTablaSimbolos("-","opa"));
        tablaSimbolos.add(new ElementoTablaSimbolos("*","opa"));
        tablaSimbolos.add(new ElementoTablaSimbolos("/","opa"));
        tablaSimbolos.add(new ElementoTablaSimbolos("%","opa"));
        tablaSimbolos.add(new ElementoTablaSimbolos("^","opa"));
        tablaSimbolos.add(new ElementoTablaSimbolos(">","opr"));
        tablaSimbolos.add(new ElementoTablaSimbolos(">=","opr"));
        tablaSimbolos.add(new ElementoTablaSimbolos("<","opr"));
        tablaSimbolos.add(new ElementoTablaSimbolos("<=","opr"));
        tablaSimbolos.add(new ElementoTablaSimbolos("==","opr"));
        tablaSimbolos.add(new ElementoTablaSimbolos("!=","opr"));
        tablaSimbolos.add(new ElementoTablaSimbolos("&","opb"));
        tablaSimbolos.add(new ElementoTablaSimbolos("&&","opb"));
        tablaSimbolos.add(new ElementoTablaSimbolos("|","opb"));
        tablaSimbolos.add(new ElementoTablaSimbolos("||","opb"));
        tablaSimbolos.add(new ElementoTablaSimbolos("!","opb"));
        tablaSimbolos.add(new ElementoTablaSimbolos("=","opas"));
        tablaSimbolos.add(new ElementoTablaSimbolos("+=","opas"));
        tablaSimbolos.add(new ElementoTablaSimbolos("-=","opas"));
        tablaSimbolos.add(new ElementoTablaSimbolos("*=","opas"));
        tablaSimbolos.add(new ElementoTablaSimbolos("/=","opas"));
        tablaSimbolos.add(new ElementoTablaSimbolos("%=","opas"));
        tablaSimbolos.add(new ElementoTablaSimbolos("&=","opas"));
        tablaSimbolos.add(new ElementoTablaSimbolos("|=","opas"));
        tablaSimbolos.add(new ElementoTablaSimbolos("^=","opas"));
        tablaSimbolos.add(new ElementoTablaSimbolos("{","llaveabre"));
        tablaSimbolos.add(new ElementoTablaSimbolos("}","llavecierra"));
        tablaSimbolos.add(new ElementoTablaSimbolos("(","parentesisabre"));
        tablaSimbolos.add(new ElementoTablaSimbolos(")","parentesiscierra"));
        tablaSimbolos.add(new ElementoTablaSimbolos(",","coma"));
        tablaSimbolos.add(new ElementoTablaSimbolos(";","puntoycoma"));
        tablaSimbolos.add(new ElementoTablaSimbolos("[","corcheteabre"));
        tablaSimbolos.add(new ElementoTablaSimbolos("]","corchetecierra"));
        tablaSimbolos.add(new ElementoTablaSimbolos("\"","comillas"));
        tablaSimbolos.add(new ElementoTablaSimbolos("\'","comilla"));
    }

    public void agregarElemento(ElementoTablaSimbolos elemento){
        tablaSimbolos.add(elemento);
    }
}
