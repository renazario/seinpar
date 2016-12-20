/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;


import entidade.Materia;
import facade.AbstractFacade;
import facade.MateriaFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author renan
 */
@ManagedBean
@SessionScoped
public class MateriaControle extends AbstractControle<Materia> implements Serializable{

    @EJB
    private MateriaFacade materiaFacade;
    
    public MateriaControle(){
        super(Materia.class);
    } 
    @Override
    protected AbstractFacade<Materia> getFacade() {
       return materiaFacade;
    }
    
}
