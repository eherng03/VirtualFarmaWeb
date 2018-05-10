/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Productos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Eva
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> implements ProductosFacadeLocal {

    @PersistenceContext(unitName = "ViartualFarma_Persistence_Unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }

    @Override
    public void removeByCIFNombre(String cif, String nombre) {
        
    }

    @Override
    public Productos findByCIFNombre(String cif, String nombre) {
        String consulta;
        Productos producto = null;
        try {
            consulta = "SELECT p FROM Productos p WHERE p.cif = ?1 AND p.nombre = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, cif);
            query.setParameter(2, nombre);
            List<Productos> listaProductos = query.getResultList();
            
            if(!listaProductos.isEmpty()){
                producto = listaProductos.get(0);
            }
            
        } catch (Exception e) {
            
        }
        return producto;
    }
    
}
