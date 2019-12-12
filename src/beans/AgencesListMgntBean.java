package beans;

import ejb.AgenceEJB;
import ejb.AgencesListEJB;
import model.Agence;
import model.AgencesList;
import model.BackLog;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AgencesListMgntBean implements Serializable {
    @EJB
    protected AgencesListEJB agenceListEJB;
    private AgencesList agences;
    private String name;

    public AgencesListMgntBean() {
        this.name = "";
    }

    @PostConstruct
    public void initAgences() {
        this.agences = agenceListEJB.getListAgence();
    }

    public Agence addAgence() {
        BackLog b = new BackLog();
        Agence a = new Agence(this.name, b);
        return agenceListEJB.addAgence(a);
    }

    public void deleteAgence(long id) {
        agenceListEJB.deleteAgence(id);
    }

    public AgencesList getAgences() {
        return agences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    public ArrayList<Agence> getAgences() {
//
//    }
}
