/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Academico;
import facade.AbstractFacade;
import facade.academicoFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author renan
 */
@SessionScoped
@ManagedBean
public class academicoControle extends AbstractControle<Academico> implements Serializable {

    @EJB
    private academicoFacade academicoEJB;

    public academicoControle() {
        super(Academico.class);
    }

    @Override
    protected AbstractFacade<Academico> getFacade() {
        return academicoEJB;
    }
}
