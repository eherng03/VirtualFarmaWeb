/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Medico;
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
public class MedicoFacade extends OwnEntityManager<Medico> implements MedicoFacadeLocal {


    @Override
    public void removeByDNI(String dni) {
        String consulta;
        try {
            consulta = "DELETE m FROM Medico m WHERE m.dni = :dni";
            Query query = getEntityManager().createQuery(consulta);
            query.setParameter("dni", dni);
            
        } catch (Exception e) {
            
        }
    }

    @Override
    public Medico findByUsernameAndPass(String user, String pass) {
        String consulta;
        Medico medico = null;
        try {
            consulta = "SELECT m FROM Medicos m WHERE m.dni = ?1 AND m.password = ?2";
            Query query = getEntityManager().createQuery(consulta);
            query.setParameter(1, user);
            query.setParameter(2, pass);
            List<Medico> listaMedicos = query.getResultList();
            
            if(!listaMedicos.isEmpty()){
                medico = listaMedicos.get(0);
            }
            
        } catch (Exception e) {
            
        }
        return medico;
    }

    @Override
    public Medico findByDNI(String dni) {
        String consulta;
        Medico medico = null;
        try {
            consulta = "SELECT m FROM Medico m WHERE m.dni = ?1";
            Query query = getEntityManager().createQuery(consulta);
            query.setParameter(1, dni);
            List<Medico> listaMedicos = query.getResultList();
            
            if(!listaMedicos.isEmpty()){
                medico = listaMedicos.get(0);
            }
            
        } catch (Exception e) {
            
        }
        return medico;
    }
    
}
