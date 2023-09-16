/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab1;

/**
 * This class represents the main class for the Lab1 application.
 * It demonstrates the usage of various classes such as Nurse, Doctor, and Patient.
 * It also includes methods to print employee information, patient information, calculate annual cost,
 * and patient assignments.
 * 
 * @Author C0535365 Justin Milner
 */
public class Main {

    /**
     * The main method is the entry point of the Lab1 application.
     * It creates instances of Nurse, Doctor, and Patient objects,
     * and demonstrates the usage of various methods to print information and perform calculations.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Nurse nurse1 = new Nurse("Radiology", "Amy", "Dubanowski");
        nurse1.setShift(Nurse.SHIFT_B);
        Nurse nurse2 = new Nurse("Human Resources","Jonah", "Simms");
        nurse2.setShift(Nurse.SHIFT_C);
        Nurse nurse3 = new Nurse("Emergency","Glenn", "Sturgis");
        Nurse[] nurses = { nurse1, nurse2, nurse3 };

        Doctor doc1 = new Doctor("Radiology", "Family Practice", "Cheyenne", "Lee");
        Doctor doc2 = new Doctor("Human Resources", "Neurology", "Dina", "Fox");
        Doctor doc3 = new Doctor("Emergency", "Surgery", "Adam", "Dubanowski");
        Doctor[] doctors = { doc1, doc2, doc3 };

        String[] givenNames = {
            "Avery", "Riley", "Jordan", "Angel", "Peyton",
            "Quinn", "Hayden", "Taylor", "Alexis", "Rowan",
            "Charlie", "Emerson", "Finley", "River", "Emery",
            "Morgan", "Elliot", "London", "Eden", "Elliott",
            "Karter", "Dakota", "Reese", "Remington", "Payton",
            "Amari", "Phoenix", "Kendall", "Harley", "Rylan",
            "Marley", "Dallas", "Skyler", "Spencer", "Sage",
            "Kyrie", "Ellis", "Rory", "Remi", "Justice",
            "Ali", "Haven", "Tatum", "Arden", "Linden",
            "Devon", "Rebel", "Rio", "Ripley", "Frankie"
        };
        String[] surnames = {
            "Smith", "Brown", "Tremblay", "Martin", "Roy",
            "Wilson", "Macdonald", "Gagnon", "Johnson", "Taylor",
            "Cote", "Campbell", "Anderson", "Leblanc", "Lee",
            "Jones", "White", "Williams", "Miller", "Thompson",
            "Gauthier", "Young", "Van", "Morin", "Bouchard",
            "Scott", "Stewart", "Belanger", "Reid", "Pelletier",
            "Moore", "Lavoie", "King", "Robinson", "Levesque",
            "Murphy", "Fortin", "Gagne", "Wong", "Clark",
            "Johnston", "Clarke", "Ross", "Walker", "Thomas",
            "Boucher", "Landry", "Kelly", "Bergeron", "Davis"
        };
        Patient[] patients = new Patient[23];
        patients[0] = new Patient("Ron","Weasley",doc1);
        patients[1] = new Patient("Hermione","Granger",doc2);
        patients[2] = new Patient("Harry","Potter",doc3);
        for (int i = 3; i <= 22; i++) {
            int randomDoc = randomDoc();
            int randomName = randomName(givenNames);
            int randomSurname = randomName(surnames);
            patients[i] = new Patient(givenNames[randomName], surnames[randomSurname], doctors[randomDoc]);
        }

        printEmployeeInfo(nurses, doctors);
        printPatientInfo(patients);
        System.out.printf("Annual cost: $%d%n", printAnnualCost(doctors, nurses));
        printPatientAssignment(patientAssignment(patients, doctors), doctors);

    }

    /**
     * Generates a random index for the nameList array.
     * 
     * @param nameList the array of names
     * @return a random index within the range of the nameList array
     */
    public static int randomName(String[] nameList) {
        return (int) (Math.random() * nameList.length);
    }

    /**
     * Generates a random index for the doctors array.
     * 
     * @return a random index within the range of the doctors array
     */
    public static int randomDoc() {
        return (int) (Math.random() *3);
    }

    /**
     * Prints the information of nurses and doctors.
     * 
     * @param nurses the array of Nurse objects
     * @param doctors the array of Doctor objects
     */
    public static void printEmployeeInfo(Nurse[] nurses, Doctor[] doctors) {
        for (int i = 0; i < 3; i++) {
            System.out.println(nurses[i].toString());
            System.out.println(doctors[i].toString());
        }
    }

    /**
     * Prints the information of patients and their physician ID.
     *
     * @param patients the array of Patient objects
     */
    public static void printPatientInfo(Patient[] patients) {
        for (int i = 0; i < patients.length; i++) {
            System.out.printf("Patient %s has physician (ID#%s)%n", patients[i].toString(),patients[i].physician.ID);
        }
    }

    /**
     * Calculates the annual cost of doctors and nurses combined.
     *
     * @param doctors the array of Doctor objects
     * @param nurses the array of Nurse objects
     * @return the total annual cost
     */
    public static int printAnnualCost(Doctor[] doctors, Nurse[] nurses) {
        int sum = 0;
        for (int i = 0; i < doctors.length; i++) {
            sum += doctors[i].annualSalary;
        }

        for (int i = 0; i < nurses.length; i++) {
            sum += nurses[i].getShift();
        }

        return sum;
    }

    /**
     * Calculates the number of patients assigned to each doctor.
     *
     * @param patients the array of Patient objects
     * @param doctors the array of Doctor objects
     * @return an array containing the number of patients assigned to each doctor
     */
    public static int[] patientAssignment(Patient[] patients, Doctor[] doctors) {
        int doc1Total = 0;
        int doc2Total = 0;
        int doc3Total = 0;
        for (int i = 0; i < patients.length; i ++) {
            if (patients[i].physician == doctors[0]) {
                doc1Total += 1;
            }
            if (patients[i].physician == doctors[1]) {
                doc2Total += 1;
            }
            else {
                doc3Total += 1;
            }
        }

        int[] docTotals = { doc1Total, doc2Total, doc3Total };
        return docTotals;
    }

    /**
     * Prints the number of patients assigned to each doctor.
     *
     * @param assignments an array containing the number of patients assigned to each doctor
     * @param doctors the array of Doctor objects
     */
    public static void printPatientAssignment(int[] assignments, Doctor[] doctors) {
        for (int i = 0; i < assignments.length; i++) {
            System.out.printf("Physician (ID#%s) has %d patients under assignment.%n", doctors[i].ID, assignments[i]);
        }
    }
}
