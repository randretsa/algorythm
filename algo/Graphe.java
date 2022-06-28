package obj;
import java.util.ArrayList;
public class Graphe {
    ArrayList<Sommet> sommets=new ArrayList<Sommet>();
    ArrayList<Arete> aretes=new ArrayList<Arete>();


    public ArrayList<Sommet> getSommets() {
        return this.sommets;
    }

    public void setSommets(ArrayList<Sommet> sommets) {
        this.sommets = sommets;
    }

    public ArrayList<Arete> getAretes() {
        return this.aretes;
    }

    public void setAretes(ArrayList<Arete> aretes) {
        this.aretes = aretes;
    }


    // generate random number
    public static int rand(int min,int max){
        int n=max-min+1;
        return (int)(Math.random()*n)+min;
    }

    // calcul combinaison (m,n)

        // calcul factorielle
    public static double factorielle(int n){
        // System.out.println(n);
        if(n==0)
            return 1;
        return n*factorielle(n-1);
    }
        // combinaison
    public static int combinaison(int m,int n){
        return (int)(factorielle(m)/(factorielle(n)*factorielle(m-n)));
    }

    // tirer le nombre de sommets
    private int getnb_sommets(){
        return rand(50,150);
    }

    // tirer le nombre d'arrêtes
        // private int getnb_aretes(int nb_sommets){
        //     int max=combinaison(nb_sommets,2);
        //     // System.out.println(max);
        //     return rand(0,max);
        // }

    private int getnb_aretes(int nb_sommets){
        int max=nb_sommets*(nb_sommets-1)/2;
        // System.out.println(max);
        return rand(0,max);
    }


    // génération des sommets du graphe
    private void generer_sommets(){
        int S=getnb_sommets();
        for (int i = 0; i < S; i++) {
            sommets.add(new Sommet(i,this));
        }
    }

    // nombre de sommets dans le graphe
    public int nombre_sommets(){
        return sommets.size();
    }

    // générer 2 nombres aléatoires avec exception
    private int rand_except(int min,int max,int exception){
        int r=rand(min,max);
        if(r==exception)
            return rand_except(min,max,exception);
        return r;
    }

    public int[] rand_except(int nb_sommet,ArrayList<Integer[]> exception){
        int r1=rand(0,nb_sommet-1);
        int r2=rand_except(0,nb_sommet-1,r1);

        for (Integer[] i : exception) {
            if((r1==i[0] && r2==i[1]) || (r1==i[1] && r2==i[0]))
                return rand_except(nb_sommet,exception);
        }

        exception.add(new Integer[]{r1,r2});
        return new int[]{r1,r2};
    }


    // génération des arrêtes
    private void add_aretes(int i1,int i2){

        Arete a=new Arete(sommets.get(i1),sommets.get(i2));
        aretes.add(a);
        sommets.get(i1).addArete(a);
        sommets.get(i2).addArete(a);
    }
    private void generer_aretes(){
        int S=nombre_sommets();
        int a=getnb_aretes(S);

        for (int i = 0; i < a; i++) {
            ArrayList<Integer[]> aretes_in=new ArrayList<Integer[]>();
            int[] indice_s=rand_except(S,aretes_in);
            add_aretes(indice_s[0],indice_s[1]);
        }
        

    }

    
    // Densité
    public double getDensite(){
        int total=sommets.size()*(sommets.size()-1)/2;
        // System.out.println("total: "+total);
        // System.out.println("a: "+aretes.size());
        return (double)aretes.size()/total;
    }

    // générer graphe aléatoire
    public Graphe(){
        generer_sommets();
        generer_aretes();
        
    }
}
