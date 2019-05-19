/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.expresionesAritmeticas;

import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeExpresionesAritmeticas {

    private boolean existioErrorAlRealizarLaOperacion;
    private ManejadorDeTablaDeSimbolos manejadorDeVariables;
    
    public ManejadorDeExpresionesAritmeticas(ManejadorDeTablaDeSimbolos man){
        this.manejadorDeVariables=man;
        this.existioErrorAlRealizarLaOperacion=false;
    }

    
    
    
    
    public Integer recorridoDeOperaciones(ExpresionMatematica expresion) {
        int valor = 0;
        int val1;
        int val2;
        if (!this.existioErrorAlRealizarLaOperacion) {
            if (expresion instanceof OperacionBinaria) {
                //Accionar con el primer elemento
                OperacionBinaria op = ((OperacionBinaria) expresion);
                val1 = recorridoDeOperaciones(op.getEx1());
                val2 = recorridoDeOperaciones(op.getEx2());
                valor = calcularOperacion(op.getOperacion(), val1, val2);
            } else if (expresion instanceof Operando) {
                Operando op = ((Operando) expresion);
                valor = op.getValor();
            } else if (expresion instanceof IdentificadorTipoInt) {
                IdentificadorTipoInt op=((IdentificadorTipoInt)expresion);
                //Buscamos la variable
                Variable var=this.manejadorDeVariables.verificarSiExisteVariable(op.getId());
                if(var==null){//Si variable existe y es de tipo entera
                    //Error semantico, la variable no ha sido declarada
                    System.out.println("Error semantico la variable" +op.getId()+" no ha sido declarada");
                    this.existioErrorAlRealizarLaOperacion=true;
                }else if(!var.getTipoDeVariable().equals("entera")){
                    //Error semantico la variable no es de tipo entero
                    this.existioErrorAlRealizarLaOperacion=true;
                    System.out.println("Error semantico, tipos incompatibles:INTEGER no se puede convertir a "+var.getTipoDeVariable());
                }else{
                    valor=Integer.valueOf(var.getValorDeVariable());
                }
            }
            return valor;
        } else {
            return 0;
        }

    }

    private static int calcularOperacion(String signo, int val1, int val2) {
        switch (signo) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":
                return val1 / val2;
            default:
                System.out.println("ERROR AL CALCULAR VALOR");
                return 0;
        }
    }

    public boolean existioErrorAlRealizarLaOperacion() {
        return existioErrorAlRealizarLaOperacion;
    }

    public void setExistioErrorAlRealizarLaOperacion(boolean existioErrorAlRealizarLaOperacion) {
        this.existioErrorAlRealizarLaOperacion = existioErrorAlRealizarLaOperacion;
    }
    
    
}
