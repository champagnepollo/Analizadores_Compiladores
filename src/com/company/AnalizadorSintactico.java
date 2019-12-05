package com.company;

import java.util.ArrayList;

public class AnalizadorSintactico {
    public void Analizar(){
        int mainIndex = EntryAt();

        if( mainIndex == -1 ){
            System.out.println("No Rick function found!");
            System.exit(-1);
        }

        if( !CheckEntry( mainIndex ) ){
            System.out.println("Rick function error in definition!");
            System.out.println("Excepcting: <TYPE> Rick(){}");
            System.exit(-1);
        }

        if( CountBrackets() != 0 ){
            System.out.println("Missing Brackets!");
            System.exit(-1);
        }

        int p = EntryBracketAt( mainIndex );
        //TODO: Analizar(int, int)
//        Analizar(p, TablaSimbolos.tablaSimbolos.size());
    }
    private int EntryBracketAt( int mainIndex ){
        for(int i = mainIndex; i < TablaSimbolos.tablaSimbolos.size(); i++){
            if( TablaSimbolos.tablaSimbolos.get(i).ComponenteLexico== "llaveabre"){
                return i;
            }
        }
        return -1;
    }

    private boolean CheckEntry(int mainIndex) {
        boolean entry = true;

        if(TablaSimbolos.tablaSimbolos.get(mainIndex - 1).ComponenteLexico != "tipo"){
            entry = false;
        }else if(TablaSimbolos.tablaSimbolos.get(mainIndex + 1).ComponenteLexico != "parentesisabre"){
            entry = false;
        }else if(TablaSimbolos.tablaSimbolos.get(mainIndex + 2).ComponenteLexico != "parentesiscierra"){
            entry = false;
        }else if(TablaSimbolos.tablaSimbolos.get(mainIndex + 3).ComponenteLexico != "llavecierra"){
            entry = false;
        }
        return entry;
    }

    private int CountBrackets( ){
        int counter = 0;

        for( int i = 0; i < TablaSimbolos.tablaSimbolos.size(); i++ ){
            if( TablaSimbolos.tablaSimbolos.get(i).ComponenteLexico == "llaveabre")
                counter++;
            else if( TablaSimbolos.tablaSimbolos.get( i ).ComponenteLexico == "llavecierra")
                counter--;
        }
        return counter;
    }

    private int EntryAt() {
        int entryIndex = -1;

        for( int i = 0; i < TablaSimbolos.tablaSimbolos.size(); i++){
            if( TablaSimbolos.tablaSimbolos.get(i).ER.equals("main")){
                entryIndex = i;
            }
        }

        return entryIndex;
    }

    //sentencias
    private void Sentencia(ArrayList<ElementoTablaSimbolos> tokens) {
        if(tokens.get(0).ComponenteLexico == "tipo" || tokens.get(0).ComponenteLexico == "id"){

            if(!this.Declaracion(tokens)){
                this.Asignacion(tokens);
            }

//        }else if(tokens.get(0).ComponenteLexico == "if" ){
//            this.Condicion(tokens);
        }/*else{
            this.loop(tokens);
        }*/
    }
//
    private boolean Declaracion(ArrayList<ElementoTablaSimbolos> tokens) {
        int cont = 0;
            //declaracion de primer tipo:: <mod><tipo><id>;
        //id::<id> | <id>,<id>

        while(tokens.get(cont).ComponenteLexico == "modif"){
            cont++;
        }

        if( tokens.get(cont).ComponenteLexico == "tipo"){
            cont++;

            if( tokens.get(cont).ComponenteLexico == "id"){
                cont++;

                //Caso para multiples variables declaradas en una linea
//                while(tokens.get(cont).ComponenteLexico == "coma" && tokens.get(cont+1).ComponenteLexico == "id"){
//                    cont+=2;
//                }

                if( tokens.get(cont).ComponenteLexico == "puntoycoma"){
                    Sentencia tmp = new Sentencia();
                    tmp.token = new ArrayList<ElementoTablaSimbolos>(tokens);
                    tmp.tipo = "decl";
                    Sentencias.add(tmp);
                    System.out.println("decl");

                    return true;
                }
            }
            // Si no fue una declaracion de primer tipo, se intentara segundo tipo
            // decl:: <type> <assign>

            Sentencia tmp = new Sentencia();
            tmp.token = new ArrayList<ElementoTablaSimbolos>(tokens);
            tmp.tipo = "decl";

            Sentencias.add(tmp);
            this.Asignacion(new ArrayList<ElementoTablaSimbolos>(tokens.subList(cont-1, tokens.size())));
        }
        return false;
    }

    private boolean Asignacion(ArrayList<ElementoTablaSimbolos> tokens) {

        //Valida el tamano minimo
        if( tokens.size() < 4 ){
//            Errors.add("Assignment incomplete");
            return false;
        }

        if(tokens.get(0).ComponenteLexico == "id"){
            if( tokens.get(1).ER == "="){
                if(tokens.get(2).ComponenteLexico == "int" || tokens.get(2).ComponenteLexico == "double"){
                    if( tokens.get(3).ComponenteLexico == "puntoycoma"){
                        Sentencia tmp = new Sentencia();
                        tmp.token = new ArrayList<ElementoTablaSimbolos>(tokens);
                        tmp.tipo = "assign";
                        Sentencias.add(tmp);
                        System.out.println("assign");
                        return true;
                    }else{
//                        Errors.add("Missing semicolon");
                    }
                }

                if(oper(new ArrayList<ElementoTablaSimbolos>( tokens.subList( 2, tokens.size() - 1 ) ))){
                    if( tokens.get(tokens.size() - 1).ComponenteLexico == "puntoycoma" ){
                        System.out.println("assign");
                        return true;
                    }
                }
            }else{
//                Errors.add("Expecting equal ER");
            }
        }
        return false;
    }

    private boolean oper(ArrayList<ElementoTablaSimbolos> tokens){

        if(tokens.size() < 3){
            if( this.var(tokens.get(0))  ){
                return true;
            }
//            Errors.add("Oper missing tokens");
            return false;
        }

        if(this.var(tokens.get(0))){
            if(this.op( tokens.get(1))){
                if(this.var( tokens.get(2))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean op(ElementoTablaSimbolos t){
        if(t.ComponenteLexico.equals("opb"))
            return true;
        else if(t.ComponenteLexico.equals("opa"))
            return true;
        else{
//            Errors.add("Not OP found");
            return false;
        }

    }

//    private void condif(ArrayList<ElementoTablaSimbolos> tokens) {
//        if( tokens.get(0).ComponenteLexico == "if"){
//            if( tokens.get(1).ComponenteLexico == "parentesisabre"){
//                ArrayList<ElementoTablaSimbolos> tmp = new ArrayList<>();
//                tmp.add( tokens.get(2) );
//                tmp.add( tokens.get(3) );
//                tmp.add( tokens.get(4) );
//                if(oper_l(tmp)){
//                    tmp.clear();
//                    if( tokens.get(5).ComponenteLexico == "parentesiscierra"){
//                        if(tokens.get(6).ComponenteLexico == "llaveabre"){
//                            for( int i = 7; i < tokens.size(); i++ ){
//                                tmp.add(tokens.get(i));
//                            }
//                            System.out.println("cond");
//                            Sentencia(tmp);
//                            tmp.clear();
//                        }
//                    }
//                }else{
////                    Errors.add("Expecting Logical Operation");
//                }
//            }
//        }
//    }

    private boolean var(ElementoTablaSimbolos t){
        if(t.ComponenteLexico == "id" || t.ComponenteLexico == "int" || t.ComponenteLexico == "double"){
            return true;
        }
        return false;
    }

    public void Analizar(int startIndex, int endIndex){
        ArrayList<ElementoTablaSimbolos> tmp = new ArrayList<>();

        for (int i = startIndex + 1; i < endIndex; i++){
            //Los mete a pila hasta encontrar ;
            tmp.add(TablaSimbolos.tablaSimbolos.get(i));

            if(TablaSimbolos.tablaSimbolos.get(i).ComponenteLexico == "puntoycoma"){
                Sentencia(tmp);
                tmp.clear();
            }else if(TablaSimbolos.tablaSimbolos.get(i).ComponenteLexico == "llavecierra"){
                Sentencia(tmp);
                tmp.clear();
            }
        }
    }
}
