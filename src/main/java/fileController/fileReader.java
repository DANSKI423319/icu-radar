package fileController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import models.Cpax;
import models.Mrc;
import models.Patient;
import models.Sofa;

/**
 *
 * @author Daniel
 */
public class fileReader {

    /**
     * @param args the command line arguments
     */
    static Patient[] patientsDataPack;
    static int count = 0;

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
                        column[i] = null;
                    } else {
                    }
                }
                
                tempCpax = new Cpax((column[4]), (column[5]),
                        (column[6]), (column[7]),
                        (column[8]), (column[9]),
                        (column[10]), (column[11]),
                        (column[12]), (column[13]),
                        (column[14]));

                tempMrc = new Mrc((column[15]), (column[16]),
                        (column[17]), (column[18]),
                        (column[19]), (column[20]),
                        (column[21]), (column[22]),
                        (column[23]), (column[24]),
                        (column[25]), (column[26]),
                        (column[27]), (column[28]),
                        (column[29]), (column[30]),
                        (column[31]), (column[32]),
                        (column[33]), (column[34]),
                        (column[35]), (column[36]),
                        (column[37]), (column[38]),
                        (column[39]));

                tempSofa = new Sofa((column[40]), (column[41]),
                        (column[42]), (column[43]),
                        (column[44]), (column[45]),
                        (column[46]));

                Patient tempPatient = new Patient(column[0], column[1], column[2], column[3], tempCpax, tempMrc, tempSofa);
                tempArray[localCount] = tempPatient;

                localCount++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return tempArray;
    }
}
