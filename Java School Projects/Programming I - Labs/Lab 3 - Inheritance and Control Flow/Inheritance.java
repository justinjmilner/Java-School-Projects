package MilnerJustin_lab8;

/**
 * The `Inheritance` class serves as the main flow control for the program.
 * It demonstrates the usage of inheritance and the interaction between different classes.
 *
 * author C0535365 Justin Milner
 * version 1.0
 * since 2023-06-14
 */
public class Inheritance {
    
    /**
     * The main method, which is the entry point for the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student student1 = new Student("Bob", "Marley");
        Student student2 = new Student("Harry", "Potter", 4.0, "Hogwarts");
        
        Employee employee1 = new Employee("Ron", "Swanson");
        Employee employee2 = new Employee("Severus", "Snape", "Hogwarts School", "Professor");
                
        GraduateStudent gradStudent1 = new GraduateStudent("John", "Smith");
        GraduateStudent gradStudent2 = new GraduateStudent("Hermione", "Granger", "Potions", "Determining the Optimal "
                                                                + " Brewing Conditions for Enhanced Potion Efficacy: A Study in "
                                                                + " Potion-making at Hogwarts School of Witchcraft and Wizardry", employee2);
        student1.school = "Camosun";
        gradStudent1.age = 37;
        
        gradStudent2.school = "Hogwarts";
        gradStudent2.ID = "H0539124";
        gradStudent2.addClass("Brewing Conditions");
        
        employee2.addMentee(gradStudent2);
        
        System.out.println(gradStudent2.firstName + " is " +  gradStudent2.study(gradStudent2.department));
        System.out.println(employee2.firstName + " " + employee2.lastName + " is a " + employee2.position + " at " + employee2.company);
        
        employee2.startMentoring();
        gradStudent2.writeFinalExam();
        gradStudent2.addGrades(95);
        gradStudent2.printReportCard(95);
        
        System.out.print(employee1.sayHelloTo(employee2));
        System.out.print(student2.sayHelloTo(gradStudent2));
        System.out.print(gradStudent2.sayHelloTo(student2));
    }
}

