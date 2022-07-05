package file;
import java.io.*;
import obj.*;

public class Csv_generator {
    
    public void generate_csv(){
        FileWriter myWriter = null;
        Graphe graphe1 = null; 
        Graphe graphe2 = null; 
        try {
            
            myWriter = new FileWriter("data.csv");

            for(int i=0;i<500;i++)
            {

            
            //generation de la graphe aleatoire

            // graphe = new Graphe();
            graphe1 = Graphe.generate_hamiltonien();
            graphe2 = Graphe.generate_nonHamiltonien();
            // for(Sommet s : graphe.getSommets()){
            //   myWriter.write(String.valueOf(s.getLabel()));
            //   myWriter.write("\n");
  
            //   }
            // myWriter.write("arrete: \n");
            // for(Arete a : graphe.getAretes()){
            // myWriter.write(String.valueOf(a.getSommet1().getLabel())+ ","+String.valueOf(a.getSommet2().getLabel()));
            // myWriter.write("\n");

            // }

            
            myWriter.write(String.valueOf(graphe1.nombre_sommets())+ ",");
            myWriter.write(String.valueOf(graphe1.getAretes().size())+ ",");
            myWriter.write(String.valueOf(graphe1.degre_min())+ ",");
            myWriter.write(String.valueOf(graphe1.degre_max())+ ",");
            myWriter.write(String.valueOf(graphe1.complete())+ ",");
            myWriter.write(String.valueOf(graphe1.connexe()+ ","));
            myWriter.write(String.valueOf(graphe1.getDensite()+ ","));
            myWriter.write(String.valueOf(graphe1.est_eulerien()+","));
            myWriter.write(String.valueOf(graphe1.parite_ordre()+","));
            myWriter.write(String.valueOf(graphe1.parite_size()+","));
            myWriter.write(String.valueOf(graphe1.ore_theorem()+","));
            myWriter.write(String.valueOf(graphe1.dirac_theorem()+","));
            myWriter.write(String.valueOf(graphe1.posa_theorem()+","));
            myWriter.write(String.valueOf(graphe1.est_hamiltonien()));
                        
            
            myWriter.write("\n");
            

            myWriter.write(String.valueOf(graphe2.nombre_sommets())+ ",");
            myWriter.write(String.valueOf(graphe2.getAretes().size())+ ",");
            myWriter.write(String.valueOf(graphe2.degre_min())+ ",");
            myWriter.write(String.valueOf(graphe2.degre_max())+ ",");
            myWriter.write(String.valueOf(graphe2.complete())+ ",");
            myWriter.write(String.valueOf(graphe2.connexe()+ ","));
            myWriter.write(String.valueOf(graphe2.getDensite()+ ","));
            myWriter.write(String.valueOf(graphe2.est_eulerien()+","));
            myWriter.write(String.valueOf(graphe2.parite_ordre()+","));
            myWriter.write(String.valueOf(graphe2.parite_size()+","));
            myWriter.write(String.valueOf(graphe2.ore_theorem()+","));
            myWriter.write(String.valueOf(graphe2.dirac_theorem()+","));
            myWriter.write(String.valueOf(graphe2.posa_theorem()+","));
            myWriter.write(String.valueOf(graphe2.est_hamiltonien()));

            // System.out.println("dirac: "+graphe.dirac_theorem()+" S: "+graphe.nombre_sommets());
            // System.out.println("ore: "+graphe.ore_theorem());
            // System.out.println("posa: "+graphe.posa_theorem());
            // System.out.println("hamilton: "+graphe.est_hamiltonien());
            
            //colone finale, placer tous les propriétés au dessous de cette ligne
            myWriter.write("\n");
            
            }

            myWriter.close();

            System.out.println("Successfully wrote to the file.");
      
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          
    }

}
