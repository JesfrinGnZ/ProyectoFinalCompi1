/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Visitor;

import backend.AccionesMatematicas.*;

/**
 *
 * @author jesfrin
 */
public interface Visitor {
    
    /*------------------------------------Operaciones Aritmeticas-----------------------------*/
    public double vist(Division div);
    public double vist(Multiplicacion mult);
    public double vist(Resta rest);
    public double vist(Suma sum);
}
