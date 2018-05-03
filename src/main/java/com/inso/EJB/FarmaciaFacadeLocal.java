/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inso.EJB;

import com.inso.model.Farmacia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Eva
 */
@Local
public interface FarmaciaFacadeLocal {

    void create(Farmacia farmacia);

    void edit(Farmacia farmacia);

    void remove(Farmacia farmacia);

    Farmacia find(Object id);
    
    Farmacia findByUsernameAndPass(String user, String pass);
    
    Farmacia findByCIF(String cif);

    List<Farmacia> findAll();

    List<Farmacia> findRange(int[] range);

    int count();
    
}
