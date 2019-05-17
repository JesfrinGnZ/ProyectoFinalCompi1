/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.Visitor;

/**
 *
 * @author jesfrin
 */
public interface Visitable {

    public String accept(Visitor visitor);
    
}
