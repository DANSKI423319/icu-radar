package models;

import java.util.ArrayList;

public class Main {

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Sofa> sofas = new ArrayList<>();

    public static void main(String[] args) {

        Patient p = new Patient("John", "Doe", "10852");
        Sofa s = new Sofa(1, 2, 3, 4, 5, 5, p.getFirstName(), p.getLastName(), p.getPatientID());
        System.out.println(p.getFirstName());

        patients.add(p);
        sofas.add(s);

        System.out.println(patients.get(0).getPatientID());

        System.out.println(sofas.get(0).getSofaTotal(0));

    }
    
 }
