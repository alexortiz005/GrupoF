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
public class AdministradorPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "idADMINISTRADOR")
    private String idADMINISTRADOR;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_idUSUARIO")
    private String uSUARIOidUSUARIO;

    public AdministradorPK() {
    }

    public AdministradorPK(String idADMINISTRADOR, String uSUARIOidUSUARIO) {
        this.idADMINISTRADOR = idADMINISTRADOR;
        this.uSUARIOidUSUARIO = uSUARIOidUSUARIO;
    }

    public String getIdADMINISTRADOR() {
        return idADMINISTRADOR;
    }

    public void setIdADMINISTRADOR(String idADMINISTRADOR) {
        this.idADMINISTRADOR = idADMINISTRADOR;
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
        hash += (idADMINISTRADOR != null ? idADMINISTRADOR.hashCode() : 0);
        hash += (uSUARIOidUSUARIO != null ? uSUARIOidUSUARIO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministradorPK)) {
            return false;
        }
        AdministradorPK other = (AdministradorPK) object;
        if ((this.idADMINISTRADOR == null && other.idADMINISTRADOR != null) || (this.idADMINISTRADOR != null && !this.idADMINISTRADOR.equals(other.idADMINISTRADOR))) {
            return false;
        }
        if ((this.uSUARIOidUSUARIO == null && other.uSUARIOidUSUARIO != null) || (this.uSUARIOidUSUARIO != null && !this.uSUARIOidUSUARIO.equals(other.uSUARIOidUSUARIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.AdministradorPK[ idADMINISTRADOR=" + idADMINISTRADOR + ", uSUARIOidUSUARIO=" + uSUARIOidUSUARIO + " ]";
    }
    
}
