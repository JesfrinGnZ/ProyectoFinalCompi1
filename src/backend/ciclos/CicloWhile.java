/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.ciclos;

import backend.arbolAST.Nodo;
import backend.expresiones.Expresion;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class CicloWhile extends Nodo{
    
    private Expresion ex;
    private ArrayList<Nodo> instrucciones;
    
    public CicloWhile(int numeroDeLinea,int numeroDeColumna,Expresion ex,ArrayList<Nodo> instrucciones){
        this.numeroDeLinea=numeroDeLinea;
        this.numeroDeColumna=numeroDeColumna;
        this.ex=ex;
        this.instrucciones=instrucciones;
    }

    public Expresion getEx() {
        return ex;
    }

    public void setEx(Expresion ex) {
        this.ex = ex;
    }

    public ArrayList<Nodo> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(ArrayList<Nodo> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public int getNumeroDeLinea() {
        return numeroDeLinea;
    }

    public void setNumeroDeLinea(int numeroDeLinea) {
        this.numeroDeLinea = numeroDeLinea;
    }

    public int getNumeroDeColumna() {
        return numeroDeColumna;
    }

    public void setNumeroDeColumna(int numeroDeColumna) {
        this.numeroDeColumna = numeroDeColumna;
    }


    
}
