/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.expesionesBooleanas;

import backend.expresiones.Expresion;
import backend.expresiones.Identificador;
import backend.expresionesAritmeticas.ManejadorDeExpresionesAritmeticas;
import backend.tablaDeSimbolos.ManejadorDeTablaDeSimbolos;
import backend.tablaDeSimbolos.Variable;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeExpresionesBooleanas {

    private boolean existioErrorAlRealizarLaOperacion;
    private ManejadorDeTablaDeSimbolos manejadorDeVariables;

    public ManejadorDeExpresionesBooleanas(ManejadorDeTablaDeSimbolos man) {
        this.manejadorDeVariables = man;
        this.existioErrorAlRealizarLaOperacion = false;
    }

    public boolean recorridoDeExpresion(Expresion expresion){
        boolean valorDeVerdad=true;
        if(!existioErrorAlRealizarLaOperacion){
            if(expresion instanceof ValorDeVerdad){
                ValorDeVerdad op = ((ValorDeVerdad) expresion);
                valorDeVerdad = op.getValorDeVerdad().equals("true");
            }else if(expresion instanceof Identificador){
                Identificador op=((Identificador)expresion);
                //Buscamos la variable
                Variable var=this.manejadorDeVariables.verificarSiExisteVariable(op.getId());
                if(var==null){//Si variable existe y es de tipo booleana
                    //Error semantico, la variable no ha sido declarada
                    System.out.println("Error semantico la variable" +op.getId()+" no ha sido declarada");
                    this.existioErrorAlRealizarLaOperacion=true;
                }else if(!var.getTipoDeVariable().equals("booleana")){
                    //Error semantico la variable no es de tipo booleana
                    this.existioErrorAlRealizarLaOperacion=true;
                    System.out.println("Error semantico, tipos incompatibles:BOOLEAN no se puede convertir a "+var.getTipoDeVariable());
                }else{
                    if(var.getValorDeVariable().equals("true")){
                        valorDeVerdad=true;
                    }else{
                        valorDeVerdad=false;
                    }
                }
            }else if(expresion instanceof OperacionBooleana){
                OperacionBooleana op=((OperacionBooleana)expresion);
                boolean val1=recorridoDeExpresion(op.getEx1());
                boolean val2=recorridoDeExpresion(op.getEx2());
                valorDeVerdad=operacionConValores(op.getOperacion(),val1,val2);
            }else if(expresion instanceof Comparacion){
                Comparacion op=((Comparacion)expresion);
                ManejadorDeExpresionesAritmeticas man = new ManejadorDeExpresionesAritmeticas(manejadorDeVariables);
                int val1=man.recorridoDeOperaciones(op.getEx1());
                int val2=man.recorridoDeOperaciones(op.getEx2());
                valorDeVerdad = operacionDeComparacion(op.getTipoDeComparacion(),val1,val2);
                System.out.println(""+val1+op.getTipoDeComparacion()+""+val2);
            }
            else{
                existioErrorAlRealizarLaOperacion=true;
                System.out.println("Tipos incompatibles en boolean");
            }
        }
        return valorDeVerdad;
    }
    
    
    public boolean existioErrorAlRealizarLaOperacion() {
        return existioErrorAlRealizarLaOperacion;
    }

    public void setExistioErrorAlRealizarLaOperacion(boolean existioErrorAlRealizarLaOperacion) {
        this.existioErrorAlRealizarLaOperacion = existioErrorAlRealizarLaOperacion;
    }

    private boolean operacionConValores(String operacion, boolean val1, boolean val2) {
        boolean valor;
        if(operacion.equals("and")){
            return val1 && val2;
        }else{//Or
            return val1 || val2;
        }
    }

    private boolean operacionDeComparacion(String tipoDeComparacion, int val1, int val2) {
        switch(tipoDeComparacion){
            case ">":
                if(val1>val2) return true;
                break;
            case "<":
                if(val1<val2) return true;
                break;
            case ">=":
                if(val1>=val2) return true;
                break;
            case "<=":
                if(val1<=val2) return true;
                break;
            case "==":
                if(val1==val2) return true;
                break;
            case "<>":
                if(val1!=val2) return true;
                break;
        }
        return false;               
    }

}
