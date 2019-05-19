/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.tablaDeSimbolos;

import backend.arbolAST.Nodo;


/**
 *
 * @author jesfrin
 */
public class Variable extends Nodo{
    //Clave,valor,tipo
    
    private String nombreDeVariable;
    private String tipoDeVariable;
    private String valorDeVariable;

    public Variable(int numeroDeLinea,int numeroDeColumna,String nombreDeVariable, String tipoDeVariable, String valorDeVariable) {
        this.nombreDeVariable = nombreDeVariable;
        this.tipoDeVariable = tipoDeVariable;
        this.valorDeVariable = valorDeVariable;
    }

    public String getNombreDeVariable() {
        return nombreDeVariable;
    }

    public void setNombreDeVariable(String nombreDeVariable) {
        this.nombreDeVariable = nombreDeVariable;
    }

    public String getTipoDeVariable() {
        return tipoDeVariable;
    }

    public void setTipoDeVariable(String tipoDeVariable) {
        this.tipoDeVariable = tipoDeVariable;
    }

    public String getValorDeVariable() {
        return valorDeVariable;
    }

    public void setValorDeVariable(String valorDeVariable) {
        this.valorDeVariable = valorDeVariable;
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
