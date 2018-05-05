/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidadaes;

import java.io.Serializable;
import java.util.Objects;

 
/**
 *
 * @author sam
 */
public class HistorialID implements Serializable{
       private int id;
     private Long credencial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public Long getCredencial() {
        return credencial;
    }

    public void setCredencial(Long credencial) {
        this.credencial = credencial;
    }
     
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.credencial);
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
        final HistorialID other = (HistorialID) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.credencial, other.credencial)) {
            return false;
        }
        return true;
    }
     
     
}
