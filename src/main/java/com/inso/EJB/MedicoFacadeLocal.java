/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Medico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eva
 */
@Local
public interface MedicoFacadeLocal {

    void create(Medico medico);

    void edit(Medico medico);

    void remove(Medico medico);
    
    void removeByDNI(String dni);

    Medico find(Object id);
    
    Medico findByUsernameAndPass(String user, String pass);

    Medico findByDNI(String dni);
    
    List<Medico> findAll();

    List<Medico> findRange(int[] range);

    int count();
    
}
