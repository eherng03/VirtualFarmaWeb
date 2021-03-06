/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.model;

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

/**
 *
 * @author Eva
 */
@Entity
@Table(name = "productos")
@NamedQueries({
    @NamedQuery(name = "Productos.findByCIFNombre", query = "SELECT p FROM Productos p WHERE p.productosPK.cIFFarmacia = :cif AND p.productosPK.nombre = :nombre"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.productosPK.nombre = :nombre"),
    @NamedQuery(name = "Productos.findByCIF", query = "SELECT p FROM Productos p WHERE p.productosPK.cIFFarmacia = :cif")
})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosPK productosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cuantia")
    private int cuantia;
    @JoinColumn(name = "CIF_Farmacia", referencedColumnName = "CIF", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Farmacia farmacia;

    public Productos() {
    }

    public Productos(ProductosPK productosPK) {
        this.productosPK = productosPK;
    }

    public Productos(ProductosPK productosPK, double precio, int cuantia) {
        this.productosPK = productosPK;
        this.precio = precio;
        this.cuantia = cuantia;
    }

    public Productos(String cIFFarmacia, String nombre) {
        this.productosPK = new ProductosPK(cIFFarmacia, nombre);
    }

    public ProductosPK getProductosPK() {
        return productosPK;
    }

    public void setProductosPK(ProductosPK productosPK) {
        this.productosPK = productosPK;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCuantia() {
        return cuantia;
    }

    public void setCuantia(int cuantia) {
        this.cuantia = cuantia;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosPK != null ? productosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.productosPK == null && other.productosPK != null) || (this.productosPK != null && !this.productosPK.equals(other.productosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inso.model.Productos[ productosPK=" + productosPK + " ]";
    }
    
}
