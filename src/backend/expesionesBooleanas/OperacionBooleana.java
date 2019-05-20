/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.expesionesBooleanas;

import backend.expresiones.Expresion;

/**
 *
 * @author jesfrin
 */
public class OperacionBooleana extends ExpresionBooleana{
    
    private String operacion;//AND | OR
    private Expresion ex1;
    private Expresion ex2;
    
    //Las operaciones booleanas se deben descomponer
    //Puede ser una comparacion
    //Puede ser una expresion, donde lo unico q llega a interesar es el id

    public OperacionBooleana(int numeroDeLinea,int numeroDeColumna,String operacion,Expresion ex1,Expresion ex2){
        this.numeroDeLinea=numeroDeLinea;
        this.numeroDeColumna=numeroDeColumna;
        this.operacion=operacion;
        this.ex1=ex1;
        this.ex2=ex2;
    }
    
    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Expresion getEx1() {
        return ex1;
    }

    public void setEx1(Expresion ex1) {
        this.ex1 = ex1;
    }

    public Expresion getEx2() {
        return ex2;
    }

    public void setEx2(Expresion ex2) {
        this.ex2 = ex2;
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
