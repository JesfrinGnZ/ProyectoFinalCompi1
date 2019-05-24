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
import backend.expesionesBooleanas.ManejadorDeExpresionesBooleanas;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeCicloWhile {

    private CicloWhile cicloWhile;
    private ManejadorDeTablaDeSimbolos manejadorDeVariables;
    private ArrayList<ErrorAnalisis> listaDeErrores;
    
    public ManejadorDeCicloWhile(CicloWhile cicloWhile, ManejadorDeTablaDeSimbolos man,ArrayList<ErrorAnalisis> listaDeErrores) {
        this.cicloWhile = cicloWhile;
        this.manejadorDeVariables = man;
        this.listaDeErrores=listaDeErrores;
    }

    public void realizarOperaciones() {
        ManejadorDeExpresionesBooleanas man3 = new ManejadorDeExpresionesBooleanas(this.manejadorDeVariables);
        boolean nuevoValor2 = man3.recorridoDeExpresion(this.cicloWhile.getEx());
        if (!man3.existioErrorAlRealizarLaOperacion()) {
            while (nuevoValor2) {
                for (Nodo instruccion : cicloWhile.getInstrucciones()) {
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
                        this.cicloWhile.setTexto(this.cicloWhile.getTexto() + escritura.getTextoGenerado());
                    } else if (instruccion instanceof Condicion) {
                        Condicion nuevaCondicion = ((Condicion) instruccion);
                        ManejadorDeCondiciones manejador = new ManejadorDeCondiciones(nuevaCondicion, manejadorDeVariables,listaDeErrores);
                        manejador.realizarOperaciones();
                        this.cicloWhile.setTexto(this.cicloWhile.getTexto() + nuevaCondicion.getTexto());
                    } else if (instruccion instanceof CicloFor) {
                        CicloFor cicloF = ((CicloFor) instruccion);
                        cicloF.setVariable(manejadorDeVariables.verificarSiExisteVariable(cicloF.getId()));
                        ManejadorDeCicloFor manejadorF = new ManejadorDeCicloFor(cicloF, manejadorDeVariables,listaDeErrores);
                        manejadorF.realizarOperaciones();
                        this.cicloWhile.setTexto(this.cicloWhile.getTexto() + cicloF.getTexto());
                    } else if (instruccion instanceof CicloWhile) {
                        CicloWhile ciclo = ((CicloWhile) instruccion);
                        ManejadorDeCicloWhile manW = new ManejadorDeCicloWhile(ciclo, manejadorDeVariables,listaDeErrores);
                        manW.realizarOperaciones();
                        this.cicloWhile.setTexto(this.cicloWhile.getTexto() + ciclo.getTexto());
                    }
                }
                nuevoValor2 = man3.recorridoDeExpresion(this.cicloWhile.getEx());
            }
        } else {
            System.out.println("Existioo un error con la expresion del While");
        }
    }

}
