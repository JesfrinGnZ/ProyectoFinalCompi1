/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.AccionesMatematicas;

import backend.Visitor.*;

/**
 *
 * @author jesfrin
 */
public class Resta extends OperacionAritmetica implements Visitable {

    @Override
    public String accept(Visitor visitor) {
        return String.valueOf(visitor.vist(this));
    }
}
