/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.tablaDeSimbolos;

import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeTablaDeSimbolos {

    private ArrayList<Variable> tablaDeSimbolos;

    public ManejadorDeTablaDeSimbolos(ArrayList<Variable> tablaDeSimbolos) {
        this.tablaDeSimbolos = tablaDeSimbolos;
    }

    public ArrayList<Variable> getTablaDeSimbolos() {
        return tablaDeSimbolos;
    }

    public void setTablaDeSimbolos(ArrayList<Variable> tablaDeSimbolos) {
        this.tablaDeSimbolos = tablaDeSimbolos;
    }


    public Variable verificarSiExisteVariable(String nombre){
        for (Variable variable : tablaDeSimbolos) {
            if(variable.getNombreDeVariable().equals(nombre)){
                return variable;
            }
        }
        return null;
    }
    
    public void anadirVariable(Variable variable){
        this.tablaDeSimbolos.add(variable);
    }
    
    
}
