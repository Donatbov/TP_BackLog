package ejb;

import model.BackLog;
import model.Colonne;
import model.Entree;
import utils.Utils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote
public class BackLogEJB {
    @PersistenceContext
    private EntityManager em;

    public BackLogEJB() { /* Nothing to do here */ }

    public BackLog addBacklog(BackLog b) {
        return Utils.persistOrFail(em, b);
    }

    public BackLog addBacklog(Colonne firstColonne) {
        return Utils.persistOrFail(em, new BackLog(firstColonne));
    }

    public void setFirstColonne(BackLog b, Colonne c) {
        b.setFirstColonne(c);
        em.merge(b);
    }
}
