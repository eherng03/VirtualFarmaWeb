/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eva
 */
@Entity
@Table(name = "recetas")
@NamedQueries({
    @NamedQuery(name = "Recetas.removeIDs", query = "DELETE r FROM Recetas r WHERE r.dNIPaciente = :dniPaciente AND r.nombreMedicamento = :nombreMedicamento AND r.fecha = :fecha"),
    @NamedQuery(name = "Recetas.findByDNI", query = "SELECT r FROM Recetas r WHERE r.dNIPaciente = :dni"),
})
public class Recetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecetasPK recetasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cronica")
    private boolean cronica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UnidadesToma")
    private double unidadesToma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Frecuencia")
    private int frecuencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Duracion")
    private String duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Instrucciones")
    private String instrucciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumEnvases")
    private int numEnvases;
    @JoinColumn(name = "DNI_Paciente", referencedColumnName = "DNI", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Pacientes pacientes;
    @JoinColumn(name = "DNI_Medico", referencedColumnName = "DNI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medico medicos;

    public Recetas() {
    }

    public Recetas(RecetasPK recetasPK) {
        this.recetasPK = recetasPK;
    }

    public Recetas(RecetasPK recetasPK, boolean cronica, double unidadesToma, int frecuencia, String duracion, String instrucciones, int numEnvases) {
        this.recetasPK = recetasPK;
        this.cronica = cronica;
        this.unidadesToma = unidadesToma;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
        this.instrucciones = instrucciones;
        this.numEnvases = numEnvases;
    }

    public Recetas(String dNIPaciente, String dNIMedico, String nombreMedicamento, Date fecha) {
        this.recetasPK = new RecetasPK(dNIPaciente, dNIMedico, nombreMedicamento, fecha);
    }

    public RecetasPK getRecetasPK() {
        return recetasPK;
    }

    public void setRecetasPK(RecetasPK recetasPK) {
        this.recetasPK = recetasPK;
    }

    public boolean getCronica() {
        return cronica;
    }

    public void setCronica(boolean cronica) {
        this.cronica = cronica;
    }

    public double getUnidadesToma() {
        return unidadesToma;
    }

    public void setUnidadesToma(double unidadesToma) {
        this.unidadesToma = unidadesToma;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public int getNumEnvases() {
        return numEnvases;
    }

    public void setNumEnvases(int numEnvases) {
        this.numEnvases = numEnvases;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public Medico getMedicos() {
        return medicos;
    }

    public void setMedicos(Medico medicos) {
        this.medicos = medicos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recetasPK != null ? recetasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recetas)) {
            return false;
        }
        Recetas other = (Recetas) object;
        if ((this.recetasPK == null && other.recetasPK != null) || (this.recetasPK != null && !this.recetasPK.equals(other.recetasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inso.model.Recetas[ recetasPK=" + recetasPK + " ]";
    }
    
}
