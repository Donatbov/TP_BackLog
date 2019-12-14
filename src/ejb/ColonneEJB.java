package ejb;

import model.Colonne;
import model.Entree;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote
public class ColonneEJB {
    @PersistenceContext
    private EntityManager em;

    ColonneEJB() { /* Nothing to do here */ }

    // We don't need to have a addColonne() method because we use Backlog's listColonne "CascadeType.PERSIST" property
    //  to persist any Colonne we create

    public void addEntree(Colonne c, Entree e) {
        // Could have been written a bit differently in a "EntreeEJB" but we use
        //  (one more time) the "CascadeType.PERSIST" property from listeEntree
        c.addEntree(e);
        em.merge(c);
    }
}
