/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.asignacionCreacionDeVariables;

import backend.expresiones.*;
import backend.expresionesAritmeticas.ManejadorDeExpresionesAritmeticas;
import backend.expresionesConCadenas.ManejadorDeExpresionesTipoCadena;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeAsignacionDeExpresiones {

    private ManejadorDeTablaDeSimbolos manejadorDeVariables;
    private Asignacion asignacion;

    public ManejadorDeAsignacionDeExpresiones(ManejadorDeTablaDeSimbolos man,Asignacion asignacion) {
        this.manejadorDeVariables = man;
        this.asignacion=asignacion;
    }

    public void asignacionDeVariable() {
        Variable var = this.asignacion.getVariable();
        if (var == null) {
            System.out.println("Error sintatico no exite la variable declarada");
        } else {
            switch (var.getTipoDeVariable()) {
                case "entera":
                    ManejadorDeExpresionesAritmeticas man=new ManejadorDeExpresionesAritmeticas(this.manejadorDeVariables);
                    man.recorridoDeOperaciones(this.asignacion.getExpresion());
                    break;
                case "cadena":
                    ManejadorDeExpresionesTipoCadena man2=new ManejadorDeExpresionesTipoCadena(this.manejadorDeVariables);
                    man2.recorridoDeOperaciones(this.asignacion.getExpresion());
                    break;
                case "booleana":
                    break;
                default:
                    break;
            }
        }

    }

}
