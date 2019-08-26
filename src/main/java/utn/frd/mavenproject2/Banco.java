/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.mavenproject2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b")
    , @NamedQuery(name = "Banco.findByApicode", query = "SELECT b FROM Banco b WHERE b.apicode = :apicode")
    , @NamedQuery(name = "Banco.findByIdBanco", query = "SELECT b FROM Banco b WHERE b.idBanco = :idBanco")
    , @NamedQuery(name = "Banco.findByIntegrantes", query = "SELECT b FROM Banco b WHERE b.integrantes = :integrantes")
    , @NamedQuery(name = "Banco.findByNombre", query = "SELECT b FROM Banco b WHERE b.nombre = :nombre")})
public class Banco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "apicode")
    private String apicode;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBanco")
    private Integer idBanco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "integrantes")
    private String integrantes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nombre")
    private String nombre;

    public Banco() {
    }

    public Banco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public Banco(Integer idBanco, String apicode, String integrantes, String nombre) {
        this.idBanco = idBanco;
        this.apicode = apicode;
        this.integrantes = integrantes;
        this.nombre = nombre;
    }

    public String getApicode() {
        return apicode;
    }

    public void setApicode(String apicode) {
        this.apicode = apicode;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(String integrantes) {
        this.integrantes = integrantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanco != null ? idBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.idBanco == null && other.idBanco != null) || (this.idBanco != null && !this.idBanco.equals(other.idBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.mavenproject2.Banco[ idBanco=" + idBanco + " ]";
    }
    
}
