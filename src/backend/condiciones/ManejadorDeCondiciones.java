/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.condiciones;

import backend.ciclos.CicloFor;
import backend.ciclos.ManejadorDeCicloFor;
import backend.Escritura.Escritura;
import backend.Escritura.ManejadorDeEscritura;
import backend.arbolAST.Nodo;
import backend.asignacionCreacionDeVariables.Asignacion;
import backend.asignacionCreacionDeVariables.ManejadorDeAsignacionDeExpresiones;
import backend.asignacionCreacionDeVariables.ManejadorDeCreacionDeVariables;
import backend.ciclos.CicloWhile;
import backend.ciclos.ManejadorDeCicloWhile;
import backend.errores.ErrorAnalisis;
import backend.expesionesBooleanas.ManejadorDeExpresionesBooleanas;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeCondiciones {

    private Condicion condicion;
    private ManejadorDeTablaDeSimbolos manejadorDeVariables;
    private ArrayList<ErrorAnalisis> listaDeErrores;

    public ManejadorDeCondiciones(Condicion condicion, ManejadorDeTablaDeSimbolos man,ArrayList<ErrorAnalisis> listaDeErrores) {
        this.condicion = condicion;
        this.manejadorDeVariables = man;
        this.listaDeErrores=listaDeErrores;
    }

    public void realizarOperaciones() {
        ManejadorDeExpresionesBooleanas man = new ManejadorDeExpresionesBooleanas(manejadorDeVariables);
        boolean valorDeExpresion = man.recorridoDeExpresion(condicion.getEx1());
        if (!man.existioErrorAlRealizarLaOperacion()) {
            if (valorDeExpresion) {
                recorrerLista(this.condicion.getInstruccionesAceptacion());
            } else {
                recorrerLista(this.condicion.getInstruccionesRechazo());
            }
        }
    }

    public void recorrerLista(ArrayList<Nodo> lista) {
        for (Nodo instruccion : lista) {
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
                this.condicion.setTexto(this.condicion.getTexto() + escritura.getTextoGenerado());
            } else if (instruccion instanceof Condicion) {
                Condicion nuevaCondicion = ((Condicion) instruccion);
                ManejadorDeCondiciones manejador = new ManejadorDeCondiciones(nuevaCondicion, manejadorDeVariables,listaDeErrores);
                manejador.realizarOperaciones();
                this.condicion.setTexto(this.condicion.getTexto() + nuevaCondicion.getTexto());
            } else if (instruccion instanceof CicloFor) {
                CicloFor cicloF = ((CicloFor) instruccion);
                ManejadorDeCicloFor manejadorF = new ManejadorDeCicloFor(cicloF, manejadorDeVariables,listaDeErrores);
                manejadorF.realizarOperaciones();
                this.condicion.setTexto(this.condicion.getTexto() + cicloF.getTexto());
            } else if (instruccion instanceof CicloWhile) {
                CicloWhile ciclo = ((CicloWhile) instruccion);
                ManejadorDeCicloWhile manW = new ManejadorDeCicloWhile(ciclo, manejadorDeVariables,listaDeErrores);
                manW.realizarOperaciones();
                this.condicion.setTexto(this.condicion.getTexto() + ciclo.getTexto());
            }
        }
    }
}
