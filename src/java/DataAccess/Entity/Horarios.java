/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarios.findAll", query = "SELECT h FROM Horarios h"),
    @NamedQuery(name = "Horarios.findByIdHORARIOS", query = "SELECT h FROM Horarios h WHERE h.idHORARIOS = :idHORARIOS"),
    @NamedQuery(name = "Horarios.findByFechadesalida", query = "SELECT h FROM Horarios h WHERE h.fechadesalida = :fechadesalida"),
    @NamedQuery(name = "Horarios.findByFechallegada", query = "SELECT h FROM Horarios h WHERE h.fechallegada = :fechallegada"),
    @NamedQuery(name = "Horarios.findByHorasalida", query = "SELECT h FROM Horarios h WHERE h.horasalida = :horasalida"),
    @NamedQuery(name = "Horarios.findByHorallegada", query = "SELECT h FROM Horarios h WHERE h.horallegada = :horallegada")})
public class Horarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHORARIOS")
    private Integer idHORARIOS;
    @Column(name = "Fecha de salida")
    @Temporal(TemporalType.DATE)
    private Date fechadesalida;
    @Column(name = "Fecha llegada")
    @Temporal(TemporalType.DATE)
    private Date fechallegada;
    @Column(name = "Hora salida")
    @Temporal(TemporalType.TIME)
    private Date horasalida;
    @Column(name = "Hora llegada")
    @Temporal(TemporalType.TIME)
    private Date horallegada;
    @JoinColumn(name = "AGENCIA_idAGENCIA", referencedColumnName = "idAGENCIA")
    @ManyToOne(optional = false)
    private Agencia aGENCIAidAGENCIA;
    @JoinColumn(name = "VIAJES_idVIAJES", referencedColumnName = "idVIAJES")
    @ManyToOne(optional = false)
    private Viajes vIAJESidVIAJES;

    public Horarios() {
    }

    public Horarios(Integer idHORARIOS) {
        this.idHORARIOS = idHORARIOS;
    }

    public Integer getIdHORARIOS() {
        return idHORARIOS;
    }

    public void setIdHORARIOS(Integer idHORARIOS) {
        this.idHORARIOS = idHORARIOS;
    }

    public Date getFechadesalida() {
        return fechadesalida;
    }

    public void setFechadesalida(Date fechadesalida) {
        this.fechadesalida = fechadesalida;
    }

    public Date getFechallegada() {
        return fechallegada;
    }

    public void setFechallegada(Date fechallegada) {
        this.fechallegada = fechallegada;
    }

    public Date getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(Date horasalida) {
        this.horasalida = horasalida;
    }

    public Date getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(Date horallegada) {
        this.horallegada = horallegada;
    }

    public Agencia getAGENCIAidAGENCIA() {
        return aGENCIAidAGENCIA;
    }

    public void setAGENCIAidAGENCIA(Agencia aGENCIAidAGENCIA) {
        this.aGENCIAidAGENCIA = aGENCIAidAGENCIA;
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
        hash += (idHORARIOS != null ? idHORARIOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.idHORARIOS == null && other.idHORARIOS != null) || (this.idHORARIOS != null && !this.idHORARIOS.equals(other.idHORARIOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Horarios[ idHORARIOS=" + idHORARIOS + " ]";
    }
    
}
