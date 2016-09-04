/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Usuario
 */
@Embeddable
public class OperarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idOPERARIO")
    private int idOPERARIO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_idUSUARIO")
    private String uSUARIOidUSUARIO;

    public OperarioPK() {
    }

    public OperarioPK(int idOPERARIO, String uSUARIOidUSUARIO) {
        this.idOPERARIO = idOPERARIO;
        this.uSUARIOidUSUARIO = uSUARIOidUSUARIO;
    }

    public int getIdOPERARIO() {
        return idOPERARIO;
    }

    public void setIdOPERARIO(int idOPERARIO) {
        this.idOPERARIO = idOPERARIO;
    }

    public String getUSUARIOidUSUARIO() {
        return uSUARIOidUSUARIO;
    }

    public void setUSUARIOidUSUARIO(String uSUARIOidUSUARIO) {
        this.uSUARIOidUSUARIO = uSUARIOidUSUARIO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOPERARIO;
        hash += (uSUARIOidUSUARIO != null ? uSUARIOidUSUARIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperarioPK)) {
            return false;
        }
        OperarioPK other = (OperarioPK) object;
        if (this.idOPERARIO != other.idOPERARIO) {
            return false;
        }
        if ((this.uSUARIOidUSUARIO == null && other.uSUARIOidUSUARIO != null) || (this.uSUARIOidUSUARIO != null && !this.uSUARIOidUSUARIO.equals(other.uSUARIOidUSUARIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.OperarioPK[ idOPERARIO=" + idOPERARIO + ", uSUARIOidUSUARIO=" + uSUARIOidUSUARIO + " ]";
    }
    
}
