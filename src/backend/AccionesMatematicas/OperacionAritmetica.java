/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.AccionesMatematicas;

/**
 *
 * @author jesfrin
 */
public class OperacionAritmetica {

    private double valor1;
    private double valor2;
    private double resultado;

    public OperacionAritmetica() {
    }

    
    
    public double getValor1(){
        return this.valor1;
    }
    
    public double getValor2(){
        return this.valor2;
    }
    
    public void setValor1(String valor) {
        this.valor1 = Double.parseDouble(valor);
    }

    public void setValor2(String valor) {
        this.valor2 = Double.parseDouble(valor);
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
