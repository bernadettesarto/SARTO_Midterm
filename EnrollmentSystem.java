import java.util.Scanner;

class Person {// Base class representing a person with name and age
    private String name;
    private int age;

    public Person(String name, int age) {   // Constructor to initialize name and age
        this.name = name;
        this.age = age;
    }

    public void displayInfo() { // Method to display person's information
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {// Class representing a student, inheriting from Person
    private String studentID, course;
    private int units;
    private static final int FEE_PER_UNIT = 1000; // Fee constant per unit

    public Student(String name, int age, String studentID, String course, int units) { // Constructor to initialize student details
        super(name, age);
        this.studentID = studentID;
        this.course = course;
        this.units = units;
    }

    public double calculateFees() {  // Method to calculate total fees
        return units * FEE_PER_UNIT;
    }

    @Override // Overriding displayInfo to include fee information
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Total Fee: P" + calculateFees());
    }
}

class Instructor extends Person {// Class representing an instructor, inheriting from Person
    private String employeeID, department;
    private double salary;

    public Instructor(String name, int age, String employeeID, String department, double salary) { // Constructor to initialize instructor details
        super(name, age);
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public void displayInfo() {  // Overriding displayInfo to include salary information
        super.displayInfo();
        System.out.println("Salary: P" + salary);
    }
}
public class UniversityEnrollmentSystem {// Main class to run the university enrollment system
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter details for the Student:");
        Student student = createStudent(scanner); // Create a Student object
        student.displayInfo(); // Display student info

        System.out.println("\nEnter details for the Instructor:");
        Instructor instructor = createInstructor(scanner); // Create an Instructor object
        instructor.displayInfo(); // Display instructor info
        scanner.close(); // Close the scanner
    }

    private static Student createStudent(Scanner scanner) {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Course: ");
        String course = scanner.nextLine();
        System.out.print("Units: ");
        int units = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return new Student(name, age, id, course, units); // Return new Student
    }

    private static Instructor createInstructor(Scanner scanner) {// Method to create and return an Instructor object based on user input
        System.out.print("Enter Instructor Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Department: ");
        String department = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        return new Instructor(name, age, id, department, salary); // Return new Instructor
    }
}
