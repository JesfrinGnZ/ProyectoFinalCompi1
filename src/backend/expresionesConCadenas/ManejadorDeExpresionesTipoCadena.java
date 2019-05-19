/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.expresionesConCadenas;

import backend.expresiones.Expresion;
import backend.expresiones.Identificador;
import backend.expresiones.OperacionBinaria;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeExpresionesTipoCadena {

    private boolean existioErrorAlRealizarLaOperacion;
    private ManejadorDeTablaDeSimbolos manejadorDeVariables;

    public ManejadorDeExpresionesTipoCadena(ManejadorDeTablaDeSimbolos manejadorDeVariables) {
        this.manejadorDeVariables = manejadorDeVariables;
        this.existioErrorAlRealizarLaOperacion = false;
    }

    public String recorridoDeOperaciones(Expresion expresion) {
        String valor = "";
        String val1;
        String val2;
        if (!this.existioErrorAlRealizarLaOperacion) {
            if (expresion instanceof OperacionBinaria) {
                OperacionBinaria op = ((OperacionBinaria) expresion);
                if (op.getOperacion().equals("+")) {
                    val1 = recorridoDeOperaciones(op.getEx1());
                    val2 = recorridoDeOperaciones(op.getEx2());
                    valor = val1 + val2;
                }else{
                    this.existioErrorAlRealizarLaOperacion=true;
                }
            } else if (expresion instanceof Cadena) {
                Cadena op = ((Cadena) expresion);
                valor = op.getCadena();
            } else if (expresion instanceof Identificador) {
                Identificador op = ((Identificador) expresion);
                Variable var = manejadorDeVariables.verificarSiExisteVariable(op.getId());
                if (var == null) {//Si variable existe y es de tipo entera
                    //Error semantico, la variable no ha sido declarada
                    System.out.println("Error semantico la variable" + op.getId() + " no ha sido declarada");
                    this.existioErrorAlRealizarLaOperacion = true;
                } else if (!var.getTipoDeVariable().equals("cadena")) {
                    //Error semantico la variable no es de tipo entero
                    this.existioErrorAlRealizarLaOperacion = true;
                    System.out.println("Error semantico, tipos incompatibles:STRING no se puede convertir a " + var.getTipoDeVariable());
                } else {
                    valor = var.getValorDeVariable();
                }
            } else {
                this.existioErrorAlRealizarLaOperacion = true;
                System.out.println("Error ya ya que contiene tipos incompatibles");
            }
        }
        return valor;
    }
}
