package beans;

import ejb.AgenceEJB;
import ejb.BackLogEJB;
import model.Agence;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class BacklogAgenceMgntBean implements Serializable {
    @EJB
    protected AgenceEJB agenceEJB;
    @EJB
    protected BackLogEJB backLogEJB;

    private Agence agence;
    private String columnName;

    public BacklogAgenceMgntBean() {}

    /**
     * Get the Agence instance from the session
     */
    @PostConstruct
    protected void initAgence() {
        this.agence = (Agence) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agence");
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void addColumn() {
        backLogEJB.addColonne(this.agence.getBacklog(), this.columnName);
    }
}
