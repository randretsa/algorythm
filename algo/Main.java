package main;
import obj.*;
import java.util.Random;
import doc.*;
public class Main {
    public static void main(String[] args) throws Exception {
        
        Graphe g=new Graphe(true);
        Sommet s1 = new Sommet(1,g);
        Sommet s2 = new Sommet(2,g);
        Sommet s3 = new Sommet(3,g);
        Sommet s4 = new Sommet(4,g);
        Sommet s5 = new Sommet(5,g);
        Sommet s6 = new Sommet(6,g);
        Sommet s7 = new Sommet(7,g);

        Arete a1 = new Arete(s1,s2);
        Arete a2 = new Arete(s2,s4);
        Arete a3 = new Arete(s2,s6);
        Arete a4 = new Arete(s1,s3);
        Arete a5 = new Arete(s3,s7);
        Arete a6 = new Arete(s1,s5);
        Arete a7 = new Arete(s5,s6);

        s1.addArete(a1);
        s1.addArete(a4);
        s1.addArete(a6);

        s2.addArete(a1);
        s2.addArete(a2);
        s2.addArete(a3);

        s3.addArete(a4);
        s3.addArete(a5);

        s4.addArete(a2);        
        
        s5.addArete(a6);
        s5.addArete(a7);
        
        s6.addArete(a3);
        s6.addArete(a7);
        
        s7.addArete(a5);        

        g.addSommet(s1);
        g.addSommet(s2);
        g.addSommet(s3);
        g.addSommet(s4);
        g.addSommet(s5);
        g.addSommet(s6);
        g.addSommet(s7);
        
        g.addArete(a1);
        g.addArete(a2);
        g.addArete(a3);
        g.addArete(a4);
        g.addArete(a5);
        g.addArete(a6);
        g.addArete(a7);

        // g.explorer(g, s1);
        g.parcours_profondeur(g, s1);

        Graphe gr = new Graphe();

        System.out.println("complete");
        System.out.println(g.complete(g));
        System.out.println("connexe");
        System.out.println(g.connexe());
        System.out.println("eulerien");
        System.out.println(g.est_eulerien());
    }
}