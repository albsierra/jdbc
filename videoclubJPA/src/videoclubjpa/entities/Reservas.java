/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclubjpa.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "reservas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r")
    , @NamedQuery(name = "Reservas.findByIdreserva", query = "SELECT r FROM Reservas r WHERE r.idreserva = :idreserva")
    , @NamedQuery(name = "Reservas.findByFecha", query = "SELECT r FROM Reservas r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Reservas.findBySocio", query = "SELECT r FROM Reservas r WHERE r.socio = :socio")})
public class Reservas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreserva")
    private Integer idreserva;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "socio")
    private String socio;
    @JoinColumn(name = "idPelicula", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Peliculas idPelicula;

    public Reservas() {
    }

    public Reservas(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Reservas(Integer idreserva, Date fecha, String socio) {
        this.idreserva = idreserva;
        this.fecha = fecha;
        this.socio = socio;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        Integer oldIdreserva = this.idreserva;
        this.idreserva = idreserva;
        changeSupport.firePropertyChange("idreserva", oldIdreserva, idreserva);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        String oldSocio = this.socio;
        this.socio = socio;
        changeSupport.firePropertyChange("socio", oldSocio, socio);
    }

    public Peliculas getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Peliculas idPelicula) {
        Peliculas oldIdPelicula = this.idPelicula;
        this.idPelicula = idPelicula;
        changeSupport.firePropertyChange("idPelicula", oldIdPelicula, idPelicula);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserva != null ? idreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.idreserva == null && other.idreserva != null) || (this.idreserva != null && !this.idreserva.equals(other.idreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "videoclubjpa.entities.Reservas[ idreserva=" + idreserva + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
