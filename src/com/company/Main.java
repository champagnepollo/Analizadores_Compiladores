package com.company;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main extends JFrame implements ActionListener, Serializable {

    // BufferedReader input;
    // String in;
    DefaultTableModel inputTM, simbolTM;
    JTable inputTable, simbolTable;
    JScrollPane inputTableScroll, simbolTableScroll, inputTextScroll, errorScroll;
    JTextArea errorText,inputText;
    JButton btnFile, btnCompile;
    public static TablaSimbolos tabla = new TablaSimbolos();
    public static TablaSimbolos tablar=new TablaSimbolos();
    public static String[][] arrayr;
    public static ArrayList<ElementoTablaSimbolos> tablap=new ArrayList<>();
    public static String[][] arrayp;
    public static String errores;
    public static StringBuilder erroress= new StringBuilder();
    public static void main(String[] args) {
        new Main();
    }
    public Main(){
        setLayout(null);

        //Input Text
        inputText = new JTextArea();
        inputTextScroll = new JScrollPane(inputText);
        inputTextScroll.setBounds(10,50,500,530);
        add(inputTextScroll);

        //Inputs table
        inputTM = new DefaultTableModel();
        inputTable = new JTable(inputTM);
        inputTableScroll = new JScrollPane(inputTable);
        inputTableScroll.setBounds(520,10,500,280);
        add(inputTableScroll);

        inputTM.addColumn("ER");
        inputTM.addColumn("Componente Lexico");
        inputTM.addColumn("Valor");

        //Simbols table
        simbolTM = new DefaultTableModel();
        simbolTable = new JTable(simbolTM);
        simbolTableScroll = new JScrollPane(simbolTable);
        simbolTableScroll.setBounds(520,300,500,280);
        add(simbolTableScroll);

        simbolTM.addColumn("ER");
        simbolTM.addColumn("Componente lexico");
        simbolTM.addColumn("Valor");

        //Errors
        //errorText = new JTextField();
        errorText=new JTextArea();
        errorScroll = new JScrollPane(errorText);
        errorScroll.setBounds(10,590,1010,100);
        add(errorScroll);

        //File
        //btnFile= new JButton("Select file");
        //btnFile.setBounds(10,10,100,30);
        //btnFile.addActionListener(this);
        //add(btnFile);

        //Compile
        btnCompile= new JButton("Compile");
        btnCompile.setBounds(120,10,100,30);
        btnCompile.addActionListener(this);
        add(btnCompile);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Lexico v1.0");
        setSize(1050,750);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==btnFile) {
            JFileChooser jfc = new JFileChooser();
            if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
                System.out.println(jfc.getSelectedFile().getPath());
                // //File chooser y mostrar en TextField
                // try{
                //     input = new BufferedReader(new FileReader(jfc.getSelectedFile()));
                //     in = null;
                //     while (in != null) {
                //         in += input.readLine();
                //     }
                //     System.out.println(in);
                //     inputText.setText(in);
                // } catch (FileNotFoundException ex) {
                //     System.out.print(ex);
                // } catch (IOException ex) {
                //     System.out.print(ex);
                // }
            }
        } else if (ae.getSource()==btnCompile) {
            String texto=inputText.getText();
            inputTM.setRowCount(0);
            simbolTM.setRowCount(0);
            AnalizadorLexico analizador = new AnalizadorLexico("archivo.txt",texto);
            TablaSimbolos tabla = new TablaSimbolos();
            //System.out.println(analizador.content.length());
            //System.out.println(analizador.buffer.length);
            tablap = analizador.Analizar(tabla);
            tablar=tabla;
            arrayr =new String[tablar.tablaSimbolos.size()][3];
            arrayp =new String[tablap.size()][3];
            errores=analizador.erroress;
            //inputTM.setRowCount(0);
            for(int i=0;i<tablar.tablaSimbolos.size();i++){
                arrayr[i][0]=tablar.tablaSimbolos.get(i).ER;
                arrayr[i][1]=tablar.tablaSimbolos.get(i).ComponenteLexico;
                if(tablar.tablaSimbolos.get(i).Valor==null){
                    arrayr[i][2]="-";
                }
                else{
                    arrayr[i][2]=tablar.tablaSimbolos.get(i).Valor;
                }
            }
            for(String[] s: arrayr){
                inputTM.addRow(s);
            }
            //simbolTM.setRowCount(0);
            for(int i=0;i<tablap.size();i++){
                arrayp[i][0]=tablap.get(i).ER;
                arrayp[i][1]=tablap.get(i).ComponenteLexico;
                if(tablap.get(i).Valor==null){
                    arrayp[i][2]="-";
                }
                else{
                    arrayp[i][2]=tablap.get(i).Valor;
                }
            }
            for(String[] s: arrayp){
                simbolTM.addRow(s);
            }
            errorText.setText(errores);
        }
    }
}
