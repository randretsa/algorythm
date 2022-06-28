package obj;
import java.util.ArrayList;

public class Sommet {

    Boolean marque = false;
    public Graphe graphe;
    int label;
    ArrayList<Arete> aretes=new ArrayList<Arete>();

    public void marquer(){
        this.marque=true;
    }

    public void setMarque(Boolean b){
        this.marque = b;
    }
    public Boolean getMarque(){
        return this.marque;
    } 

    public Graphe getGraphe() {
        return this.graphe;
    }

    public void setGraphe(Graphe graphe) {
        this.graphe = graphe;
    }

    public int getLabel() {
        return this.label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public ArrayList<Arete> getAretes() {
        return this.aretes;
    }

    public void setAretes(ArrayList<Arete> aretes) {
        this.aretes = aretes;
    }


    public Sommet(int label,Graphe graphe){
        setLabel(label);
        setGraphe(graphe);
    }

    // ajouter une arrête au sommet
    public void addArete(Arete a){
        aretes.add(a);
    }

    
}
