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
@Table(name = "bono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bono.findAll", query = "SELECT b FROM Bono b")
    , @NamedQuery(name = "Bono.findByCodigo", query = "SELECT b FROM Bono b WHERE b.codigo = :codigo")
    , @NamedQuery(name = "Bono.findByDescripcion", query = "SELECT b FROM Bono b WHERE b.descripcion = :descripcion")
    , @NamedQuery(name = "Bono.findByFechaDePago", query = "SELECT b FROM Bono b WHERE b.fechaDePago = :fechaDePago")
    , @NamedQuery(name = "Bono.findByIdBonos", query = "SELECT b FROM Bono b WHERE b.idBonos = :idBonos")
    , @NamedQuery(name = "Bono.findByInteres", query = "SELECT b FROM Bono b WHERE b.interes = :interes")})
public class Bono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaDePago")
    @Temporal(TemporalType.DATE)
    private Date fechaDePago;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBonos")
    private Integer idBonos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interes")
    private float interes;

    public Bono() {
    }

    public Bono(Integer idBonos) {
        this.idBonos = idBonos;
    }

    public Bono(Integer idBonos, String codigo, String descripcion, Date fechaDePago, float interes) {
        this.idBonos = idBonos;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaDePago = fechaDePago;
        this.interes = interes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public Integer getIdBonos() {
        return idBonos;
    }

    public void setIdBonos(Integer idBonos) {
        this.idBonos = idBonos;
    }

    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBonos != null ? idBonos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bono)) {
            return false;
        }
        Bono other = (Bono) object;
        if ((this.idBonos == null && other.idBonos != null) || (this.idBonos != null && !this.idBonos.equals(other.idBonos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.mavenproject2.Bono[ idBonos=" + idBonos + " ]";
    }
    
}
