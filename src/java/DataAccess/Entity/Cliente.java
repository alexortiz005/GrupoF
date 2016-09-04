/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCLIENTE", query = "SELECT c FROM Cliente c WHERE c.clientePK.idCLIENTE = :idCLIENTE"),
    @NamedQuery(name = "Cliente.findByUSUARIOidUSUARIO", query = "SELECT c FROM Cliente c WHERE c.clientePK.uSUARIOidUSUARIO = :uSUARIOidUSUARIO")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientePK clientePK;
    @JoinColumn(name = "AGENCIA_idAGENCIA", referencedColumnName = "idAGENCIA")
    @ManyToOne(optional = false)
    private Agencia aGENCIAidAGENCIA;
    @JoinColumn(name = "TIQUETE_idTIQUETE", referencedColumnName = "idTIQUETE")
    @ManyToOne(optional = false)
    private Tiquete tIQUETEidTIQUETE;
    @JoinColumn(name = "USUARIO_idUSUARIO", referencedColumnName = "idUSUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public Cliente(int idCLIENTE, String uSUARIOidUSUARIO) {
        this.clientePK = new ClientePK(idCLIENTE, uSUARIOidUSUARIO);
    }

    public ClientePK getClientePK() {
        return clientePK;
    }

    public void setClientePK(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public Agencia getAGENCIAidAGENCIA() {
        return aGENCIAidAGENCIA;
    }

    public void setAGENCIAidAGENCIA(Agencia aGENCIAidAGENCIA) {
        this.aGENCIAidAGENCIA = aGENCIAidAGENCIA;
    }

    public Tiquete getTIQUETEidTIQUETE() {
        return tIQUETEidTIQUETE;
    }

    public void setTIQUETEidTIQUETE(Tiquete tIQUETEidTIQUETE) {
        this.tIQUETEidTIQUETE = tIQUETEidTIQUETE;
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
        hash += (clientePK != null ? clientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clientePK == null && other.clientePK != null) || (this.clientePK != null && !this.clientePK.equals(other.clientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Cliente[ clientePK=" + clientePK + " ]";
    }
    
}
