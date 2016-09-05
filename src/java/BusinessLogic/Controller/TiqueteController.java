/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

import DataAccess.Entity.Tiquete;

/**
 *
 * @author alex
 */
public class TiqueteController {
    
    public double calcularPrecio(String origen, String destino){
        return Tiquete.calcularPrecio(origen, destino);
    }
    
}
