package dataReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import models.Cpax;
import models.Mrc;
import models.Patient;
import models.Sofa;

/**
 *
 * @author Daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Patient> patientData = new ArrayList<Patient>();
    static int count = 0;

    public static void main(String[] args) {
        // TODO code application logic here

        String path = "D:/Documents/University Archive/Bsc Computing Year 3/COMP3000 Computing Project/Project/data.csv";
        loadData(path);
        System.out.println("LoadData(): " + count);
        
        loadInformation();
        
    }

    public static void loadData(String filePath) {
        try {

            String row;
            String[] column = null;

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String headerLine = br.readLine();

            while ((row = br.readLine()) != null) {
                column = row.split(",");

                for (int i = 0; i < column.length; i++) {
                    // Re-assign blanks to zero.. for now
                    if (column[i].isBlank() == true) {
                        column[i] = "0";
                        // System.out.println(i + " was blank, now equals: " + val[i]);
                    } else {
                        // System.out.println(i + " " + val[i].toString());
                    }
                }

                System.out.println(count + ": " + column[0] + " / " + column[1] + " / " + column[2] + " / " + column[3]);
                
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String[] loadInformation() {
        String[] test = new String[count];
        
        for (int i = 0; i < test.length; i++) {
            test[i] = ("Test");
        }
        
        System.out.println("LoadInformation(): " + test.length);
        
        return test;
    }

}
