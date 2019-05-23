/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.ciclos;

import backend.Escritura.Escritura;
import backend.Escritura.ManejadorDeEscritura;
import backend.arbolAST.Nodo;
import backend.asignacionCreacionDeVariables.Asignacion;
import backend.asignacionCreacionDeVariables.ManejadorDeAsignacionDeExpresiones;
import backend.asignacionCreacionDeVariables.ManejadorDeCreacionDeVariables;
import backend.condiciones.Condicion;
import backend.condiciones.ManejadorDeCondiciones;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeCicloFor {

    private CicloFor cicloFor;
    private ManejadorDeTablaDeSimbolos manejadorDeVariables;

    public ManejadorDeCicloFor(CicloFor cicloFor, ManejadorDeTablaDeSimbolos man) {
        this.cicloFor = cicloFor;
        this.manejadorDeVariables = man;
    }

    public void realizarOperaciones() {
        if (cicloFor.getNumero1() <= cicloFor.getNumero2()) {
            cicloFor.getVariable().setValorDeVariable(String.valueOf(cicloFor.getNumero1()));
            for (int i = cicloFor.getNumero1(); i <= cicloFor.getNumero2();) {
                for (Nodo instruccion : cicloFor.getInstruccionesDeFor()) {
                    if (instruccion instanceof Variable) {//Variable--->Es como un nodo declaracion
                        Variable variable = ((Variable) instruccion);
                        ManejadorDeCreacionDeVariables manDeVariables = new ManejadorDeCreacionDeVariables(manejadorDeVariables, variable);
                        manDeVariables.crearVariable();
                    } else if (instruccion instanceof Asignacion) {
                        Asignacion asignacion = ((Asignacion) instruccion);
                        asignacion.setVariable(manejadorDeVariables.verificarSiExisteVariable(asignacion.getIdDeVariable()));
                        ManejadorDeAsignacionDeExpresiones manDeAsignaciones = new ManejadorDeAsignacionDeExpresiones(manejadorDeVariables, asignacion, true);
                        manDeAsignaciones.asignacionDeVariable();
                    } else if (instruccion instanceof Escritura) {
                        Escritura escritura = ((Escritura) instruccion);
                        ManejadorDeEscritura manDeEscritura = new ManejadorDeEscritura(escritura, manejadorDeVariables);
                        manDeEscritura.manejarEscritura();
                    } else if (instruccion instanceof Condicion) {
                        Condicion nuevaCondicion = ((Condicion) instruccion);
                        ManejadorDeCondiciones manejador = new ManejadorDeCondiciones(nuevaCondicion, manejadorDeVariables);
                        manejador.realizarOperaciones();
                    } else if (instruccion instanceof CicloFor) {
                        CicloFor cicloF = ((CicloFor) instruccion);
                        cicloF.setVariable(manejadorDeVariables.verificarSiExisteVariable(cicloF.getId()));
                        ManejadorDeCicloFor manejadorF = new ManejadorDeCicloFor(cicloF, manejadorDeVariables);
                        manejadorF.realizarOperaciones();
                    }else if(instruccion instanceof CicloWhile){
                        CicloWhile ciclo =((CicloWhile) instruccion);
                        ManejadorDeCicloWhile manW = new ManejadorDeCicloWhile(ciclo, manejadorDeVariables);
                        manW.realizarOperaciones();
                    }
                }
                i++;
                cicloFor.getVariable().setValorDeVariable(String.valueOf(i));
            }

        } else {
            System.out.println("Error semantico,El numero1 no es menor que el numero 2");
        }
    }

}
