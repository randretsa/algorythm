package obj;
import java.util.ArrayList;
import java.util.Random;
public class Graphe {
    ArrayList<Sommet> sommets=new ArrayList<Sommet>();
    ArrayList<Arete> aretes=new ArrayList<Arete>();

    //O si complete 1 sinon
    public int complete(Graphe g){
        int nb_sommets = g.getSommets().size();
        int nb_arrete = g.getAretes().size();

        int max=nb_sommets*(nb_sommets-1)/2;
        
        System.out.println("combinaiseon: "+max);
        System.out.println("arrete: "+nb_arrete);
        if(max==nb_arrete)
        {
            return 0;
        }else{
            return 1;
        }
    }

    // déterminer le nombre de dégré pair et impair de chaque sommets
    // [0]:pair et [1] impair
    public int[] degre_pairImpair(){
        int pair=0,impair=0;
        for(Sommet s : getSommets()){
            int deg = s.getAretes().size();
            
            if(deg%2==0)
                pair++;
            else 
                impair++;
        }
        return new int[]{pair,impair};
    }
    //degre min
    public int degre_min()
    {
        int min = Integer.MAX_VALUE;

        for(Sommet s : getSommets()){
            int deg = s.getAretes().size();
            
            if(deg<min) min = deg; 
        }

        return min;
    } 

    //degre max
    public int degre_max(Graphe g)
    {
        int max = Integer.MIN_VALUE;

        for(Sommet s : g.getSommets()){
            int deg = s.getAretes().size();
            
            if(deg>max) max = deg; 
        }

        return max;
    }

    public void explorer(Graphe g,Sommet s){
        s.marquer();
        //System.out.println(s.getLabel());

        ArrayList<Sommet> list = new ArrayList<Sommet>();
        for(Arete a : s.getAretes())
        {   
            if(a.getSommet1()!=s){
                list.add(a.sommet1);
            }
            if(a.getSommet2()!=s){
                list.add(a.sommet2);
            }
        }

        for (Sommet sommet : list) {
            if(sommet.getMarque()==false)
            {
                explorer(g, sommet);
            }
        }
    } 

    // https://www.kartable.fr/ressources/mathematiques/methode/determiner-si-un-graphe-admet-une-chaine-eulerienne-ou-un-cycle-eulerien-1/4801
    // retourne 0 si eulérien 1 sinon
    public int est_eulerien(){
        // vérifier si connexe
        int connexe=connexe();

        if(connexe==1)  //non connexe => non eulérien
            return 1; 

        // compter le nombre de sommets de dégré impair
        int impair=degre_pairImpair()[1];
        // System.out.println("impair: "+impair+" pair: "+degre_pairImpair()[0]);

        if(impair==0 || impair==2)
            return 0;   //false
        
        return 1; //true

    }

    public void parcours_profondeur(Graphe g,Sommet s){
        for (Sommet sommet : g.getSommets()) {
            if(sommet.getMarque()==false){
                // modification s->sommet
                explorer(g, sommet);
            }   
        }
    }

    //retourne 0 si connexe 1 sinon
    public int connexe(Graphe g,Sommet s) 
    {
        int connexe = 0;
        parcours_profondeur(g, s);
        for(Sommet sommet : g.getSommets()){
            if(sommet.getMarque()==false){
                connexe = 1;
            }
        }

        return connexe;
    }
    public int connexe() 
    {
        return connexe(this,getSommets().get(0));
    }

    public void addSommet(Sommet s)
    {   
        this.sommets.add(s);
    }
    public Graphe(Boolean b){
        this.sommets = new ArrayList<>();
        this.aretes = new ArrayList<>();
    }

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
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
        
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

    public void addArete(Arete a){
        getAretes().add(a);
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
