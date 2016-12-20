/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.Materia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author renan
 */
@Stateless
public class MateriaFacade extends AbstractFacade<Materia> {

    @PersistenceContext(unitName = "seinparPU")
    private EntityManager em;

    public MateriaFacade() {
        super(Materia.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Materia> materiasPorSerie(String ano) {
        return em.createQuery("FROM Materia AS m WHERE m.ano='" + ano + "'").getResultList();
    }

}
