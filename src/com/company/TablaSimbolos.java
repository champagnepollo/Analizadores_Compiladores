package com.company;

import java.util.ArrayList;

public class TablaSimbolos {
    public ArrayList<ElementoTablaSimbolos> tablaSimbolos;

    public TablaSimbolos() {
        this.tablaSimbolos = new ArrayList<>();
        tablaSimbolos.add(new ElementoTablaSimbolos("abstract","abstract",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("assert","assert",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("boolean","boolean",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("break","break",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("byte","byte",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("case","case",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("catch","catch",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("char","char",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("class","class",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("const","const",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("continue","continue",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("default","default",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("do","do",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("double","double",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("else","else",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("enum","enum",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("extends","extends",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("final","final",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("finally","finally",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("float","float",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("for","for",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("goto","goto",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("if","if",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("implements","implements",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("import","import",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("instanceof","instanceof",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("int","int",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("interface","interface",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("long","long",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("native","native",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("new","new",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("package","package",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("private","private",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("protected","protected",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("public","public",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("return","return",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("short","short",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("static","static",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("strictfp","strictfp",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("super","super",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("switch","switch",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("synchronized","synchronized",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("this","this",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("throw","throw",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("throws","throws",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("transient","transient",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("try","try",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("void","void",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("volatile","volatile",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("while","while",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("+","opa",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("-","opa",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("*","opa",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("/","opa",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("%","opa",null));
        tablaSimbolos.add(new ElementoTablaSimbolos(">","opr",null));
        tablaSimbolos.add(new ElementoTablaSimbolos(">=","opr",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("<","opr",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("<=","opr",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("==","opr",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("!=","opr",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("&","opb",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("&&","opb",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("|","opb",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("||","opb",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("!","opb",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("^","opb",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("=","opas",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("+=","opas",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("-=","opas",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("*=","opas",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("/=","opas",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("%=","opas",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("&=","opas",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("|=","opas",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("^=","opas",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("{","corcheteabre",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("}","corchetecierra",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("(","parentesisabre",null));
        tablaSimbolos.add(new ElementoTablaSimbolos(")","parentesiscierra",null));
        tablaSimbolos.add(new ElementoTablaSimbolos(",","coma",null));
        tablaSimbolos.add(new ElementoTablaSimbolos(";","puntoycoma",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("[","llaveabre",null));
        tablaSimbolos.add(new ElementoTablaSimbolos("]","llavecierra",null));
    }

    public void agregarElemento(ElementoTablaSimbolos elemento){
        tablaSimbolos.add(elemento);
    }
}
