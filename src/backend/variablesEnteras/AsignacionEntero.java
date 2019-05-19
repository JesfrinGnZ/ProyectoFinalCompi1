/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.variablesEnteras;

import backend.arbolAST.Nodo;
import backend.expresionesAritmeticas.ExpresionMatematica;

/**
 *
 * @author jesfrin
 */
public class AsignacionEntero extends Nodo {

    private String nombre;
    private ExpresionMatematica expresion;

    public AsignacionEntero(int numeroDeColumna, int numeroDeLinea, String nombre, ExpresionMatematica expresion) {
        this.numeroDeColumna=numeroDeColumna;
        this.numeroDeLinea=numeroDeLinea;
        this.nombre=nombre;
        this.expresion=expresion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ExpresionMatematica getExpresion() {
        return expresion;
    }

    public void setExpresion(ExpresionMatematica expresion) {
        this.expresion = expresion;
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
