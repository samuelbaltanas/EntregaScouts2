/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidadaes;

import java.io.Serializable; 
import java.util.Date;  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jose Antonio
 */
@Entity
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "estado_documento", nullable = false)
    private Estado estado_documento;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_subida", nullable = true)
    private Date fecha_subida;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_limite", nullable = false)
    private Date fecha_limite;
    
    //Relaciones
    @ManyToOne
    private Usuario dueño;

    public Estado getEstadoDocumento() {
        return estado_documento;
    }

    public void setEstadoDocumento(Estado estadoDocumento) {
        this.estado_documento = estadoDocumento;
    }

    public Date getFecha_subida() {
        return fecha_subida;
    }

    public void setFecha_subida(Date fecha_subida) {
        this.fecha_subida = fecha_subida;
    }

    public Date getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(Date fecha_limite) {
        this.fecha_limite = fecha_limite;
    }     
            
    public enum Estado{
        PENDIENTE_ENTREGA,
        PENDIENTE_REVISION,
        CORRECTO
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db_scouts.Documento[ id=" + id + " ]";
    }
    
}
