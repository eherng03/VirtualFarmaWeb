/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.controller;

import com.inso.EJB.FarmaciaFacadeLocal;
import com.inso.EJB.PacientesFacadeLocal;
import com.inso.EJB.ProductosFacadeLocal;
import com.inso.EJB.RecetasFacade;
import com.inso.EJB.RecetasFacadeLocal;
import com.inso.model.Farmacia;
import com.inso.model.Pacientes;
import com.inso.model.Productos;
import com.inso.model.ProductosPK;
import com.inso.model.Recetas;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
    @EJB
    private RecetasFacadeLocal recetasEJB;   
    
    private boolean showProductos;
    private boolean showPerfil;
    private boolean showAddProducto;
    private boolean showVenta;

    private String nombreP;
    private String precioP;
    private String cuantiaP;
    private double sumatorio;
    
    private DualListModel<Productos> dualProductos;
    
    private String dniSearch;
    private boolean showAddReceta;
    
    private Collection<Recetas> recetasList;
    
    @PostConstruct
    public void init(){
        Farmacia farmaciaAux = (Farmacia) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        farmacia = farmaciaEJB.find(farmaciaAux.getCif());
        if(farmacia == null){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/public/errorPermisos.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(PacienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        recetasEJB = new RecetasFacade();
        showProductos = true;
        nombreP = "";
        precioP = "";
        cuantiaP = "";
        
        List<Productos> productos = (List<Productos>) productosEJB.findByCIF(farmacia.getCif());
        List<Productos> productosSource = new ArrayList<>();
        List<Productos> productosTarget = new ArrayList<>();
        for(Productos producto : productos){
            if(producto.getCuantia() > 0){
                for(int i = 0; i < producto.getCuantia(); i++){
                    productosSource.add(producto);
                }
            }
        }
         
        dualProductos = new DualListModel<>(productosSource, productosTarget);
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
    
    public DualListModel<Productos> getDualProductos() {
        return dualProductos;
    }

    public void setDualProductos(DualListModel<Productos> dualProductos) {
        this.dualProductos = dualProductos;
    }
    
    public double getSumatorio() {
        for(Productos producto : dualProductos.getTarget()){
            sumatorio += producto.getPrecio();
        }
        return sumatorio;
    }

    public void setSumatorio(double sumatorio) {
        this.sumatorio = sumatorio;
    }
    
    public String getDniSearch() {
        return dniSearch;
    }

    public void setDniSearch(String dniSearch) {
        this.dniSearch = dniSearch;
    }
    
    public String addProducto(){
        ProductosPK productoPK = new ProductosPK(farmacia.getCif(), nombreP);
        Productos producto = new Productos(productoPK, Double.parseDouble(precioP), Integer.parseInt(cuantiaP));

        productosEJB.create(producto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Producto añadido con éxito."));
        return "ventanaFarmaciaProducto?faces-redirect=true";
    }
    
    public boolean isShowAddReceta() {
        return showAddReceta;
    }

    public void setShowAddReceta(boolean showAddReceta) {
        this.showAddReceta = showAddReceta;
    }

    public Collection<Recetas> getRecetasList() {
        return recetasList;
    }

    public void setRecetasList(Collection<Recetas> recetasList) {
        this.recetasList = recetasList;
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
    
    public String deleteProducto(Productos producto){
        productosEJB.remove(producto);
        return "ventanaFarmaciaLista?faces-redirect=true";
    }
    
    public String editProducto(Productos producto){
        productosEJB.edit(producto);
        return "ventanaFarmaciaLista?faces-redirect=true";
    }
    
    public void vender(){
        for(Productos producto : dualProductos.getTarget()){
            producto.setCuantia(producto.getCuantia() - 1);
            productosEJB.edit(producto);
        }    
    }
    
    public void buscarPaciente(){
        paciente = pacienteEJB.findByDNI(dniSearch);
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
}

