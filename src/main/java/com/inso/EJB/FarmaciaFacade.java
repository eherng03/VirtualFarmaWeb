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
 * @author Eva y Alba
 */
@Stateless
public class FarmaciaFacade extends OwnEntityManager<Farmacia> implements FarmaciaFacadeLocal {

    @Override
    public Farmacia findByUsernameAndPass(String user, String pass) {
        String consulta;
        Farmacia farmacia = null;
        try {
            consulta = "SELECT f FROM Farmacia f WHERE f.cif = :user AND f.password = :pass";
            Query query = getEntityManager().createQuery(consulta);
            query.setParameter("user", user);
            query.setParameter("pass", pass);
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
            consulta = "SELECT f FROM Farmacia f WHERE f.cif = :cif";
            Query query = getEntityManager().createQuery(consulta);
            query.setParameter("cif", cif);
            List<Farmacia> listaFarmacias = query.getResultList();
            
            if(!listaFarmacias.isEmpty()){
                farmacia = listaFarmacias.get(0);
            }
            
        } catch (Exception e) {
            
        }
        return farmacia;
    }
    
}
