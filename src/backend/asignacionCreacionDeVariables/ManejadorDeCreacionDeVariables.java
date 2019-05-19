/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.asignacionCreacionDeVariables;

import backend.expresiones.*;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeCreacionDeVariables {

    private ManejadorDeTablaDeSimbolos manejadorDeVariables;
    private Variable variable;

    public ManejadorDeCreacionDeVariables(ManejadorDeTablaDeSimbolos manejadorDeVariables,Variable variable) {
        this.manejadorDeVariables = manejadorDeVariables;
        this.variable=variable;
    }

    public void crearVariable() {
        Variable var = this.manejadorDeVariables.verificarSiExisteVariable(this.variable.getNombreDeVariable());
        if (var == null) {
            this.manejadorDeVariables.anadirVariable(this.variable);
        } else {
            System.out.println("Error ya existia la variable ajja");
        }
    }

}
