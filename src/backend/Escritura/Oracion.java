/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Escritura;

import backend.arbolAST.Nodo;

/**
 *
 * @author jesfrin
 */
public class Oracion extends Nodo{
    
    private String oracion;
    
    public Oracion(int nF,int nC,String oracion){
        this.numeroDeColumna=nC;
        this.numeroDeLinea=nF;
        this.oracion=oracion.substring(1,oracion.length()-1);
    }

    public String getOracion() {
        return oracion;
    }

    public void setOracion(String oracion) {
        this.oracion = oracion;
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
