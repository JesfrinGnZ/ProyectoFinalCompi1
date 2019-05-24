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
import backend.errores.ErrorAnalisis;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeCicloFor {

    private CicloFor cicloFor;
    private ManejadorDeTablaDeSimbolos manejadorDeVariables;
    private ArrayList<ErrorAnalisis> listaDeErrores; 

    public ManejadorDeCicloFor(CicloFor cicloFor, ManejadorDeTablaDeSimbolos man,ArrayList<ErrorAnalisis> listaDeErrores) {
        this.cicloFor = cicloFor;
        this.manejadorDeVariables = man;
        this.listaDeErrores=listaDeErrores;
    }

    public void realizarOperaciones() {
        if (cicloFor.getNumero1() <= cicloFor.getNumero2()) {
            cicloFor.getVariable().setValorDeVariable(String.valueOf(cicloFor.getNumero1()));
            for (int i = cicloFor.getNumero1(); i <= cicloFor.getNumero2();) {
                for (Nodo instruccion : cicloFor.getInstruccionesDeFor()) {
                    if (instruccion instanceof Variable) {//Variable--->Es como un nodo declaracion
                        Variable variable = ((Variable) instruccion);
                        ManejadorDeCreacionDeVariables manDeVariables = new ManejadorDeCreacionDeVariables(manejadorDeVariables, variable,listaDeErrores);
                        manDeVariables.crearVariable();
                    } else if (instruccion instanceof Asignacion) {
                        Asignacion asignacion = ((Asignacion) instruccion);
                        asignacion.setVariable(manejadorDeVariables.verificarSiExisteVariable(asignacion.getIdDeVariable()));
                        ManejadorDeAsignacionDeExpresiones manDeAsignaciones = new ManejadorDeAsignacionDeExpresiones(manejadorDeVariables, asignacion, true,listaDeErrores);
                        manDeAsignaciones.asignacionDeVariable();
                    } else if (instruccion instanceof Escritura) {
                        Escritura escritura = ((Escritura) instruccion);
                        ManejadorDeEscritura manDeEscritura = new ManejadorDeEscritura(escritura, manejadorDeVariables,listaDeErrores);
                        manDeEscritura.manejarEscritura();
                        this.cicloFor.setTexto(this.cicloFor.getTexto() + escritura.getTextoGenerado());
                    } else if (instruccion instanceof Condicion) {
                        Condicion nuevaCondicion = ((Condicion) instruccion);
                        ManejadorDeCondiciones manejador = new ManejadorDeCondiciones(nuevaCondicion, manejadorDeVariables,listaDeErrores);
                        manejador.realizarOperaciones();
                        this.cicloFor.setTexto(this.cicloFor.getTexto() + nuevaCondicion.getTexto());
                    } else if (instruccion instanceof CicloFor) {
                        CicloFor cicloF = ((CicloFor) instruccion);
                        cicloF.setVariable(manejadorDeVariables.verificarSiExisteVariable(cicloF.getId()));
                        ManejadorDeCicloFor manejadorF = new ManejadorDeCicloFor(cicloF, manejadorDeVariables,listaDeErrores);
                        manejadorF.realizarOperaciones();
                        this.cicloFor.setTexto(this.cicloFor.getTexto() + cicloF.getTexto());
                    } else if (instruccion instanceof CicloWhile) {
                        CicloWhile ciclo = ((CicloWhile) instruccion);
                        ManejadorDeCicloWhile manW = new ManejadorDeCicloWhile(ciclo, manejadorDeVariables,listaDeErrores);
                        manW.realizarOperaciones();
                        this.cicloFor.setTexto(this.cicloFor.getTexto() + ciclo.getTexto());
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
