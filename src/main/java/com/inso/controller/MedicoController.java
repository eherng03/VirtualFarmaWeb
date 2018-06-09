/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.controller;

import com.inso.EJB.MedicoFacadeLocal;
import com.inso.EJB.PacientesFacadeLocal;
import com.inso.EJB.RecetasFacade;
import com.inso.EJB.RecetasFacadeLocal;
import com.inso.model.Medico;
import com.inso.model.Pacientes;
import com.inso.model.Recetas;
import com.inso.model.RecetasPK;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Eva y Alba
 */

@ManagedBean(name = "medicoController", eager = true)
@ViewScoped
public class MedicoController implements Serializable{
    @EJB
    private MedicoFacadeLocal medicoEJB;       //Clase que me permite acceder al patron fachada
    private Medico medico;
    
    @EJB
    private RecetasFacadeLocal recetasEJB;       //Clase que me permite acceder al patron fachada
    private Recetas receta;
    
    @EJB
    private PacientesFacadeLocal pacientesEJB;
    private Pacientes paciente;
    
    private boolean showPerfil;
    private boolean showAddReceta;
    
    private String nombreMedicamento;
    private String unidadesToma;
    private boolean cronica;
    private String frecuencia;
    private String duracion;
    private String numEnvases;
    private String instrucciones;
    private String dNIPaciente;
    private String dniSearch;
    
    private Collection<Recetas> recetasList;
    
    @PostConstruct
    public void init(){
        Medico aux = (Medico) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        medico = medicoEJB.findByDNI(aux.getDni());
        if(medico == null){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/public/errorPermisos.xhtml?faces-redirect=true");
            } catch (IOException ex) {
                Logger.getLogger(PacienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        recetasEJB = new RecetasFacade();
        dniSearch = "";
    }

    public String getDniSearch() {
        return dniSearch;
    }

    public void setDniSearch(String dniSearch) {
        this.dniSearch = dniSearch;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }
    
    public MedicoFacadeLocal getMedicoEJB() {
        return medicoEJB;
    }

    public void setMedicoEJB(MedicoFacadeLocal medicoEJB) {
        this.medicoEJB = medicoEJB;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public boolean isShowPerfil() {
        return showPerfil;
    }

    public void setShowPerfil(boolean showPerfil) {
        this.showPerfil = showPerfil;
    }
    
     public RecetasFacadeLocal getRecetasEJB() {
        return recetasEJB;
    }

    public void setRecetasEJB(RecetasFacadeLocal recetasEJB) {
        this.recetasEJB = recetasEJB;
    }

    public Recetas getReceta() {
        return receta;
    }

    public void setReceta(Recetas receta) {
        this.receta = receta;
    }

    public boolean isShowAddReceta() {
        return showAddReceta;
    }

    public void setShowAddReceta(boolean showAddReceta) {
        this.showAddReceta = showAddReceta;
    }

    public String getdNIPaciente() {
        return dNIPaciente;
    }
    
    public Collection<Recetas> getRecetasList() {
        return recetasList;
    }

    public void setRecetasList(Collection<Recetas> recetasList) {
        this.recetasList = recetasList;
    }
    
    public void setdNIPaciente(String dNIPaciente) {
        this.dNIPaciente = dNIPaciente;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getUnidadesToma() {
        return unidadesToma;
    }

    public void setUnidadesToma(String unidadesToma) {
        this.unidadesToma = unidadesToma;
    }

    public boolean isCronica() {
        return cronica;
    }

    public void setCronica(boolean cronica) {
        this.cronica = cronica;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNumEnvases() {
        return numEnvases;
    }

    public void setNumEnvases(String numEnvases) {
        this.numEnvases = numEnvases;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }
    
    public void renderPerfil(){
        showPerfil = true;
        showAddReceta = false;
    }
    
    public void renderAddReceta(){
        showPerfil = false;
        showAddReceta = true;
    }
    
    public String addReceta(){
        paciente = pacientesEJB.findByDNI(dniSearch);
        if(paciente == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "No se encuentra el paciente."));

        }else{
            Date date = new Date();
            RecetasPK recetaPK = new RecetasPK(dniSearch, medico.getDni(), nombreMedicamento, date);
            Recetas recetaX = new Recetas(recetaPK, cronica, Double.parseDouble(unidadesToma), Integer.parseInt(frecuencia), duracion, instrucciones, Integer.parseInt(numEnvases));
            recetasEJB.create(recetaX);
            return "ventanaMedicoPaciente?faces-redirect=true";
        }
        return "";
    }
    
    public void buscarPaciente(){
        paciente = pacientesEJB.findByDNI(dniSearch);
        if(paciente == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "No se encuentra el paciente."));

        }else{
            //En el momento que tengo paciente muestro el boton de añadir receta
            
            showAddReceta = true;
            recetasList = paciente.getRecetasCollection();
        }
    }
    
    public void deleteReceta(Recetas receta){
        recetasEJB.remove(receta);
    }
    
    public void editReceta(Recetas rece){
        recetasEJB.edit(rece);
        //return "ventanaMedicoPaciente?faces-redirect=true";
    }
    
    public String renderNewReceta(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aux", paciente);
        return "ventanaMedicoReceta?faces-redirect=true";
    }
}
