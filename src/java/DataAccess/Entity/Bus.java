/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "bus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bus.findAll", query = "SELECT b FROM Bus b"),
    @NamedQuery(name = "Bus.findByIdBUS", query = "SELECT b FROM Bus b WHERE b.idBUS = :idBUS"),
    @NamedQuery(name = "Bus.findByNumeroAsientos", query = "SELECT b FROM Bus b WHERE b.numeroAsientos = :numeroAsientos"),
    @NamedQuery(name = "Bus.findByTipo", query = "SELECT b FROM Bus b WHERE b.tipo = :tipo")})
public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBUS")
    private Integer idBUS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumeroAsientos")
    private int numeroAsientos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tipo")
    private String tipo;
    @JoinColumn(name = "VIAJES_idVIAJES", referencedColumnName = "idVIAJES")
    @ManyToOne(optional = false)
    private Viajes vIAJESidVIAJES;
    @JoinColumn(name = "AGENCIA_idAGENCIA", referencedColumnName = "idAGENCIA")
    @ManyToOne(optional = false)
    private Agencia aGENCIAidAGENCIA;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bUSidBUS")
    private Collection<Tiquete> tiqueteCollection;

    public Bus() {
    }

    public Bus(Integer idBUS) {
        this.idBUS = idBUS;
    }

    public Bus(Integer idBUS, int numeroAsientos, String tipo) {
        this.idBUS = idBUS;
        this.numeroAsientos = numeroAsientos;
        this.tipo = tipo;
    }

    public Integer getIdBUS() {
        return idBUS;
    }

    public void setIdBUS(Integer idBUS) {
        this.idBUS = idBUS;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Viajes getVIAJESidVIAJES() {
        return vIAJESidVIAJES;
    }

    public void setVIAJESidVIAJES(Viajes vIAJESidVIAJES) {
        this.vIAJESidVIAJES = vIAJESidVIAJES;
    }

    public Agencia getAGENCIAidAGENCIA() {
        return aGENCIAidAGENCIA;
    }

    public void setAGENCIAidAGENCIA(Agencia aGENCIAidAGENCIA) {
        this.aGENCIAidAGENCIA = aGENCIAidAGENCIA;
    }

    @XmlTransient
    public Collection<Tiquete> getTiqueteCollection() {
        return tiqueteCollection;
    }

    public void setTiqueteCollection(Collection<Tiquete> tiqueteCollection) {
        this.tiqueteCollection = tiqueteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBUS != null ? idBUS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bus)) {
            return false;
        }
        Bus other = (Bus) object;
        if ((this.idBUS == null && other.idBUS != null) || (this.idBUS != null && !this.idBUS.equals(other.idBUS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Bus[ idBUS=" + idBUS + " ]";
    }
    
}
