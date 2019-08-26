/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.mavenproject2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "transacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacciones.findAll", query = "SELECT t FROM Transacciones t")
    , @NamedQuery(name = "Transacciones.findById", query = "SELECT t FROM Transacciones t WHERE t.id = :id")
    , @NamedQuery(name = "Transacciones.findByCuentaOrigen", query = "SELECT t FROM Transacciones t WHERE t.cuentaOrigen = :cuentaOrigen")
    , @NamedQuery(name = "Transacciones.findByCuentaDestino", query = "SELECT t FROM Transacciones t WHERE t.cuentaDestino = :cuentaDestino")
    , @NamedQuery(name = "Transacciones.findByImporte", query = "SELECT t FROM Transacciones t WHERE t.importe = :importe")
    , @NamedQuery(name = "Transacciones.findByFechaInicio", query = "SELECT t FROM Transacciones t WHERE t.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Transacciones.findByFechaFin", query = "SELECT t FROM Transacciones t WHERE t.fechaFin = :fechaFin")
    , @NamedQuery(name = "Transacciones.findByEstado", query = "SELECT t FROM Transacciones t WHERE t.estado = :estado")
    , @NamedQuery(name = "Transacciones.findByTipo", query = "SELECT t FROM Transacciones t WHERE t.tipo = :tipo")})
public class Transacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "cuentaOrigen")
    private String cuentaOrigen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "cuentaDestino")
    private String cuentaDestino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private float importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "tipo")
    private String tipo;

    public Transacciones() {
    }

    public Transacciones(Integer id) {
        this.id = id;
    }

    public Transacciones(Integer id, String cuentaOrigen, String cuentaDestino, float importe, Date fechaInicio, Date fechaFin, String estado, String tipo) {
        this.id = id;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.importe = importe;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacciones)) {
            return false;
        }
        Transacciones other = (Transacciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.mavenproject2.Transacciones[ id=" + id + " ]";
    }
    
}
