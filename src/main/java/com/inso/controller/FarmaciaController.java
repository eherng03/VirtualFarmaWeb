/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.controller;

import com.inso.EJB.FarmaciaFacadeLocal;
import com.inso.EJB.PacientesFacadeLocal;
import com.inso.EJB.ProductosFacadeLocal;
import com.inso.model.Farmacia;
import com.inso.model.Pacientes;
import com.inso.model.Productos;
import com.inso.model.ProductosPK;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Eva y Alba
 */

@ManagedBean(name = "farmaciaController", eager = true)
@ViewScoped
public class FarmaciaController implements Serializable{
    @EJB
    private PacientesFacadeLocal pacienteEJB;       //Clase que me permite acceder al patron fachada
    private Pacientes paciente;
    @EJB
    private FarmaciaFacadeLocal farmaciaEJB;
    private Farmacia farmacia;
    @EJB
    private ProductosFacadeLocal productosEJB;
    private boolean showProductos;
    private boolean showPerfil;
    private boolean showAddProducto;
    private boolean showVenta;

    private String nombreP;
    private String precioP;
    private String cuantiaP;
    private long sumatorio;
    
    private DualListModel<Productos> productos;
    
    @PostConstruct
    public void init(){
        farmacia = (Farmacia) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        
        if(farmacia == null){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/public/errorPermisos.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(PacienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        showProductos = true;
        nombreP = "";
        precioP = "";
        cuantiaP = "";
        
        List<Productos> productosSource = (List<Productos>) farmacia.getProductosCollection();
        List<Productos> productosTarget = new ArrayList<>();
         
        productos = new DualListModel<>(productosSource, productosTarget);
        sumatorio = 0;
    }
    
    public String logOut(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", null);
        return "/index?faces-redirect=true";
    }
    
    public PacientesFacadeLocal getPacienteEJB() {
        return pacienteEJB;
    }

    public void setPacienteEJB(PacientesFacadeLocal pacienteEJB) {
        this.pacienteEJB = pacienteEJB;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public FarmaciaFacadeLocal getFarmaciaEJB() {
        return farmaciaEJB;
    }

    public void setFarmaciaEJB(FarmaciaFacadeLocal farmaciaEJB) {
        this.farmaciaEJB = farmaciaEJB;
    }
    
    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public boolean isShowProductos() {
        return showProductos;
    }

    public void setShowProductos(boolean showProductos) {
        this.showProductos = showProductos;
    }
    
    public boolean isShowPerfil() {
        return showPerfil;
    }

    public void setShowPerfil(boolean showPerfil) {
        this.showPerfil = showPerfil;
    }
    
    public boolean isShowAddProducto() {
        return showAddProducto;
    }

    public void setShowAddProducto(boolean showAddProducto) {
        this.showAddProducto = showAddProducto;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getPrecioP() {
        return precioP;
    }

    public void setPrecioP(String precioP) {
        this.precioP = precioP;
    }

    public String getCuantiaP() {
        return cuantiaP;
    }

    public void setCuantiaP(String cuantiaP) {
        this.cuantiaP = cuantiaP;
    }
     
    public boolean isShowVenta() {
        return showVenta;
    }

    public void setShowVenta(boolean showVenta) {
        this.showVenta = showVenta;
    }
    
    public DualListModel<Productos> getProductos() {
        return productos;
    }

    public void setProductos(DualListModel<Productos> productos) {
        this.productos = productos;
    }
    
    public long getSumatorio() {
        return sumatorio;
    }

    public void setSumatorio(long sumatorio) {
        this.sumatorio = sumatorio;
    }
    

    
    public String addProducto(){
        ProductosPK productoPK = new ProductosPK(farmacia.getCif(), nombreP);
        Productos producto = new Productos(productoPK, Long.parseLong(precioP), Integer.parseInt(cuantiaP));
        this.farmacia.getProductosCollection().add(producto);
        productosEJB.create(producto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Producto añadido con éxito."));
        return "ventanaFarmaciaProducto?faces-redirect=true";
    }
    
    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Productos) item).getProductosPK().getNombre()).append("<br />");
        }
         
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    } 
    
    public void sumatorio(){
        for(Productos producto : productos.getTarget()){
            sumatorio += producto.getPrecio();
        }
    }
}

