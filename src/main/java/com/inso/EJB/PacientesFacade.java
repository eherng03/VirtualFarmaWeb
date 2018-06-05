/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Pacientes;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eva y Alba
 */
@Stateless
public class PacientesFacade extends OwnEntityManager<Pacientes> implements PacientesFacadeLocal {

    @Override
    public void edit(Pacientes entity) {
        super.edit(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Pacientes p) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        getEntityManager().persist(p);
        tx.commit();
    }
    
    @Override
    public Pacientes findByUsernameAndPass(String user, String pass) {
        try {
            TypedQuery<Pacientes> query = getEntityManager().createNamedQuery("Pacientes.findByUserAndPass", Pacientes.class);
            query.setParameter("user", user);
            query.setParameter("pass", pass);

            return query.getSingleResult();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void removeByDNI(String dni) {
        try {
            TypedQuery<Pacientes> query = getEntityManager().createNamedQuery("Pacientes.findByDNI", Pacientes.class);
            query.setParameter("dni", dni);
            Pacientes result = query.getSingleResult();
            remove(result);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Pacientes findByDNI(String dni) {
        try {
            TypedQuery<Pacientes> query = getEntityManager().createNamedQuery("Pacientes.findByDNI", Pacientes.class);
            query.setParameter("dni", dni);
            return query.getSingleResult();

        } catch (Exception e) {
            throw e;
        }
    }
}
