/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.controller;


import com.inso.EJB.FarmaciaFacade;
import com.inso.EJB.FarmaciaFacadeLocal;
import com.inso.EJB.MedicoFacade;
import com.inso.EJB.MedicoFacadeLocal;
import com.inso.EJB.PacientesFacade;
import com.inso.EJB.PacientesFacadeLocal;
import com.inso.Utils.DataChecks;
import com.inso.model.Farmacia;
import com.inso.model.Medico;
import com.inso.model.Pacientes;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
/**
 *
 * @author Eva
 */
@ManagedBean(name = "registerController", eager = true)
@ViewScoped
public class RegisterController implements Serializable{
    
    //Todo esto no va a ir aqui, va a ir en la pantalla que añada farmacias
    //TODO buscar como crear patron fachada
    @EJB
    private PacientesFacadeLocal pacienteEJB;       //Clase que me permite acceder al patron fachada
    private Pacientes paciente;
    
    @EJB
    private FarmaciaFacadeLocal farmaciaEJB;       //Clase que me permite acceder al patron fachada
    private Farmacia farmacia;
    
    @EJB
    private MedicoFacadeLocal medicoEJB;       //Clase que me permite acceder al patron fachada
    private Medico  medico;
    
    private String dni;
    private String nombre;
    private String ss;
    private String password;
    private String centroMedico;
    private String direccion;
    private String horario;
    private String nombreFarm;
    private String nombreDue;
    private String numeroCue;
    private String telefono;
    private String cif;
    private String email;
    private String codigo;

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNombreFarm() {
        return nombreFarm;
    }

    public void setNombreFarm(String nombreFarm) {
        this.nombreFarm = nombreFarm;
    }

    public String getNombreDue() {
        return nombreDue;
    }

    public void setNombreDue(String nombreDue) {
        this.nombreDue = nombreDue;
    }

    public String getNumeroCue() {
        return numeroCue;
    }

    public void setNumeroCue(String numeroCue) {
        this.numeroCue = numeroCue;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

    public String getCentroMedico() {
        return centroMedico;
    }

    public void setCentroMedico(String centroMedico) {
        this.centroMedico = centroMedico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dniPaciente) {
        this.dni = dniPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombrePaciente) {
        this.nombre = nombrePaciente;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ssPaciente) {
        this.ss = ssPaciente;
    }

   
    
    @PostConstruct
    public void init(){
        paciente = new Pacientes();
        farmacia = new Farmacia();
        medico = new Medico();
        pacienteEJB = new PacientesFacade();
        farmaciaEJB = new FarmaciaFacade();
        medicoEJB = new MedicoFacade();
        dni = "";
        nombre = "";
        ss = "";
        password = "";
        centroMedico = "";
        direccion = "";
        nombreDue = "";
        nombreFarm = "";
        numeroCue = "";
        cif = "";
        horario = "";
        telefono = "";
        email = "";
        codigo = "";
    }
    

    /**
     * Metodo que registra un paciente con los datos introducidos en el sistema.
     * previamente comprueba si esos datos son correctos
     * @return 
     */
    public String registerPaciente() {
        String direccionX = "";
        if(checkParametersPaciente()){
            this.paciente = new Pacientes(dni, nombre, numeroCue, password);
            pacienteEJB.create(paciente);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", paciente);
            direccionX = "./private/paciente/ventanaPaciente.xhtml?faces-redirect=true";
        }       
        return direccionX;
    }   
    
    public String registerFarmacia(){
         String direccionX = "";
        if(codigo == "codigoadmin"){
            if(checkParametersFarmacia()){
                this.farmacia = new Farmacia(cif, nombre, horario, direccion, numeroCue, nombreDue, telefono, email, password);
                farmaciaEJB.create(farmacia);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", farmacia);
                direccionX = "./private/farmacia/ventanaFarmacia.xhtml?faces-redirect=true";
            }
            return direccionX;  
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El código de registro introducido no es válido."));
             
        return "";
    }
    
    public String registerMedico(){
        String direccionX = "";
        if(codigo == "codigoadmin"){
            if(checkParametersMedico()){
                this.medico = new Medico(dni, nombre, ss, direccion, email, centroMedico, password);
                medicoEJB.create(medico);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", medico);
                direccionX = "./private/medico/ventanaMedico.xhtml?faces-redirect=true";
            }
            return direccionX;  
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El código de registro introducido no es válido."));
             
        return "";
    }

    private boolean checkParametersPaciente() {
        DataChecks ch = DataChecks.getInstance();
        FacesContext context = FacesContext.getCurrentInstance();
        //TODO da error checkdni
        /*
        if(!ch.checkDNI(dni)){
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El DNI introducido no es válido."));
            return false;
        }
        if(!ch.checkNumeroSS(ss)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El número de la Seguridad Social introducido no es válido."));
            return false;
        }
        if(!ch.checkCadenaLetrasNumerosOEspacios(password)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "La contraseñasolo puede contener letras o números."));
            return false;
        }*/
        return true;

    }
    
    
    private boolean checkParametersFarmacia() {
        DataChecks ch = DataChecks.getInstance();
        FacesContext context = FacesContext.getCurrentInstance();
        if(!ch.checkCIF(cif)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El CIF introducido no es válido."));
            return false;
        }
        if(!ch.checkCadenaLetrasNumerosOEspacios(password)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "La contraseñasolo puede contener letras o números."));
            return false;
        }
        if(!ch.checkCuentaBancaria(numeroCue)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El numero de cuenta introducido no es válido."));
            return false;
        }
        if(!ch.checkTelefono(telefono)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El telefono introducido no es válido."));
            return false;
        }
        return true;       
    }

    private boolean checkParametersMedico() {
        DataChecks ch = DataChecks.getInstance();
        FacesContext context = FacesContext.getCurrentInstance();
        if(!ch.checkDNI(dni)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El DNI introducido no es válido."));
            return false;
        }   
        if(!ch.checkNumeroSS(ss)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El número de la seguridad social introducido no es válido."));
            return false;
        }  
        if(!ch.checkCadenaLetrasNumerosOEspacios(password)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "La contraseña introducido no es válido."));
            return false;
        } 
        return true;
    }
}
