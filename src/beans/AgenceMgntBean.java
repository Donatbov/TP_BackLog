package beans;

import ejb.AgenceEJB;
import model.Agence;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named
@RequestScoped
public class AgenceMgntBean implements Serializable {
    @EJB
    protected AgenceEJB agenceEJB;
    private Agence agence;

    AgenceMgntBean() {
        agence = new Agence();
    }

    public Agence addAgence() {
        return agenceEJB.addAgence(agence);
    }

    public void deleteAgence(long id) {
        agenceEJB.deleteAgence(id);
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

//    public ArrayList<Agence> getAgences() {
//
//    }
}
