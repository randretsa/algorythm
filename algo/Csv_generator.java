package file;
import java.io.*;
import obj.*;

public class Csv_generator {
    
    public void generate_csv(){
        FileWriter myWriter = null;
        Graphe graphe = null; 
        try {
            
            myWriter = new FileWriter("data.csv");

            for(int i=0;i<50;i++)
            {

            
            //generation de la graphe aleatoire

            graphe = new Graphe();
            // for(Sommet s : graphe.getSommets()){
            //   myWriter.write(String.valueOf(s.getLabel()));
            //   myWriter.write("\n");
  
            //   }
            // myWriter.write("arrete: \n");
            // for(Arete a : graphe.getAretes()){
            // myWriter.write(String.valueOf(a.getSommet1().getLabel())+ ","+String.valueOf(a.getSommet2().getLabel()));
            // myWriter.write("\n");

            // }
            myWriter.write(String.valueOf(graphe.complete(graphe))+ ",");
            myWriter.write(String.valueOf(graphe.connexe()+ ","));
            myWriter.write(String.valueOf(graphe.degre_max(graphe))+ ",");
            myWriter.write(String.valueOf(graphe.degre_min(graphe))+ ",");
            myWriter.write(String.valueOf(graphe.est_eulerien()));
            
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
