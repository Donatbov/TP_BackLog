package beans;

import ejb.AgencesListEJB;
import model.Agence;
import model.AgencesList;
import model.BackLog;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

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

    /**
     * Method to save the Agence object in the session
     * @param a the Agence to be saved
     */
    public void putAgenceInSessionScope(Agence a) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agence", a);
    }

}
