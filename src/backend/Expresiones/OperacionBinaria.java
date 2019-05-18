/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Expresiones;

/**
 *
 * @author jesfrin
 */
public class OperacionBinaria extends Expresion{
    
    
    public OperacionBinaria(int numeroDeLinea, int numeroDeColumna,Expresion ex1,Expresion ex2,String operacion){
        this.operacion=operacion;
        this.numeroDeLinea=numeroDeLinea;
        this.numeroDeColumna=numeroDeColumna;
        this.ex1=ex1;
        this.ex2=ex2;
    }
    
    private String operacion;
    private Expresion ex1;
    private Expresion ex2;
    private double result;

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Expresion getEx1() {
        return ex1;
    }

    public void setEx1(Expresion ex1) {
        this.ex1 = ex1;
    }

    public Expresion getEx2() {
        return ex2;
    }

    public void setEx2(Expresion ex2) {
        this.ex2 = ex2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public int getNumeroDeLinea() {
        return numeroDeLinea;
    }

    @Override
    public void setNumeroDeLinea(int numeroDeLinea) {
        this.numeroDeLinea = numeroDeLinea;
    }

    @Override
    public int getNumeroDeColumna() {
        return numeroDeColumna;
    }

    @Override
    public void setNumeroDeColumna(int numeroDeColumna) {
        this.numeroDeColumna = numeroDeColumna;
    }
    
    
}
