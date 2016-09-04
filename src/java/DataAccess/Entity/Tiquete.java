/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "tiquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiquete.findAll", query = "SELECT t FROM Tiquete t"),
    @NamedQuery(name = "Tiquete.findByIdTIQUETE", query = "SELECT t FROM Tiquete t WHERE t.idTIQUETE = :idTIQUETE"),
    @NamedQuery(name = "Tiquete.findByFecha", query = "SELECT t FROM Tiquete t WHERE t.fecha = :fecha")})
public class Tiquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTIQUETE")
    private Integer idTIQUETE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tIQUETEidTIQUETE")
    private Collection<Cliente> clienteCollection;
    @JoinColumn(name = "BUS_idBUS", referencedColumnName = "idBUS")
    @ManyToOne(optional = false)
    private Bus bUSidBUS;
    @JoinColumn(name = "VIAJES_idVIAJES", referencedColumnName = "idVIAJES")
    @ManyToOne(optional = false)
    private Viajes vIAJESidVIAJES;

    public Tiquete() {
    }

    public Tiquete(Integer idTIQUETE) {
        this.idTIQUETE = idTIQUETE;
    }

    public Tiquete(Integer idTIQUETE, Date fecha) {
        this.idTIQUETE = idTIQUETE;
        this.fecha = fecha;
    }

    public Integer getIdTIQUETE() {
        return idTIQUETE;
    }

    public void setIdTIQUETE(Integer idTIQUETE) {
        this.idTIQUETE = idTIQUETE;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Bus getBUSidBUS() {
        return bUSidBUS;
    }

    public void setBUSidBUS(Bus bUSidBUS) {
        this.bUSidBUS = bUSidBUS;
    }

    public Viajes getVIAJESidVIAJES() {
        return vIAJESidVIAJES;
    }

    public void setVIAJESidVIAJES(Viajes vIAJESidVIAJES) {
        this.vIAJESidVIAJES = vIAJESidVIAJES;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTIQUETE != null ? idTIQUETE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiquete)) {
            return false;
        }
        Tiquete other = (Tiquete) object;
        if ((this.idTIQUETE == null && other.idTIQUETE != null) || (this.idTIQUETE != null && !this.idTIQUETE.equals(other.idTIQUETE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Tiquete[ idTIQUETE=" + idTIQUETE + " ]";
    }
    
}
