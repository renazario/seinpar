/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidade.Academico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author renan
 */
@Stateless
public class academicoFacade extends AbstractFacade<Academico>{
    
    @PersistenceContext(unitName = "seinparPU")
    private EntityManager em;

    public academicoFacade() {
        super(Academico.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }

    public Academico retornaAcademico(String ra) throws Exception {
        Academico academico = null;
        try {
            academico = (Academico) getEntityManager().createQuery(""
                    + "FROM Academico AS a "
                    + "WHERE a.ra like'%" + ra + "' ").getSingleResult();
        } catch (Exception ex) {
          throw new Exception("RA não encontrado");
        }
        return academico;
    }
}
