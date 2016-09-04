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
@Table(name = "operario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operario.findAll", query = "SELECT o FROM Operario o"),
    @NamedQuery(name = "Operario.findByIdOPERARIO", query = "SELECT o FROM Operario o WHERE o.operarioPK.idOPERARIO = :idOPERARIO"),
    @NamedQuery(name = "Operario.findBySueldo", query = "SELECT o FROM Operario o WHERE o.sueldo = :sueldo"),
    @NamedQuery(name = "Operario.findByHorario", query = "SELECT o FROM Operario o WHERE o.horario = :horario"),
    @NamedQuery(name = "Operario.findByUSUARIOidUSUARIO", query = "SELECT o FROM Operario o WHERE o.operarioPK.uSUARIOidUSUARIO = :uSUARIOidUSUARIO"),
    @NamedQuery(name = "Operario.findByEstado", query = "SELECT o FROM Operario o WHERE o.estado = :estado"),
    @NamedQuery(name = "Operario.findByOficina", query = "SELECT o FROM Operario o WHERE o.oficina = :oficina")})
public class Operario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OperarioPK operarioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Sueldo")
    private String sueldo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Horario")
    private String horario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Oficina")
    private String oficina;
    @JoinColumn(name = "AGENCIA_idAGENCIA", referencedColumnName = "idAGENCIA")
    @ManyToOne(optional = false)
    private Agencia aGENCIAidAGENCIA;
    @JoinColumn(name = "USUARIO_idUSUARIO", referencedColumnName = "idUSUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Operario() {
    }

    public Operario(OperarioPK operarioPK) {
        this.operarioPK = operarioPK;
    }

    public Operario(OperarioPK operarioPK, String sueldo, String horario, String estado, String oficina) {
        this.operarioPK = operarioPK;
        this.sueldo = sueldo;
        this.horario = horario;
        this.estado = estado;
        this.oficina = oficina;
    }

    public Operario(int idOPERARIO, String uSUARIOidUSUARIO) {
        this.operarioPK = new OperarioPK(idOPERARIO, uSUARIOidUSUARIO);
    }

    public OperarioPK getOperarioPK() {
        return operarioPK;
    }

    public void setOperarioPK(OperarioPK operarioPK) {
        this.operarioPK = operarioPK;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public Agencia getAGENCIAidAGENCIA() {
        return aGENCIAidAGENCIA;
    }

    public void setAGENCIAidAGENCIA(Agencia aGENCIAidAGENCIA) {
        this.aGENCIAidAGENCIA = aGENCIAidAGENCIA;
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
        hash += (operarioPK != null ? operarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operario)) {
            return false;
        }
        Operario other = (Operario) object;
        if ((this.operarioPK == null && other.operarioPK != null) || (this.operarioPK != null && !this.operarioPK.equals(other.operarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Operario[ operarioPK=" + operarioPK + " ]";
    }
    
}
