package ejb;

import model.BackLog;
import model.Colonne;
import model.Entree;
import utils.Utils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
public class BackLogEJB {
    @PersistenceContext
    private EntityManager em;

    public BackLogEJB() { /* Nothing to do here */ }

    public BackLog addBacklog(BackLog b) {
        return Utils.persistOrFail(em, b);
    }

    public BackLog addBacklog(List<Colonne> listeColonne) {
        return Utils.persistOrFail(em, new BackLog(listeColonne));
    }

    public void addColonne(BackLog backlog, String columnName) {
        backlog.addColonne(columnName);
        em.merge(backlog);
    }

    public void addColonne(BackLog backlog, String columnName, Colonne prev, Colonne next) {
        backlog.addColonne(columnName, prev, next);
        em.merge(backlog);
    }
}
