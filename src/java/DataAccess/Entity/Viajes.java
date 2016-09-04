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
@Table(name = "viajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viajes.findAll", query = "SELECT v FROM Viajes v"),
    @NamedQuery(name = "Viajes.findByIdVIAJES", query = "SELECT v FROM Viajes v WHERE v.idVIAJES = :idVIAJES"),
    @NamedQuery(name = "Viajes.findByLugardesalida", query = "SELECT v FROM Viajes v WHERE v.lugardesalida = :lugardesalida"),
    @NamedQuery(name = "Viajes.findByLugardellegada", query = "SELECT v FROM Viajes v WHERE v.lugardellegada = :lugardellegada"),
    @NamedQuery(name = "Viajes.findByPrecioporasiento", query = "SELECT v FROM Viajes v WHERE v.precioporasiento = :precioporasiento")})
public class Viajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVIAJES")
    private Integer idVIAJES;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Lugar de salida")
    private String lugardesalida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Lugar de llegada")
    private String lugardellegada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio por asiento")
    private int precioporasiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vIAJESidVIAJES")
    private Collection<Bus> busCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vIAJESidVIAJES")
    private Collection<Horarios> horariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vIAJESidVIAJES")
    private Collection<Tiquete> tiqueteCollection;
    @JoinColumn(name = "AGENCIA_idAGENCIA", referencedColumnName = "idAGENCIA")
    @ManyToOne(optional = false)
    private Agencia aGENCIAidAGENCIA;

    public Viajes() {
    }

    public Viajes(Integer idVIAJES) {
        this.idVIAJES = idVIAJES;
    }

    public Viajes(Integer idVIAJES, String lugardesalida, String lugardellegada, int precioporasiento) {
        this.idVIAJES = idVIAJES;
        this.lugardesalida = lugardesalida;
        this.lugardellegada = lugardellegada;
        this.precioporasiento = precioporasiento;
    }

    public Integer getIdVIAJES() {
        return idVIAJES;
    }

    public void setIdVIAJES(Integer idVIAJES) {
        this.idVIAJES = idVIAJES;
    }

    public String getLugardesalida() {
        return lugardesalida;
    }

    public void setLugardesalida(String lugardesalida) {
        this.lugardesalida = lugardesalida;
    }

    public String getLugardellegada() {
        return lugardellegada;
    }

    public void setLugardellegada(String lugardellegada) {
        this.lugardellegada = lugardellegada;
    }

    public int getPrecioporasiento() {
        return precioporasiento;
    }

    public void setPrecioporasiento(int precioporasiento) {
        this.precioporasiento = precioporasiento;
    }

    @XmlTransient
    public Collection<Bus> getBusCollection() {
        return busCollection;
    }

    public void setBusCollection(Collection<Bus> busCollection) {
        this.busCollection = busCollection;
    }

    @XmlTransient
    public Collection<Horarios> getHorariosCollection() {
        return horariosCollection;
    }

    public void setHorariosCollection(Collection<Horarios> horariosCollection) {
        this.horariosCollection = horariosCollection;
    }

    @XmlTransient
    public Collection<Tiquete> getTiqueteCollection() {
        return tiqueteCollection;
    }

    public void setTiqueteCollection(Collection<Tiquete> tiqueteCollection) {
        this.tiqueteCollection = tiqueteCollection;
    }

    public Agencia getAGENCIAidAGENCIA() {
        return aGENCIAidAGENCIA;
    }

    public void setAGENCIAidAGENCIA(Agencia aGENCIAidAGENCIA) {
        this.aGENCIAidAGENCIA = aGENCIAidAGENCIA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVIAJES != null ? idVIAJES.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viajes)) {
            return false;
        }
        Viajes other = (Viajes) object;
        if ((this.idVIAJES == null && other.idVIAJES != null) || (this.idVIAJES != null && !this.idVIAJES.equals(other.idVIAJES))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Viajes[ idVIAJES=" + idVIAJES + " ]";
    }
    
}
