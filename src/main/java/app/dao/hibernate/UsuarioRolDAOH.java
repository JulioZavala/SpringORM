
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.UsuarioRolDAO;
import app.model.UsuarioRol;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("usuarioRolDAO")
public class UsuarioRolDAOH extends BaseHibernateDAO implements UsuarioRolDAO{
 
    public List<UsuarioRol> list() {
        Criteria criteria = this.getSession().createCriteria(UsuarioRol.class);
        return criteria.list();
    }

    public UsuarioRol get(UsuarioRol t) {
        Criteria criteria = this.getSession().createCriteria(UsuarioRol.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (UsuarioRol) criteria.uniqueResult();
    }

    @Transactional
    public void save(UsuarioRol t) {
        this.getSession().save(t);
    }

    @Transactional
    public void update(UsuarioRol t) {
        this.getSession().update(t);
    }

    @Transactional
    public void delete(UsuarioRol t) {
        this.getSession().delete(t);
    }
    
    
}
