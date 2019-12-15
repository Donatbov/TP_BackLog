package beans;

import ejb.AgenceEJB;
import ejb.BackLogEJB;
import ejb.ColonneEJB;
import model.Agence;
import model.BackLog;
import model.Colonne;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class BacklogAgenceMgntBean implements Serializable {
    @EJB
    protected BackLogEJB backLogEJB;
    @EJB
    protected ColonneEJB colonneEJB;

    private Agence agence;
    private List<Colonne> colonnes;
    private String colonneName;

    public BacklogAgenceMgntBean() {}

    /**
     * Get the Agence instance from the session
     */
    @PostConstruct
    protected void init() {
        this.agence = (Agence) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agence");
        this.colonnes = this.buildColonnesList();
    }

    /**
     * @return the list of colonnes built from the first Colonne
     */
    public ArrayList<Colonne> buildColonnesList() {
        Colonne col = agence.getBacklog().getFirstColonne();
        ArrayList<Colonne> colonnesList = new ArrayList<>();
        while (col != null) {
            colonnesList.add(col);
            col = col.getNextColumn();
        }
        return colonnesList;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public List<Colonne> getColonnes() {
        return colonnes;
    }

    public String getColonneName() {
        return colonneName;
    }

    public void setColonneName(String colonneName) {
        this.colonneName = colonneName;
    }

    public void addColonne() {
        Colonne col = new Colonne();
        int colonnnesSize = this.colonnes.size();
        if(colonnnesSize > 0) {
            // TODO : resolve this case
            //java.lang.IllegalStateException: During synchronization a new object was found through a relationship
            // that was not marked cascade PERSIST: model.Colonne@36511c64.
            Colonne prevCol = this.colonnes.get(colonnnesSize - 1);
            prevCol.setNextColumn(col);
            col.setPreviousColumn(prevCol);
            this.colonneEJB.addColonne(col);
            this.colonneEJB.updateColonne(prevCol);
        }
        else {
            this.backLogEJB.setFirstColonne(this.agence.getBacklog(), col);
        }
    }
}
