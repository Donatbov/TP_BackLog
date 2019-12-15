package ejb;

import model.Colonne;
import model.Entree;
import utils.Utils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote
public class ColonneEJB {
    @PersistenceContext
    private EntityManager em;

    public ColonneEJB() { /* Nothing to do here */ }

    public Colonne addColonne(Colonne c) {
        return Utils.persistOrFail(em, c);
    }

    public void updateColonne(Colonne c) {
        em.merge(c);
    }

    public void addEntree(Colonne c, Entree e) {
        // Could have been written a bit differently in a "EntreeEJB" but we use
        //  the "CascadeType.PERSIST" property from listeEntree
        c.addEntree(e);
        em.merge(c);
    }
}
