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
public class ClientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idCLIENTE")
    private int idCLIENTE;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_idUSUARIO")
    private String uSUARIOidUSUARIO;

    public ClientePK() {
    }

    public ClientePK(int idCLIENTE, String uSUARIOidUSUARIO) {
        this.idCLIENTE = idCLIENTE;
        this.uSUARIOidUSUARIO = uSUARIOidUSUARIO;
    }

    public int getIdCLIENTE() {
        return idCLIENTE;
    }

    public void setIdCLIENTE(int idCLIENTE) {
        this.idCLIENTE = idCLIENTE;
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
        hash += (int) idCLIENTE;
        hash += (uSUARIOidUSUARIO != null ? uSUARIOidUSUARIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientePK)) {
            return false;
        }
        ClientePK other = (ClientePK) object;
        if (this.idCLIENTE != other.idCLIENTE) {
            return false;
        }
        if ((this.uSUARIOidUSUARIO == null && other.uSUARIOidUSUARIO != null) || (this.uSUARIOidUSUARIO != null && !this.uSUARIOidUSUARIO.equals(other.uSUARIOidUSUARIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.ClientePK[ idCLIENTE=" + idCLIENTE + ", uSUARIOidUSUARIO=" + uSUARIOidUSUARIO + " ]";
    }
    
}
