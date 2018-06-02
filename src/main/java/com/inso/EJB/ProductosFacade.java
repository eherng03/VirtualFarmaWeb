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
 * @author Eva y Alba
 */
@Stateless
public class ProductosFacade extends OwnEntityManager<Productos> implements ProductosFacadeLocal {


    @Override
    public void removeByCIFNombre(String cif, String nombre) {
        
    }

    @Override
    public Productos findByCIFNombre(String cif, String nombre) {
        String consulta;
        Productos producto = null;
        try {
            consulta = "SELECT p FROM Productos p WHERE p.cif = :cif AND p.nombre = :nombre";
            Query query = getEntityManager().createQuery(consulta);
            query.setParameter("cif", cif);
            query.setParameter("nombre", nombre);
            List<Productos> listaProductos = query.getResultList();
            
            if(!listaProductos.isEmpty()){
                producto = listaProductos.get(0);
            }
            
        } catch (Exception e) {
            
        }
        return producto;
    }
    
}
