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
@Table(name = "agencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agencia.findAll", query = "SELECT a FROM Agencia a"),
    @NamedQuery(name = "Agencia.findByIdAGENCIA", query = "SELECT a FROM Agencia a WHERE a.idAGENCIA = :idAGENCIA"),
    @NamedQuery(name = "Agencia.findByNombre", query = "SELECT a FROM Agencia a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Agencia.findByDireccion", query = "SELECT a FROM Agencia a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Agencia.findByTelefono", query = "SELECT a FROM Agencia a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Agencia.findByCiudad", query = "SELECT a FROM Agencia a WHERE a.ciudad = :ciudad"),
    @NamedQuery(name = "Agencia.findByDepartamento", query = "SELECT a FROM Agencia a WHERE a.departamento = :departamento"),
    @NamedQuery(name = "Agencia.findByDescripcion", query = "SELECT a FROM Agencia a WHERE a.descripcion = :descripcion")})
public class Agencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAGENCIA")
    private Integer idAGENCIA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefono")
    private long telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Departamento")
    private String departamento;
    @Size(max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aGENCIAidAGENCIA")
    private Collection<Bus> busCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aGENCIAidAGENCIA")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aGENCIAidAGENCIA")
    private Collection<Horarios> horariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aGENCIAidAGENCIA")
    private Collection<Viajes> viajesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aGENCIAidAGENCIA")
    private Collection<Operario> operarioCollection;

    public Agencia() {
    }

    public Agencia(Integer idAGENCIA) {
        this.idAGENCIA = idAGENCIA;
    }

    public Agencia(Integer idAGENCIA, String nombre, String direccion, long telefono, String ciudad, String departamento) {
        this.idAGENCIA = idAGENCIA;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.departamento = departamento;
    }

    public Integer getIdAGENCIA() {
        return idAGENCIA;
    }

    public void setIdAGENCIA(Integer idAGENCIA) {
        this.idAGENCIA = idAGENCIA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Bus> getBusCollection() {
        return busCollection;
    }

    public void setBusCollection(Collection<Bus> busCollection) {
        this.busCollection = busCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Horarios> getHorariosCollection() {
        return horariosCollection;
    }

    public void setHorariosCollection(Collection<Horarios> horariosCollection) {
        this.horariosCollection = horariosCollection;
    }

    @XmlTransient
    public Collection<Viajes> getViajesCollection() {
        return viajesCollection;
    }

    public void setViajesCollection(Collection<Viajes> viajesCollection) {
        this.viajesCollection = viajesCollection;
    }

    @XmlTransient
    public Collection<Operario> getOperarioCollection() {
        return operarioCollection;
    }

    public void setOperarioCollection(Collection<Operario> operarioCollection) {
        this.operarioCollection = operarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAGENCIA != null ? idAGENCIA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agencia)) {
            return false;
        }
        Agencia other = (Agencia) object;
        if ((this.idAGENCIA == null && other.idAGENCIA != null) || (this.idAGENCIA != null && !this.idAGENCIA.equals(other.idAGENCIA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Agencia[ idAGENCIA=" + idAGENCIA + " ]";
    }
    
}
