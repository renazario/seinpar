/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import facade.AbstractFacade;
import java.util.List;

/**
 *
 * @author renan
 */
public abstract class AbstractControle<T> {

    private Class<T> classe;
    private T entidade;
    private List<T> listaEntidades;

    public AbstractControle(Class<T> classe) {
        this.classe = classe;
    }

    public String novo() {
        try {
            entidade = classe.newInstance();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex){
            ex.printStackTrace();
        }
        return "form?faces-redirect=true";
    }
    protected abstract AbstractFacade<T> getFacade();
    
    public String salvar(){
        try {
            getFacade().salvar(entidade);
            entidade = null;
            listaEntidades = null;
            entidade = classe.newInstance();
            
            return "form?faces-redirect=true";
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<T> getListaEntidades(){
        if(listaEntidades == null){
            listaEntidades = getFacade().listar();
        }
        return listaEntidades;
    }
    public T getEntidade(){
        return entidade;
    }
    
    public void setEntidade(T entidade) {
        this.entidade = entidade;
    }

}
