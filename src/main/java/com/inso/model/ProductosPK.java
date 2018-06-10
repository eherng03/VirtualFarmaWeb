/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Eva y Alba
 */
@Embeddable
public class ProductosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "CIF_Farmacia")
    private String cIFFarmacia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String nombre;

    public ProductosPK() {
    }

    public ProductosPK(String cIFFarmacia, String nombre) {
        this.cIFFarmacia = cIFFarmacia;
        this.nombre = nombre;
    }

    public String getCIFFarmacia() {
        return cIFFarmacia;
    }

    public void setCIFFarmacia(String cIFFarmacia) {
        this.cIFFarmacia = cIFFarmacia;
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
        hash += (cIFFarmacia != null ? cIFFarmacia.hashCode() : 0);
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosPK)) {
            return false;
        }
        ProductosPK other = (ProductosPK) object;
        if ((this.cIFFarmacia == null && other.cIFFarmacia != null) || (this.cIFFarmacia != null && !this.cIFFarmacia.equals(other.cIFFarmacia))) {
            return false;
        }
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inso.model.ProductosPK[ cIFFarmacia=" + cIFFarmacia + ", nombre=" + nombre + " ]";
    }
    
}
