package beans;

import ejb.AgenceEJB;
import ejb.BackLogEJB;
import model.Agence;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class BacklogAgenceMgntBean implements Serializable {
    @EJB
    protected AgenceEJB agenceEJB;
    @EJB
    protected BackLogEJB backLogEJB;

    private Agence agence;
    private String columnName;

    public BacklogAgenceMgntBean() {}

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
