/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.Academico;
import entidade.Registro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author renan
 */
@Stateless
public class RegistroFacade extends AbstractFacade<Registro> {

    @PersistenceContext(unitName = "seinparPU")
    private EntityManager em;

    public RegistroFacade() {
        super(Registro.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Registro getRegistro(Academico a) {
        try {
            return (Registro) em.createQuery("FROM Registro as r where r.ra='" + a.getRa() + "' and r.dtSaida is null").getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
