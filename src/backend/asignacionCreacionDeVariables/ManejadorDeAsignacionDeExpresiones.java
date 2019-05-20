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
                    int nuevoValor=man.recorridoDeOperaciones(this.asignacion.getExpresion());
                    if(!man.existioErrorAlRealizarLaOperacion()){
                        this.asignacion.getVariable().setValorDeVariable(String.valueOf(nuevoValor));
                        System.out.println("Id:"+this.asignacion.getVariable().getNombreDeVariable()+" Valor:"+this.asignacion.getVariable().getValorDeVariable());
                    }else{
                        System.out.println("No se ha asignado la variable:"+this.asignacion.getVariable().getNombreDeVariable());
                    }
                    break;
                case "cadena":
                    ManejadorDeExpresionesTipoCadena man2=new ManejadorDeExpresionesTipoCadena(this.manejadorDeVariables);
                    String nuevoValor1=man2.recorridoDeOperaciones(this.asignacion.getExpresion());
                    if(!man2.existioErrorAlRealizarLaOperacion()){
                        this.asignacion.getVariable().setValorDeVariable(nuevoValor1);
                        System.out.println("Id:"+this.asignacion.getVariable().getNombreDeVariable()+" Valor:"+this.asignacion.getVariable().getValorDeVariable());
                    }else{
                        System.out.println("No se ha asignado la variable:"+this.asignacion.getVariable().getNombreDeVariable());
                    }
                    break;
                case "booleana":
                    
                    break;
                default:
                    System.out.println("No se encontro el tipo de variable");
                    break;
            }
        }

    }

}
