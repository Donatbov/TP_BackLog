package beans;

import ejb.BackLogEJB;
import ejb.ColonneEJB;
import model.Agence;
import model.Colonne;
import model.Entree;

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
    private String entreeName;
    private int entreePrio;
    private int entreeEstim;
    private String entreeDescr;


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

    public String getEntreeName() {
        return entreeName;
    }

    public void setEntreeName(String entreeName) {
        this.entreeName = entreeName;
    }

    public int getEntreePrio() {
        return entreePrio;
    }

    public void setEntreePrio(int entreePrio) {
        this.entreePrio = entreePrio;
    }

    public int getEntreeEstim() {
        return entreeEstim;
    }

    public void setEntreeEstim(int entreeEstim) {
        this.entreeEstim = entreeEstim;
    }

    public String getEntreeDescr() {
        return entreeDescr;
    }

    public void setEntreeDescr(String entreeDescr) {
        this.entreeDescr = entreeDescr;
    }

    public void addColonne() {
        Colonne col = new Colonne();
        col.setNom(this.colonneName);
        int colonnnesSize = this.colonnes.size();
        if(colonnnesSize > 0) {
            this.colonneEJB.addColonne(col);
            Colonne prevCol = this.colonnes.get(colonnnesSize - 1);
            prevCol.setNextColumn(col);
            col.setPreviousColumn(prevCol);
            this.colonneEJB.updateColonne(col);
            this.colonneEJB.updateColonne(prevCol);
        }
        else {
            this.backLogEJB.setFirstColonne(this.agence.getBacklog(), col);
        }
    }

    public void moveColonneRight(Colonne c) {
        Colonne first = c.moveNext(true);
        this.colonneEJB.updateColonne(c);
        if (first != null) {
            this.backLogEJB.setFirstColonne(this.agence.getBacklog(), first);
        }
    }

    public void moveColonneLeft(Colonne c) {
        Colonne first = c.moveBack(true);
        this.colonneEJB.updateColonne(c);
        if (first != null) {
            this.backLogEJB.setFirstColonne(this.agence.getBacklog(), first);
        }
    }

    public void addEntree(Colonne c) {
        Entree e = new Entree();
        e.setName(this.entreeName);
        e.setColumn(c);
        e.setDescription(this.entreeDescr);
        e.setEstimation(this.entreeEstim);
        e.setPriority(this.entreePrio);
        colonneEJB.addEntree(c, e);
    }

}
