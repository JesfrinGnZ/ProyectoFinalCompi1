/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.condiciones;

import backend.arbolAST.Nodo;
import backend.expresiones.Expresion;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class Condicion extends Nodo{
    
    private Expresion ex1;
    private ArrayList<Nodo> instruccionesAceptacion;
    private ArrayList<Nodo> instruccionesRechazo;
    
    public Condicion(int numeroDeLinea,int numeroDeColumna,Expresion ex1,ArrayList<Nodo> instrucciones,ArrayList<Nodo> instruccionesRechazo){
        this.numeroDeLinea=numeroDeLinea;
        this.numeroDeColumna=numeroDeColumna;
        this.ex1=ex1;
        this.instruccionesAceptacion=instrucciones;
        this.instruccionesRechazo=instruccionesRechazo ;
    }

    public ArrayList<Nodo> getInstruccionesAceptacion() {
        return instruccionesAceptacion;
    }

    public void setInstruccionesAceptacion(ArrayList<Nodo> instruccionesAceptacion) {
        this.instruccionesAceptacion = instruccionesAceptacion;
    }

    public ArrayList<Nodo> getInstruccionesRechazo() {
        return instruccionesRechazo;
    }

    public void setInstruccionesRechazo(ArrayList<Nodo> instruccionesRechazo) {
        this.instruccionesRechazo = instruccionesRechazo;
    }

    public Expresion getEx1() {
        return ex1;
    }

    public void setEx1(Expresion ex1) {
        this.ex1 = ex1;
    }


    @Override
    public int getNumeroDeLinea() {
        return numeroDeLinea;
    }

    @Override
    public void setNumeroDeLinea(int numeroDeLinea) {
        this.numeroDeLinea = numeroDeLinea;
    }

    @Override
    public int getNumeroDeColumna() {
        return numeroDeColumna;
    }

    @Override
    public void setNumeroDeColumna(int numeroDeColumna) {
        this.numeroDeColumna = numeroDeColumna;
    }
    
    
}
