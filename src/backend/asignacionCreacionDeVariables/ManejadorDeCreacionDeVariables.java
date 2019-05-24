/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.asignacionCreacionDeVariables;

import backend.errores.ErrorAnalisis;
import backend.errores.ErrorSemantico;
import backend.expresiones.*;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeCreacionDeVariables {

    private ManejadorDeTablaDeSimbolos manejadorDeVariables;
    private Variable variable;
    private ArrayList<ErrorAnalisis> listaDeErrores;

    public ManejadorDeCreacionDeVariables(ManejadorDeTablaDeSimbolos manejadorDeVariables,Variable variable,ArrayList<ErrorAnalisis> listaDeErrores) {
        this.manejadorDeVariables = manejadorDeVariables;
        this.variable=variable;
        this.listaDeErrores=listaDeErrores;
        
    }

    public void crearVariable() {
        Variable var = this.manejadorDeVariables.verificarSiExisteVariable(this.variable.getNombreDeVariable());
        if (var == null) {
            this.manejadorDeVariables.anadirVariable(this.variable);
        } else {
            ErrorSemantico nuevoError = new ErrorSemantico(this.variable.getNumeroDeLinea(),variable.getNumeroDeColumna(),"Ya se declaro la variable:"+variable.getNombreDeVariable());
            this.listaDeErrores.add(nuevoError);
            //System.out.println("Error ya existia la variable ajja");
        }
    }

}
