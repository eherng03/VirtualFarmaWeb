/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Eva
 */
@Embeddable
public class RecetasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "DNI_Paciente")
    private String dNIPaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "DNI_Medico")
    private String dNIMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NombreMedicamento")
    private String nombreMedicamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public RecetasPK() {
    }

    public RecetasPK(String dNIPaciente, String dNIMedico, String nombreMedicamento, Date fecha) {
        this.dNIPaciente = dNIPaciente;
        this.dNIMedico = dNIMedico;
        this.nombreMedicamento = nombreMedicamento;
        this.fecha = fecha;
    }

    public String getDNIPaciente() {
        return dNIPaciente;
    }

    public void setDNIPaciente(String dNIPaciente) {
        this.dNIPaciente = dNIPaciente;
    }

    public String getDNIMedico() {
        return dNIMedico;
    }

    public void setDNIMedico(String dNIMedico) {
        this.dNIMedico = dNIMedico;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dNIPaciente != null ? dNIPaciente.hashCode() : 0);
        hash += (dNIMedico != null ? dNIMedico.hashCode() : 0);
        hash += (nombreMedicamento != null ? nombreMedicamento.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecetasPK)) {
            return false;
        }
        RecetasPK other = (RecetasPK) object;
        if ((this.dNIPaciente == null && other.dNIPaciente != null) || (this.dNIPaciente != null && !this.dNIPaciente.equals(other.dNIPaciente))) {
            return false;
        }
        if ((this.dNIMedico == null && other.dNIMedico != null) || (this.dNIMedico != null && !this.dNIMedico.equals(other.dNIMedico))) {
            return false;
        }
        if ((this.nombreMedicamento == null && other.nombreMedicamento != null) || (this.nombreMedicamento != null && !this.nombreMedicamento.equals(other.nombreMedicamento))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inso.model.RecetasPK[ dNIPaciente=" + dNIPaciente + ", dNIMedico=" + dNIMedico + ", nombreMedicamento=" + nombreMedicamento + ", fecha=" + fecha + " ]";
    }
    
}
