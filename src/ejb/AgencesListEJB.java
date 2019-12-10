package ejb;

import model.Agence;
import model.AgencesList;
import utils.Utils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote
public class AgencesListEJB {
    @PersistenceContext
    private EntityManager em;

    public AgencesListEJB() { /* Nothing to do here */ }

    public AgencesList getListAgence() {
        try {
            System.out.println("test2");
            AgencesList al = em.find(AgencesList.class, 0);
            if (al == null) {
                System.out.println("qzeifjreoigpjoqz^jo");
                return Utils.persistOrFail(em, new AgencesList());
            } else {
                return al;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return Utils.persistOrFail(em, new AgencesList());
        }
    }

    public Agence addAgence(Agence a) {
        AgencesList al = em.find(AgencesList.class, 0);
        al.addAgence(a);
        em.merge(al);
        return a;
    }

    public void deleteAgence(long id) {
        Agence a = em.find(Agence.class, id);
        em.remove(a);
        //todo : test if it cascades the deletion in AgenceList
        // if it's ok, remove this and use deleteAgence from AgenceEJB
    }
}
