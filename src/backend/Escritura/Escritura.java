/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Escritura;

import backend.arbolAST.Nodo;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class Escritura extends Nodo{
    
    private ArrayList<Nodo> instrucciones;
    
    public Escritura(int numeroDeLinea,int numeroDeColumna,ArrayList<Nodo> instrucciones){
        this.instrucciones=instrucciones;
        this.numeroDeLinea=numeroDeLinea;
        this.numeroDeColumna=numeroDeColumna;
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
