/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.arbol;

import backend.AccionesMatematicas.Division;
import backend.AccionesMatematicas.Multiplicacion;
import backend.AccionesMatematicas.Resta;
import backend.AccionesMatematicas.Suma;
import backend.Visitor.*;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeArbol implements Visitor{

    @Override
    public double vist(Division div) {
        return div.getValor1()/div.getValor2();
    }

    @Override
    public double vist(Multiplicacion mult) {
        return mult.getValor1()*mult.getValor2();
    }

    @Override
    public double vist(Resta rest) {
        return rest.getValor1()-rest.getValor2();
    }

    @Override
    public double vist(Suma sum) {
        return sum.getValor1()+sum.getValor2();
    }
    
    
    
}
