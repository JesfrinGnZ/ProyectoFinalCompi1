/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.asignacionCreacionDeVariables;

import backend.errores.ErrorAnalisis;
import backend.errores.ErrorSemantico;
import backend.errores.ErrorSintactico;
import backend.expesionesBooleanas.ManejadorDeExpresionesBooleanas;
import backend.expresiones.*;
import backend.expresionesAritmeticas.ManejadorDeExpresionesAritmeticas;
import backend.expresionesConCadenas.ManejadorDeExpresionesTipoCadena;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeAsignacionDeExpresiones {

    private ManejadorDeTablaDeSimbolos manejadorDeVariables;
    private Asignacion asignacion;
    private boolean seDebeRealizarLaAsignacion;
    private boolean errorEnAsignacion;
    private ArrayList<ErrorAnalisis> listaDeErrores;

    public ManejadorDeAsignacionDeExpresiones(ManejadorDeTablaDeSimbolos man, Asignacion asignacion, boolean seDebeRealizarLaAsignacion, ArrayList<ErrorAnalisis> listaDeErrores) {
        this.manejadorDeVariables = man;
        this.asignacion = asignacion;
        this.seDebeRealizarLaAsignacion = seDebeRealizarLaAsignacion;
        this.errorEnAsignacion = false;
        this.listaDeErrores = listaDeErrores;
    }

    public void asignacionDeVariable() {
        Variable var = this.asignacion.getVariable();
        if (var == null) {
            ErrorSemantico nuevoError = new ErrorSemantico(this.asignacion.getNumeroDeLinea(), this.asignacion.getNumeroDeColumna(), "No existe la variable declarada:" + this.asignacion.getIdDeVariable());
            this.listaDeErrores.add(nuevoError);
            //System.out.println("Error sintatico no exite la variable declarada");
        } else {
            switch (var.getTipoDeVariable()) {
                case "entera":
                    ManejadorDeExpresionesAritmeticas man = new ManejadorDeExpresionesAritmeticas(this.manejadorDeVariables);
                    int nuevoValor = man.recorridoDeOperaciones(this.asignacion.getExpresion());
                    if (!man.existioErrorAlRealizarLaOperacion()) {
                        if (seDebeRealizarLaAsignacion) {
                            this.asignacion.getVariable().setValorDeVariable(String.valueOf(nuevoValor));
                        }
                        System.out.println("Id:" + this.asignacion.getVariable().getNombreDeVariable() + " Valor:" + this.asignacion.getVariable().getValorDeVariable());
                    } else {
                        ErrorSintactico nuevoE = new ErrorSintactico(this.asignacion.getNumeroDeLinea(), this.asignacion.getNumeroDeColumna(), "Asignacion no valida");
                        this.listaDeErrores.add(nuevoE);
                        //System.out.println("No se ha asignado la variable:" + this.asignacion.getVariable().getNombreDeVariable());
                        this.errorEnAsignacion = true;
                    }
                    break;
                case "cadena":
                    ManejadorDeExpresionesTipoCadena man2 = new ManejadorDeExpresionesTipoCadena(this.manejadorDeVariables);
                    String nuevoValor1 = man2.recorridoDeOperaciones(this.asignacion.getExpresion());
                    if (!man2.existioErrorAlRealizarLaOperacion()) {
                        if (seDebeRealizarLaAsignacion) {
                            this.asignacion.getVariable().setValorDeVariable(nuevoValor1);
                        }
                        System.out.println("Id:" + this.asignacion.getVariable().getNombreDeVariable() + " Valor:" + this.asignacion.getVariable().getValorDeVariable());
                    } else {
                        ErrorSintactico nuevoE = new ErrorSintactico(this.asignacion.getNumeroDeLinea(), this.asignacion.getNumeroDeColumna(), "Asignacion no valida");
                        this.listaDeErrores.add(nuevoE);
                        this.errorEnAsignacion = true;
                        //System.out.println("No se ha asignado la variable:" + this.asignacion.getVariable().getNombreDeVariable());
                    }
                    break;
                case "booleana":
                    ManejadorDeExpresionesBooleanas man3 = new ManejadorDeExpresionesBooleanas(this.manejadorDeVariables);
                    boolean nuevoValor2 = man3.recorridoDeExpresion(this.asignacion.getExpresion());
                    if (!man3.existioErrorAlRealizarLaOperacion()) {
                        if (seDebeRealizarLaAsignacion) {
                            if (nuevoValor2) {
                                this.asignacion.getVariable().setValorDeVariable("true");
                                System.out.println("Valor TRUE asignado ID:" + this.asignacion.getVariable().getNombreDeVariable());
                            } else {
                                this.asignacion.getVariable().setValorDeVariable("false");
                                System.out.println("Valor FALSE asignado ID:" + this.asignacion.getVariable().getNombreDeVariable());
                            }
                        }
                    } else {
                        this.errorEnAsignacion = true;
                        ErrorSintactico nuevoE = new ErrorSintactico(this.asignacion.getNumeroDeLinea(), this.asignacion.getNumeroDeColumna(), "Asignacion no valida");
                        this.listaDeErrores.add(nuevoE);
                        //System.out.println("No se ha asignado la variable:" + this.asignacion.getVariable().getNombreDeVariable());
                    }
                    break;
                default:
                    System.out.println("No se encontro el tipo de variable");
                    break;
            }
        }

    }

    public boolean esErrorEnAsignacion() {
        return errorEnAsignacion;
    }

    public void setErrorEnAsignacion(boolean errorEnAsignacion) {
        this.errorEnAsignacion = errorEnAsignacion;
    }

}
