
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.SolicitudAlquilerDAO;
import app.model.SolicitudAlquiler;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("solicitudAlquilerDAO")
public class SolicitudAlquilerDAOH extends BaseHibernateDAO implements SolicitudAlquilerDAO{
    
    
    public List<SolicitudAlquiler> list() {
        Criteria criteria = this.getSession().createCriteria(SolicitudAlquiler.class);
        return criteria.list();
    }

    public SolicitudAlquiler get(SolicitudAlquiler t) {
        Criteria criteria = this.getSession().createCriteria(SolicitudAlquiler.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (SolicitudAlquiler) criteria.uniqueResult();
    }

    @Transactional
    public void save(SolicitudAlquiler t) {
        this.getSession().save(t);
    }

    @Transactional
    public void update(SolicitudAlquiler t) {
        this.getSession().update(t);
    }

    @Transactional
    public void delete(SolicitudAlquiler t) {
        this.getSession().delete(t);
    }
    
    
    
}
