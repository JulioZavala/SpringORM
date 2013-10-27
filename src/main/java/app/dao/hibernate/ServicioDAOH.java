package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.ServicioDAO;
import app.model.Servicio;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("servicioDAO")
public class ServicioDAOH extends BaseHibernateDAO implements ServicioDAO {

    public List<Servicio> list() {
        Criteria criteria = this.getSession().createCriteria(Servicio.class);
        return criteria.list();
    }

    public Servicio get(Servicio t) {
        Criteria criteria = this.getSession().createCriteria(Servicio.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Servicio) criteria.uniqueResult();
    }

    public void save(Servicio t) {
        this.getSession().save(t);
    }

    public void update(Servicio t) {
        this.getSession().update(t);
    }

    public void delete(Servicio t) {
        this.getSession().delete(t);
    }
}
