/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eva y Alba
 */
@Entity
@Table(name = "pacientes")
@NamedQueries({
    @NamedQuery(name = "Pacientes.findByUserAndPass", query = "SELECT p FROM Pacientes p WHERE p.dni = :user AND p.password = :pass"),
    @NamedQuery(name = "Pacientes.findByDNI", query = "SELECT p FROM Pacientes p WHERE p.dni = :dni")
})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "NumeroSS")
    private String numeroSS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Password")
    private String password;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientes")
    private Collection<Recetas> recetasCollection;

    public Pacientes() {
    }

    public Pacientes(String dni) {
        this.dni = dni;
    }

    public Pacientes(String dni, String nombre, String numeroSS, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.numeroSS = numeroSS;
        this.password = password;
    }
    
    public Pacientes(Pacientes otroPaciente) {
        this.dni = otroPaciente.dni;
        this.nombre = otroPaciente.nombre;
        this.numeroSS = otroPaciente.numeroSS;
        this.password = otroPaciente.password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Recetas> getRecetasCollection() {
        return recetasCollection;
    }

    public void setRecetasCollection(Collection<Recetas> recetasCollection) {
        this.recetasCollection = recetasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inso.model.Pacientes[ dni=" + dni + " ]";
    }
    
}
