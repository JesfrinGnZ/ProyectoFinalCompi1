/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.asignacionCreacionDeVariables;

import backend.arbolAST.Nodo;
import backend.expresiones.Expresion;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;

/**
 *
 * @author jesfrin
 */
public class Asignacion extends Nodo{
    
    private Variable variable;
    private Expresion expresion;
    private ManejadorDeTablaDeSimbolos manejadorDeVariables;
    private String idDeVariable;

    public Asignacion(String id, Expresion expresion,ManejadorDeTablaDeSimbolos manejadorDeVariables) {
        this.manejadorDeVariables=manejadorDeVariables;
        this.variable = manejadorDeVariables.verificarSiExisteVariable(id);
        this.expresion = expresion;
        this.idDeVariable=id;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
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

    public ManejadorDeTablaDeSimbolos getManejadorDeVariables() {
        return manejadorDeVariables;
    }

    public void setManejadorDeVariables(ManejadorDeTablaDeSimbolos manejadorDeVariables) {
        this.manejadorDeVariables = manejadorDeVariables;
    }

    public String getIdDeVariable() {
        return idDeVariable;
    }

    public void setIdDeVariable(String idDeVariable) {
        this.idDeVariable = idDeVariable;
    }
    
    
}
