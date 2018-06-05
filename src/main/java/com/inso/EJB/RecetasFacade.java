/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Recetas;
import java.util.List;
import javax.ejb.Stateless;

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

    /*
    @Override
    public void removeIDs(String dniPaciente, String nombreMedicamento, String fecha) {
        try {
            TypedQuery<Recetas> query = getEntityManager().createNamedQuery("Recetas.removeIDs", Recetas.class);
            query.setParameter("dniPaciente", dniPaciente);
            query.setParameter("nombreMedicamento", nombreMedicamento);
            query.setParameter("fecha", fecha);
            query.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Recetas> findByDNI(String dni) {
        try {
            TypedQuery<Recetas> query = getEntityManager().createNamedQuery("Recetas.findByDNI", Recetas.class);
            query.setParameter("dni", dni);
            return query.getResultList();      
        } catch (Exception e) {
            throw e;
        }
    }
*/
    
}
