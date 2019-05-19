/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.tablaDeSimbolos;


/**
 *
 * @author jesfrin
 */
public class Variable {
    //Clave,valor,tipo
    
    private String nombreDeVariable;
    private String tipoDeVariable;
    private String valorDeVariable;

    public Variable(String nombreDeVariable, String tipoDeVariable, String valorDeVariable) {
        this.nombreDeVariable = nombreDeVariable;
        this.tipoDeVariable = tipoDeVariable;
        this.valorDeVariable = valorDeVariable;
    }

    public String getNombreDeVariable() {
        return nombreDeVariable;
    }

    public void setNombreDeVariable(String nombreDeVariable) {
        this.nombreDeVariable = nombreDeVariable;
    }

    public String getTipoDeVariable() {
        return tipoDeVariable;
    }

    public void setTipoDeVariable(String tipoDeVariable) {
        this.tipoDeVariable = tipoDeVariable;
    }

    public String getValorDeVariable() {
        return valorDeVariable;
    }

    public void setValorDeVariable(String valorDeVariable) {
        this.valorDeVariable = valorDeVariable;
    }
    
    

    
}
