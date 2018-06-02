/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Farmacia;
import com.inso.model.Medico;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
            TypedQuery<Farmacia> query = getEntityManager().createNamedQuery("Farmacia.findByUsernameAndPass", Farmacia.class);
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
            TypedQuery<Farmacia> query = getEntityManager().createNamedQuery("Farmacia.findByCIF", Farmacia.class);
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
