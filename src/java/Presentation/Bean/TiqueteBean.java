/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Bean;

import BusinessLogic.Controller.TiqueteController;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author alex
 */


@ManagedBean(name="tiqueteBean")
@ViewScoped
public class TiqueteBean implements Serializable {
    
    public double precio;
    private String origen;
    private String destino;
    
    
    public void checkout(){
        
        TiqueteController tiqueteController = new TiqueteController();
        precio= tiqueteController.calcularPrecio(origen, destino);        
    
    }
    
    public void consultarTiquete() {        
        
        
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
    
}
