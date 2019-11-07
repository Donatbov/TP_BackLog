package ejb;

import model.BackLog;
import model.Entree;
import utils.Utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class BackLogEjb {
    @PersistenceContext
    private EntityManager em;

    public BackLogEjb() { /* Nothing to do here */ }

    public BackLog addBacklog(BackLog b) {
        return Utils.persistOrFail(em, b);
    }

    public BackLog addBacklog(List<Entree> listeEntree) {
        return Utils.persistOrFail(em, new BackLog(listeEntree));
    }

}
