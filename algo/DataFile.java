package doc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import obj.*;
import java.util.ArrayList;

public class DataFile extends File {

    public DataFile(String folder, String file) {
        super(folder);

        try {
            if (!this.exists())
                this.mkdir();
            this.setWritable(true);
            this.setReadable(true);

            File dataFile = new File(folder + "/" + file + ".txt");
            if (!dataFile.exists())
                dataFile.createNewFile();

            dataFile.setReadable(true);
            dataFile.setWritable(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] readFile(File file) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
        String line;
        Vector<String> textV = new Vector<String>(10, 10);
        int i = 0;
        while ((line = reader.readLine()) != null) {
            textV.add(line);
            i++;
        }
        String[] texts = new String[i];
        for (int j = 0; j < i; j++) {
            texts[j] = (String) textV.get(j);
        }
        return texts;
    }

    public void writeFile(File file, Graphe g) throws FileNotFoundException, IOException {
        String[] textHead = readFile(file);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
        
        for (int i = 0; i < textHead.length; i++) {
            writer.write(textHead[i]);
            writer.newLine();
        }
        ArrayList<Arete> a = g.getAretes();
        char v = ',';
        for (int i = 0; i < a.size(); i++) {
            writer.write(a.get(i).toString());
            if (i == a.size() - 1)
                v = ' ';
            writer.append(v);
        }
        writer.close();

    }
}
