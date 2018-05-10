/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Farmacia;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Eva
 */
@Stateless
public class FarmaciaFacade extends AbstractFacade<Farmacia> implements FarmaciaFacadeLocal {

    @PersistenceContext(unitName = "ViartualFarma_Persistence_Unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FarmaciaFacade() {
        super(Farmacia.class);
    }

    @Override
    public Farmacia findByUsernameAndPass(String user, String pass) {
        String consulta;
        Farmacia farmacia = null;
        try {
            consulta = "SELECT f FROM Farmacia f WHERE f.cif = ?1 AND f.password = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, user);
            query.setParameter(2, pass);
            List<Farmacia> listaFarmacias = query.getResultList();
            
            if(!listaFarmacias.isEmpty()){
                farmacia = listaFarmacias.get(0);
            }
            
        } catch (Exception e) {
            
        }
        return farmacia;
    }

    @Override
    public Farmacia findByCIF(String cif) {
        String consulta;
        Farmacia farmacia = null;
        try {
            consulta = "SELECT f FROM Farmacia f WHERE f.cif = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, cif);
            List<Farmacia> listaFarmacias = query.getResultList();
            
            if(!listaFarmacias.isEmpty()){
                farmacia = listaFarmacias.get(0);
            }
            
        } catch (Exception e) {
            
        }
        return farmacia;
    }
    
}
