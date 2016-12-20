package facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author renan
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void salvar(T entity) {
        getEntityManager().merge(entity);
        getEntityManager().flush();
        
    }

    public void excluir(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().flush();
    }

    public T pesquisar(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    
 public List<T> listar() {
        Query query = getEntityManager().createQuery(
                "FROM " + entityClass.getSimpleName());
        return query.getResultList();
    }
    
}
