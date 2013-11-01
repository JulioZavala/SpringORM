
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.GeneralDAO;
import app.model.General;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("generalDAO")
public class GeneralDAOH extends BaseHibernateDAO implements GeneralDAO {
    
    
    public List<General> list() {
        Criteria criteria = this.getSession().createCriteria(General.class);
        return criteria.list();
    }

    public General get(General t) {
        Criteria criteria = this.getSession().createCriteria(General.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (General) criteria.uniqueResult();
    }

    public void save(General t) {
        this.getSession().save(t);
    }

    public void update(General t) {
        this.getSession().update(t);
    }

    public void delete(General t) {
        this.getSession().delete(t);
    }
}
