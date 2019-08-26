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
@Table(name = "transaccionsaliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccionsaliente.findAll", query = "SELECT t FROM Transaccionsaliente t")
    , @NamedQuery(name = "Transaccionsaliente.findByCuentaOrigen", query = "SELECT t FROM Transaccionsaliente t WHERE t.cuentaOrigen = :cuentaOrigen")
    , @NamedQuery(name = "Transaccionsaliente.findByCuentaDestino", query = "SELECT t FROM Transaccionsaliente t WHERE t.cuentaDestino = :cuentaDestino")
    , @NamedQuery(name = "Transaccionsaliente.findByImporte", query = "SELECT t FROM Transaccionsaliente t WHERE t.importe = :importe")
    , @NamedQuery(name = "Transaccionsaliente.findByFechaInicio", query = "SELECT t FROM Transaccionsaliente t WHERE t.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Transaccionsaliente.findByFechaFin", query = "SELECT t FROM Transaccionsaliente t WHERE t.fechaFin = :fechaFin")
    , @NamedQuery(name = "Transaccionsaliente.findByEstado", query = "SELECT t FROM Transaccionsaliente t WHERE t.estado = :estado")
    , @NamedQuery(name = "Transaccionsaliente.findByTipo", query = "SELECT t FROM Transaccionsaliente t WHERE t.tipo = :tipo")})
public class Transaccionsaliente implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Id
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

    public Transaccionsaliente() {
    }

    public Transaccionsaliente(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Transaccionsaliente(Date fechaInicio, String cuentaOrigen, String cuentaDestino, float importe, Date fechaFin, String estado, String tipo) {
        this.fechaInicio = fechaInicio;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.importe = importe;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.tipo = tipo;
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
        hash += (fechaInicio != null ? fechaInicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccionsaliente)) {
            return false;
        }
        Transaccionsaliente other = (Transaccionsaliente) object;
        if ((this.fechaInicio == null && other.fechaInicio != null) || (this.fechaInicio != null && !this.fechaInicio.equals(other.fechaInicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.mavenproject2.Transaccionsaliente[ fechaInicio=" + fechaInicio + " ]";
    }
    
}
