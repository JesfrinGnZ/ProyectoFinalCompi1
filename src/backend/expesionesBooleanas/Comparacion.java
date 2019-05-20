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
public class Comparacion extends ExpresionBooleana{
    
    private String tipoDeComparacion;
    private Expresion ex1;//Expresion Aritmetica solo suma resta mult div
    private Expresion ex2;//Expresion Aritmetica

    public Comparacion(int numeroDeLinea,int numeroDeColumna,String tipoDeCOmparacion,Expresion ex1,Expresion ex2){
        this.numeroDeLinea=numeroDeLinea;
        this.numeroDeColumna=numeroDeColumna;
        this.tipoDeComparacion=tipoDeCOmparacion;
        this.ex1=ex1;
        this.ex2=ex2;
    }
    
    public String getTipoDeComparacion() {
        return tipoDeComparacion;
    }

    public void setTipoDeComparacion(String tipoDeComparacion) {
        this.tipoDeComparacion = tipoDeComparacion;
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
