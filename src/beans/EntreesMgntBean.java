package beans;

import ejb.AgenceEJB;
import model.Agence;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class EntreesMgntBean implements Serializable {
    @EJB
    protected AgenceEJB agenceEJB;
    private Agence agences;

    public EntreesMgntBean() {
        agences = new Agence();
    }

    public Agence addAgence() {
        return agenceEJB.addAgence(agences);
    }

    public void deleteAgence(long id) {
        agenceEJB.deleteAgence(id);
    }

    public Agence getAgences() {
        return agences;
    }

    public void setAgences(Agence agences) {
        this.agences = agences;
    }

//    public ArrayList<Agence> getAgences() {
//
//    }
}
