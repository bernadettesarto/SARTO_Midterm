import java.util.Scanner;
class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Student extends Person {
    private String studentID, course;
    private int units;
    private static final int FEE_PER_UNIT = 1000;
    public Student(String name, int age, String studentID, String course, int units) {
        super(name, age);
        this.studentID = studentID;
        this.course = course;
        this.units = units;
    }
    public double calculateFees() {
        return units * FEE_PER_UNIT;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Total Fee: P" + calculateFees());
    }
}
class Instructor extends Person {
    private String employeeID, department;
    private double salary;
    public Instructor(String name, int age, String employeeID, String department, double salary) {
        super(name, age);
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Salary: P" + salary);
    }
}
public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter details for the Student:");
        Student student = createStudent(scanner);
        student.displayInfo();
        System.out.println("\nEnter details for the Instructor:");
        Instructor instructor = createInstructor(scanner);
        instructor.displayInfo();
        scanner.close();
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
        return new Student(name, age, id, course, units);
    }
    private static Instructor createInstructor(Scanner scanner) {
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
        return new Instructor(name, age, id, department, salary);
    }
}
