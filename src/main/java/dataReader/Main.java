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
    static Patient[] patientsDataPack;
    static int count = 0;

    public static void main(String[] args) {
        // TODO code application logic here

        String path = "D:/Documents/University Archive/Bsc Computing Year 3/COMP3000 Computing Project/Project/data.csv";
        count = countData(path);
        patientsDataPack = loadData(path, count);

        for (int i = 0; i < patientsDataPack.length; i++) {
            System.out.println(patientsDataPack[i].getAdmission());
        }

        //System.out.println("LoadData(): " + count);

    }

    // Count rows
    public static int countData(String filePath) {
        int tempCount = 0;

        try {
            String row;
            String[] column = null;

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String headerLine = br.readLine();

            while ((row = br.readLine()) != null) {
                tempCount++;
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        return tempCount;
    }

    public static Patient[] loadData(String filePath, int rowCount) {

        Patient[] tempArray = new Patient[rowCount];
        Cpax tempCpax = new Cpax();
        Mrc tempMrc = new Mrc();
        Sofa tempSofa = new Sofa();

        try {
            int localCount = 0;
            String row;
            String[] column = null;

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String headerLine = br.readLine();

            // Until the next line equals null...
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

                tempCpax = new Cpax(Integer.parseInt(column[4]), Integer.parseInt(column[5]),
                        Integer.parseInt(column[6]), Integer.parseInt(column[7]),
                        Integer.parseInt(column[8]), Integer.parseInt(column[9]),
                        Integer.parseInt(column[10]), Integer.parseInt(column[11]),
                        Integer.parseInt(column[12]), Integer.parseInt(column[13]),
                        Integer.parseInt(column[14]));

                tempMrc = new Mrc(Integer.parseInt(column[15]), Integer.parseInt(column[16]),
                        Integer.parseInt(column[17]), Integer.parseInt(column[18]),
                        Integer.parseInt(column[19]), Integer.parseInt(column[20]),
                        Integer.parseInt(column[21]), Integer.parseInt(column[22]),
                        Integer.parseInt(column[23]), Integer.parseInt(column[24]),
                        Integer.parseInt(column[25]), Integer.parseInt(column[26]),
                        Integer.parseInt(column[27]), Integer.parseInt(column[28]),
                        Integer.parseInt(column[29]), Integer.parseInt(column[30]),
                        Integer.parseInt(column[31]), Integer.parseInt(column[32]),
                        Integer.parseInt(column[33]), Integer.parseInt(column[34]),
                        Integer.parseInt(column[35]), Integer.parseInt(column[36]),
                        Integer.parseInt(column[37]), Integer.parseInt(column[38]),
                        Integer.parseInt(column[39]));

                tempSofa = new Sofa(Integer.parseInt(column[40]), Integer.parseInt(column[41]),
                        Integer.parseInt(column[42]), Integer.parseInt(column[43]),
                        Integer.parseInt(column[44]), Integer.parseInt(column[45]),
                        Integer.parseInt(column[46]));

                Patient tempPatient = new Patient(column[0], column[1], column[2], column[3], tempCpax, tempMrc, tempSofa);
                tempArray[localCount] = tempPatient;

                localCount++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tempArray;
    }
}
