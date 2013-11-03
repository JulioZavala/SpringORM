
package app.dao;

import app.model.Campo;
import app.model.Local;
import app.zelper.GenericDAO;
import java.util.List;


public interface CampoDAO extends GenericDAO<Campo>{

    public List<Campo> allByLocal(Local local);
    public Campo getByName(String descripcion);
}
