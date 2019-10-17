package ejb;

import model.BackLog;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class BackLogEjb {
    @PersistenceContext
    private EntityManager em;

    public BackLogEjb() { /* Nothing to do here */ }

    public boolean addBacklog(BackLog b) {
        try {
            em.persist(b);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean addBacklog() {
        BackLog b = new BackLog();
        try {
            em.persist(b);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
