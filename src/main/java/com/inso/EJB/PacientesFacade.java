/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Pacientes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        String consulta;
        try {
            consulta = "DELETE p FROM Pacientes p WHERE p.dni = :dni";
            Query query = getEntityManager().createQuery(consulta);
            query.setParameter("dni", dni);

        } catch (Exception e) {

        }
    }

    @Override
    public Pacientes findByDNI(String dni) {
        String consulta;
        Pacientes paciente = null;
        try {
            consulta = "SELECT p FROM Pacientes p WHERE p.dni = :dni";
            Query query = getEntityManager().createQuery(consulta);
            query.setParameter("dni", dni);
            List<Pacientes> listaPacientes = query.getResultList();

            if (!listaPacientes.isEmpty()) {
                paciente = listaPacientes.get(0);
            }

        } catch (Exception e) {

        }
        return paciente;
    }

}
