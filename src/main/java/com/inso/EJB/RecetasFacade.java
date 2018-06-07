/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Recetas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Eva y Alba
 */
@Stateless
public class RecetasFacade extends OwnEntityManager<Recetas> implements RecetasFacadeLocal {

    @Override
    public void removeIDs(String dniPaciente, String nombreMedicamento, String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Recetas> findByDNI(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void create(Recetas f) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().persist(f);
        tx.commit();
    }
    
    @Override
    public void remove(Recetas rec) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().remove(getEntityManager().merge(rec));
        tx.commit();
    }

    @Override
    public void edit(Recetas rec) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().merge(rec);
        tx.commit();
    }
    
}
