package obj;

public class Arete {
    Sommet sommet1;
    Sommet sommet2;
    Boolean marque=false;


    public void marquer(){
        this.marque=true;
    }

    public void setMarque(Boolean b){
        this.marque = b;
    }
    public Boolean getMarque(){
        return this.marque;
    } 

    public Sommet getSommet1() {
        return this.sommet1;
    }

    public void setSommet1(Sommet sommet1) {
        this.sommet1 = sommet1;
    }

    public Sommet getSommet2() {
        return this.sommet2;
    }

    public void setSommet2(Sommet sommet2) {
        this.sommet2 = sommet2;
    }

    public Arete(Sommet S1,Sommet S2){
        setSommet1(S1);
        setSommet2(S2);
    }

    public void show(){
        System.out.println(" s1: "+sommet1.getLabel()+ " , s2: "+sommet2.getLabel());
    }

    @Override
    public String toString() {
        return "{" +
            " s1='" + getSommet1().getLabel() + "'" +
            ", s2='" + getSommet2().getLabel() + "'" +
            "}";
    }


    
}
