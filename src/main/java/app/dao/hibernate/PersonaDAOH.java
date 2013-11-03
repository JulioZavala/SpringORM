
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.PersonaDAO;
import app.model.Persona;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("personaDAO")
public class PersonaDAOH extends BaseHibernateDAO implements PersonaDAO{
 
    public List<Persona> list() {
        Criteria criteria = this.getSession().createCriteria(Persona.class);
        return criteria.list();
    }

    public Persona get(Persona t) {
        Criteria criteria = this.getSession().createCriteria(Persona.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Persona) criteria.uniqueResult();
    }

    @Transactional
    public void save(Persona t) {
        this.getSession().save(t);
    }

    @Transactional
    public void update(Persona t) {
        this.getSession().update(t);
    }

    @Transactional
    public void delete(Persona t) {
        this.getSession().delete(t);
    }
    
    
}
