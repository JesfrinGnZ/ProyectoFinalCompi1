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
        div.setResultado(div.getValor1()/div.getValor2());
        return div.getResultado();
    }

    @Override
    public double vist(Multiplicacion mult) {
        mult.setResultado(mult.getValor1()*mult.getValor2());
        return mult.getResultado();
    }

    @Override
    public double vist(Resta rest) {
        rest.setResultado(rest.getValor1()-rest.getValor2());
        return rest.getResultado();
    }

    @Override
    public double vist(Suma sum) {
        sum.setResultado(sum.getValor1()+sum.getValor2());
        return sum.getResultado();
    }
    
    
    
}
