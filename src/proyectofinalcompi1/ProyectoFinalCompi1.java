/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalcompi1;

import backend.expresionesAritmeticas.ExpresionMatematica;
import backend.expresionesAritmeticas.IdentificadorTipoInt;
import backend.expresionesAritmeticas.ManejadorDeExpresionesAritmeticas;
import backend.expresionesAritmeticas.OperacionBinaria;
import backend.expresionesAritmeticas.Operando;
import backend.generacionHtml.*;
import frontend.gui.NavegadorFrame;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesfrin
 */
public class ProyectoFinalCompi1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NavegadorFrame nav = new NavegadorFrame();
        nav.setVisible(true);
        String operaciones="2*3+4*3";
        int n=1*8-5+8/3-9*2/5*3+2;
        AnalizadorDeCodigoEmbebido lex = new AnalizadorDeCodigoEmbebido(new BufferedReader(new StringReader(operaciones)));
        parser sintactico = new parser(lex);
        try {
            sintactico.parse();
        } catch (Exception ex) {
            Logger.getLogger(ProyectoFinalCompi1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean b=true;
        boolean b1=false;
        boolean b2=b && b1;
        
        //Esto se crea en f-->numero|id
        Operando o1= new Operando(0, 0, "1");
        Operando o2= new Operando(0, 0, "2");
        Operando o3= new Operando(0, 0, "3");
        Operando o4= new Operando(0, 0, "8");
        Operando o5= new Operando(0, 0, "7");
        Operando o6= new Operando(0, 0, "9");
        //Esto se crea en f-->op +-*/ op
        OperacionBinaria suma1= new OperacionBinaria(0, 0, o1, o2,"+");
        OperacionBinaria mult1= new OperacionBinaria(0, 0, o3, o4,"*");
        OperacionBinaria rest1= new OperacionBinaria(0, 0, suma1, mult1,"-");
        OperacionBinaria suma2 = new OperacionBinaria(0, 0, rest1, o5, "+");
        OperacionBinaria rest2 = new OperacionBinaria(0, 0, suma2, o6, "-");
       // int valor=ManejadorDeExpresionesAritmeticas.recorridoDeOperaciones(rest2);
        //System.out.println("Valor calculado de operacion nueva:"+valor);
        System.out.println("n:"+n);
    }
}
