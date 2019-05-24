/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.ciclos;

import backend.arbolAST.Nodo;
import backend.expresiones.Identificador;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class CicloFor extends Nodo {

    public int numero1;
    public int numero2;
    ArrayList<Nodo> instruccionesDeFor;
    public String id;
    private ManejadorDeTablaDeSimbolos manejadorDeVariables;
    private Variable variable;
    private String texto;
    
    public CicloFor(int numeroDeLinea, int numeroDeColumna, String numero1, String numero2, ArrayList<Nodo> instruccionesDeFor, String id,ManejadorDeTablaDeSimbolos man) {
        this.numeroDeLinea = numeroDeLinea;
        this.numeroDeColumna = numeroDeColumna;
        this.numero1 = Integer.valueOf(numero1);
        this.numero2 = Integer.valueOf(numero2);
        this.instruccionesDeFor = instruccionesDeFor;
        this.id=id;
        this.manejadorDeVariables=man;
        this.variable = manejadorDeVariables.verificarSiExisteVariable(id);
        this.texto="";
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public ArrayList<Nodo> getInstruccionesDeFor() {
        return instruccionesDeFor;
    }

    public void setInstruccionesDeFor(ArrayList<Nodo> instruccionesDeFor) {
        this.instruccionesDeFor = instruccionesDeFor;
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

    public String getId() {
        return id;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

   

    public void setId(String id) {
        this.id = id;
    }

    public ManejadorDeTablaDeSimbolos getManejadorDeVariables() {
        return manejadorDeVariables;
    }

    public void setManejadorDeVariables(ManejadorDeTablaDeSimbolos manejadorDeVariables) {
        this.manejadorDeVariables = manejadorDeVariables;
    }

}
