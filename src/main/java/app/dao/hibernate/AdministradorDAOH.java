
package app.dao.hibernate;

import app.dao.AdministradorDAO;
import app.dao.BaseHibernateDAO;
import app.model.Administrador;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("administradorDAO")
public class AdministradorDAOH extends BaseHibernateDAO implements AdministradorDAO{
 
    public List<Administrador> list() {
        Criteria criteria = this.getSession().createCriteria(Administrador.class);
        return criteria.list();
    }

    public Administrador get(Administrador t) {
        Criteria criteria = this.getSession().createCriteria(Administrador.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Administrador) criteria.uniqueResult();
    }

    @Transactional
    public void save(Administrador t) {
        this.getSession().save(t);
    }

    @Transactional
    public void update(Administrador t) {
        this.getSession().update(t);
    }

    @Transactional
    public void delete(Administrador t) {
        this.getSession().delete(t);
    }
    
    
}
