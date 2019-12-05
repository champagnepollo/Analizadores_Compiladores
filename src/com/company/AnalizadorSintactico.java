package com.company;

import javax.swing.text.Element;
import java.util.ArrayList;

public class AnalizadorSintactico {
    public String errores = "Errores sintacticos encontrados\n";

    public void Analizar(){
        int classIndex = EntryAt();

        if( classIndex == -1 ){
            errores += "No existe clase";
        }else{
            if( !CheckEntry( classIndex ) ){
                errores += "No se definio ninguna clase";
                errores += "Excepcting: class <id>{}";
            }

            if( CountBrackets() != 0 ){
                errores += "Hacen falta llaves";
            }

            int p = EntryBracketAt( classIndex );
            //TODO: Analizar(int, int)
//        Analizar(p, Main.tablap.size()-1);
//        Analizar(-1, Main.tablap.size());

            bloque(new ArrayList<ElementoTablaSimbolos>(Main.tablap.subList(p, Main.tablap.size())));
        }
    }

    private int EntryBracketAt( int classIndex ){
        for(int i = classIndex; i < Main.tablap.size(); i++){
            if( Main.tablap.get(i).ComponenteLexico== "llaveabre"){
                return i;
            }
        }
        return -1;
    }

    private boolean CheckEntry(int classIndex) {
        boolean entry = true;

        if(Main.tablap.get(classIndex + 1).ComponenteLexico != "id"){
            entry = false;
        }else if(Main.tablap.get(classIndex + 2).ComponenteLexico != "llaveabre"){
            entry = false;
        }
        return entry;
    }

    private int CountBrackets( ){
        int counter = 0;

        for( int i = 0; i < Main.tablap.size(); i++ ){
            if( Main.tablap.get(i).ComponenteLexico == "llaveabre")
                counter++;
            else if( Main.tablap.get( i ).ComponenteLexico == "llavecierra")
                counter--;
        }
        return counter;
    }

    private int EntryAt() {
        int entryIndex = -1;

        for( int i = 0; i < Main.tablap.size(); i++){
            if(Main.tablap.get(i).ER.equals("class")){
                entryIndex = i;
            }
        }
        return entryIndex;
    }

    //sentencias
    private void Sentencia(ArrayList<ElementoTablaSimbolos> tokens) {
        if(tokens.get(0).ComponenteLexico == "tipo" && !(tokens.get(0).ER.equals("if")))
            this.Declaracion(tokens);
        else if (tokens.get(0).ComponenteLexico == "id")
            this.Asignacion(tokens);

        int cont = 0;
        if(tokens.get(cont).ER.equals("if") || tokens.get(cont).ER.equals("else")){
            if(tokens.get(++cont).ComponenteLexico == "parentesisabre"){
                ArrayList<ElementoTablaSimbolos> tmp = new ArrayList<ElementoTablaSimbolos>();
                cont++;
                if(!oper_l(new ArrayList<ElementoTablaSimbolos>(new ArrayList<ElementoTablaSimbolos>(tokens.subList(cont, cont+3))))) {
                    if(tokens.get(cont).ER.equals("true") || tokens.get(cont).ER.equals("false"))
                        cont+=2;
                    else
                        errores += "Error en operacion relacional\n";
                }else
                    cont+=4;

                Sentencia temp = new Sentencia();
                temp.token = new ArrayList<ElementoTablaSimbolos>(tokens);
                temp.tipo = "ifcond";
                Sentencias.add(temp);
                System.out.println("ifcond");
                bloque(new ArrayList<ElementoTablaSimbolos>(tokens.subList(cont+1, tokens.size()-1)));
//                while(!(tokens.get(++cont).ComponenteLexico == "parentesiscierra")){
////                TODO: oper_l
//                    tmp.add(tokens.get(cont++));
//                }
            }

        }else if (tokens.get(tokens.size()-1).ComponenteLexico != "puntoycoma") {
            errores += "Hace falta ; en la sentencia\n";
        }
    }

    private boolean Declaracion(ArrayList<ElementoTablaSimbolos> tokens) {
        int cont = 0;
        //declaracion de primer tipo:: <mod><tipo><id>;
        //id::<id> | <id>,<id>

        //TODO: modificadores
//        while(tokens.get(cont).ComponenteLexico == "modif"){
//            cont++;
//        }

        if(tokens.size() < 3) {
            errores += "Declaracion incorrecta\n";
            return false;
        }

        if( tokens.get(cont).ComponenteLexico == "tipo"){
            cont++;

            if( tokens.get(cont).ComponenteLexico == "id"){
                cont++;
                //TODO: declaracion multiple
//                while(tokens.get(cont).ComponenteLexico == "coma" && tokens.get(cont+1).ComponenteLexico == "id"){
//                    cont+=2;
//                }

                if(tokens.get(cont).ComponenteLexico == "puntoycoma"){
                    Sentencia tmp = new Sentencia();
                    tmp.token = new ArrayList<ElementoTablaSimbolos>(tokens);
                    tmp.tipo = "decl";
                    Sentencias.add(tmp);
                    System.out.println("decl");

                    return true;
                } else if (tokens.get(cont).ComponenteLexico == "opas") {
                    // Si no fue una declaracion de primer tipo, se intentara segundo tipo
                    // decl:: <type> <assign>
                    Sentencia tmp = new Sentencia();
                    tmp.token = new ArrayList<ElementoTablaSimbolos>(tokens);
                    tmp.tipo = "decl";

                    Sentencias.add(tmp);
                    return this.Asignacion(new ArrayList<ElementoTablaSimbolos>(tokens.subList(cont - 1, tokens.size())));
                }
            }
        }
        errores += "Declaracion incorrecta\n";
        return false;
    }

    private boolean oper_l(ArrayList<ElementoTablaSimbolos> tokens) {
        if(var(tokens.get(0))){
            if(tokens.get(1).ComponenteLexico == "opr"){
                if( var( tokens.get(2) ) ){
                    System.out.println("oprel");
                    return true;
                }
            }
        }
        return false;

    }

    private boolean Asignacion(ArrayList<ElementoTablaSimbolos> tokens) {
        //Valida el tamano minimo
        if(tokens.size() < 4 ){
            errores += "Asignacion incompleta\n";
            return false;
        }

        if(tokens.get(0).ComponenteLexico == "id"){
            if(tokens.get(1).ComponenteLexico == "opas"){
                //TODO: valor
//                if(valor(new ArrayList<ElementoTablaSimbolos>( tokens.subList( 2, tokens.size() - 1 ) ))){}
//                if(tokens.get(2).ComponenteLexico == "int" || tokens.get(2).ComponenteLexico == "double" || tokens.get(2).ComponenteLexico == "id"){
                if(this.var(tokens.get(2))){
                    if( tokens.get(3).ComponenteLexico == "puntoycoma"){
                        Sentencia tmp = new Sentencia();
                        tmp.token = new ArrayList<ElementoTablaSimbolos>(tokens);
                        tmp.tipo = "assign";
                        Sentencias.add(tmp);
                        System.out.println("assign");
                        return true;
                    }
                }

                if(oper(new ArrayList<ElementoTablaSimbolos>( tokens.subList( 2, tokens.size() - 1 ) ))){
                    if( tokens.get(tokens.size() - 1).ComponenteLexico == "puntoycoma" ){
                        Sentencia tmp = new Sentencia();
                        tmp.token = new ArrayList<ElementoTablaSimbolos>(tokens);
                        tmp.tipo = "assign";
                        Sentencias.add(tmp);
                        System.out.println("assign");
                        return true;
                    }
                }
                //TODO: asignacion de arr
//                if(arr(new ArrayList<ElementoTablaSimbolos>(tokens.subList(2, tokens.size()-1)))){}
            }
        }
        errores += "Error en asignacion\n";
        return false;
    }

//    private boolean arr(ArrayList<ElementoTablaSimbolos> tokens){
//        int cont = 0;
//        if(tokens.get(cont).ComponenteLexico != "corcheteabre" || tokens.size() < 3)
//            return false;
//
//        if(arr(new ArrayList<>(tokens.subList(cont, tokens.size()-1)))){}
//    }

    private boolean oper(ArrayList<ElementoTablaSimbolos> tokens){
        if(tokens.size() < 3){
//            if(this.var(tokens.get(0)) && tokens.size() == 1){
//                return true;
//            }
            errores += "Operacion incompleta\n";
            return false;
        }
//        int cont = 0;

        if(this.var(tokens.get(0))){
            //TODO: operaciones con multiples operadores
            if(this.op( tokens.get(1))){
                if(this.var( tokens.get(2))) {
                    return true;
                }
            }
        }
        errores += "Error en operacion\n";
        return false;
    }

    private boolean op(ElementoTablaSimbolos t){
        if(t.ComponenteLexico.equals("opb"))
            return true;
        else if(t.ComponenteLexico.equals("opa"))
            return true;
        else{
//            Errors.add("Not OP found");
//            errores += "No se encontro operador\n";
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

    private boolean bloque(ArrayList<ElementoTablaSimbolos> bloque){
        int bloquecont = 0;
        ArrayList<ElementoTablaSimbolos> tmp = new ArrayList<>();
        for (int i = 0; i < bloque.size(); i++) {
            tmp.add(bloque.get(i));
            if (bloquecont > 0) {
                if (bloque.get(i).ComponenteLexico == "llavecierra") {
                    bloquecont--;
                    if (bloquecont == 0) {
//                        bloque(new ArrayList<ElementoTablaSimbolos>(tmp.subList(1, tmp.size()-1)));
                        Sentencia(new ArrayList<ElementoTablaSimbolos>(tmp.subList(1, tmp.size()-1)));
                        tmp.clear();
                        return true;
                    }
                }else if(bloque.get(i).ComponenteLexico == "llaveabre")
                    bloquecont++;
            }else if(bloque.get(i).ComponenteLexico == "llaveabre"){
                bloquecont++;
            }else if(bloque.get(i).ComponenteLexico == "puntoycoma"){
                Sentencia(tmp);
                tmp.clear();
            }else if(i == bloque.size()-1){
                Sentencia(tmp);
                tmp.clear();
            }
        }
        if(bloquecont > 0) {
            errores += "Error de bloque\n";
            return false;
        }
        return false;
    }

    public void Analizar(int startIndex, int endIndex){
        ArrayList<ElementoTablaSimbolos> tmp = new ArrayList<>();
        int bloquecont = 0;

        for (int i = startIndex + 1; i < endIndex; i++){
            //Los mete a pila hasta encontrar ;
            tmp.add(Main.tablap.get(i));

            if (bloquecont > 0) {
                if (Main.tablap.get(i).ComponenteLexico == "llavecierra") {
//                    bloquecont--;
                    if(--bloquecont == 0){
                        bloque(tmp);
                        tmp.clear();
                    }
                }else if(Main.tablap.get(i).ComponenteLexico == "llaveabre")
                    bloquecont++;
            }else if(Main.tablap.get(i).ComponenteLexico == "llaveabre"){
                    bloquecont++;
            }else if(Main.tablap.get(i).ComponenteLexico == "puntoycoma"){
                Sentencia(tmp);
                tmp.clear();
            }else if(i == endIndex-1){
                if(tmp.size() > 1) {
                    Sentencia(tmp);
                    tmp.clear();
                }
            }
        }
    }
}
