/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByIdADMINISTRADOR", query = "SELECT a FROM Administrador a WHERE a.administradorPK.idADMINISTRADOR = :idADMINISTRADOR"),
    @NamedQuery(name = "Administrador.findByUSUARIOidUSUARIO", query = "SELECT a FROM Administrador a WHERE a.administradorPK.uSUARIOidUSUARIO = :uSUARIOidUSUARIO"),
    @NamedQuery(name = "Administrador.findBySueldo", query = "SELECT a FROM Administrador a WHERE a.sueldo = :sueldo")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdministradorPK administradorPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Sueldo")
    private String sueldo;
    @JoinColumn(name = "USUARIO_idUSUARIO", referencedColumnName = "idUSUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Administrador() {
    }

    public Administrador(AdministradorPK administradorPK) {
        this.administradorPK = administradorPK;
    }

    public Administrador(AdministradorPK administradorPK, String sueldo) {
        this.administradorPK = administradorPK;
        this.sueldo = sueldo;
    }

    public Administrador(String idADMINISTRADOR, String uSUARIOidUSUARIO) {
        this.administradorPK = new AdministradorPK(idADMINISTRADOR, uSUARIOidUSUARIO);
    }

    public AdministradorPK getAdministradorPK() {
        return administradorPK;
    }

    public void setAdministradorPK(AdministradorPK administradorPK) {
        this.administradorPK = administradorPK;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (administradorPK != null ? administradorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.administradorPK == null && other.administradorPK != null) || (this.administradorPK != null && !this.administradorPK.equals(other.administradorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Administrador[ administradorPK=" + administradorPK + " ]";
    }
    
}
