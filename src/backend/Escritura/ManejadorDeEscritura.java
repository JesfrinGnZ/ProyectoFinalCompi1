/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Escritura;

import backend.arbolAST.Nodo;
import backend.errores.ErrorAnalisis;
import backend.errores.ErrorSemantico;
import backend.expresiones.Identificador;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeEscritura {

    private Escritura escritura;
    private String textoAEscribir;
    private ManejadorDeTablaDeSimbolos manejadorDeVariables;
    private boolean existioErrorAlRealizarLaOperacion;
    private ArrayList<ErrorAnalisis> listaDeErrores;

    public ManejadorDeEscritura(Escritura escritura, ManejadorDeTablaDeSimbolos man,ArrayList<ErrorAnalisis> listaDeErrores) {
        this.escritura = escritura;
        this.textoAEscribir = "";
        this.manejadorDeVariables = man;
        this.existioErrorAlRealizarLaOperacion = false;
        this.listaDeErrores=listaDeErrores;
    }

    public void manejarEscritura() {
        for (Nodo instruccion : escritura.getInstrucciones()) {
            if (instruccion instanceof Oracion) {
                Oracion op = ((Oracion) instruccion);
                this.textoAEscribir += op.getOracion();
            } else if (instruccion instanceof Identificador) {
                Identificador op = ((Identificador) instruccion);
                //Buscamos la variable
                Variable var = this.manejadorDeVariables.verificarSiExisteVariable(op.getId());
                if (var == null) {//Si variable existe y es de tipo entera
                    //Error semantico, la variable no ha sido declarada
                    //System.out.println("Error semantico la variable" + op.getId() + " no ha sido declarada");
                    ErrorSemantico nuevoError = new ErrorSemantico(op.getNumeroDeLinea(),op.getNumeroDeColumna(), "La variable no ha sido declarada:"+op.getId());
                    this.listaDeErrores.add(nuevoError);
                    this.existioErrorAlRealizarLaOperacion = true;
                } else {
                    this.textoAEscribir += var.getValorDeVariable();
                }
            }
        }
       if(!this.existioErrorAlRealizarLaOperacion){
           this.escritura.setTextoGenerado(this.textoAEscribir);
           System.out.println("INSTRUCCION DE PRINT:"+this.textoAEscribir);
       }else{
           this.escritura.setTextoGenerado("");
       }
    }

    public String getTextoAEscribir() {
        return textoAEscribir;
    }

    public void setTextoAEscribir(String textoAEscribir) {
        this.textoAEscribir = textoAEscribir;
    }

    public boolean existioErrorAlRealizarLaOperacion() {
        return existioErrorAlRealizarLaOperacion;
    }

    public void setExistioErrorAlRealizarLaOperacion(boolean existioErrorAlRealizarLaOperacion) {
        this.existioErrorAlRealizarLaOperacion = existioErrorAlRealizarLaOperacion;
    }

}
