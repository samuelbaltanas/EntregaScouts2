/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidadaes;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
/**
 *
 * @author Adrián
 */



@Entity
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   private String nombre;
   @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
  
  
  
  //Relaciones
    
    @ManyToMany(mappedBy = "participa_eventos")
    private List<Usuario> participantes;

    
    public Long getId() {
        return id;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    } 
    
    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evento other = (Evento) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

   

   
}
    

