/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.variablesEnteras;

import backend.expresionesAritmeticas.ExpresionMatematica;
import backend.expresionesAritmeticas.ManejadorDeExpresionesAritmeticas;
import backend.tablaDeSimbolos.*;

/**
 *
 * @author jesfrin
 */
public class ManejadorAsignacionesEnteras {
    
    public static void recorridoDeAsignaciones(AsignacionEntero asignacion,ManejadorDeTablaDeSimbolos manejadorDeVariables){
        String nombreDeVariable=asignacion.getNombre();
        //Buscamos si existe el nombre de variable
        ExpresionMatematica exp = asignacion.getExpresion();
        Variable var=manejadorDeVariables.verificarSiExisteVariable(nombreDeVariable);
        if(exp==null){//Es una asignacion,por lo cual no debe existir una variable con el mismo nombre
            if(var==null){
                var = new Variable(nombreDeVariable, "entera", "0");
                manejadorDeVariables.anadirVariable(var);
            }else{
                System.out.println("Error semantico, ya existe la variable con el nombre:"+nombreDeVariable+" Linea:"+asignacion.getNumeroDeLinea()+" Columna:"+asignacion.getNumeroDeColumna());
            }
        }else{//Es una declaracion 
            if(var==null){//Aun no existe la variable
                System.out.println("Error semantico la variable:"+nombreDeVariable+" no ha sido declarada");
            }else{
                ManejadorDeExpresionesAritmeticas manejador = new ManejadorDeExpresionesAritmeticas(manejadorDeVariables);
                int nuevoValor = manejador.recorridoDeOperaciones(exp);
                if(!manejador.existioErrorAlRealizarLaOperacion()){//Se le asigna un nuevo valor a la variable de no habe error
                    var.setValorDeVariable(String.valueOf(nuevoValor));
                }else{
                    
                }
            }
        }
    }
}
