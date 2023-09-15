import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and setters (optional)

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + "\nName: " + name + "\nGrade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.printf(
                    "===============================================");
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.printf(
                    "===============================================");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.printf(
                            "===============================================");
                    System.out.print("\nEnter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();

                    Student newStudent = new Student(name, rollNumber, grade);
                    system.addStudent(newStudent);
                    System.out.println("\nStudent added successfully...");
                    System.out.println(
                            "===============================================");
                    break;

                case 2:
                    System.out.printf(
                            "===============================================");
                    System.out.print("\nEnter Roll Number to Remove: ");
                    int removeRollNumber = scanner.nextInt();
                    boolean removed = system.removeStudent(removeRollNumber);
                    if (removed) {
                        System.out.println("Student removed successfully...");
                    } else {
                        System.out.println("Student not found!!!");
                    }
                    System.out.println(
                            "===============================================");
                    break;

                case 3:
                    System.out.printf(
                            "===============================================");
                    System.out.print("\nEnter Roll Number to Search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student foundStudent = system.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Student Found:\n" + foundStudent);
                    } else {
                        System.out.println("Student not found!!!");
                    }
                    System.out.println(
                            "===============================================");
                    break;

                case 4:
                    System.out.printf(
                            "===============================================");
                    List<Student> allStudents = system.getAllStudents();
                    System.out.println("\nAll Students:");
                    for (Student student : allStudents) {
                        System.out.println(
                                "===============================================");
                        System.out.println(student);
                    }
                    break;

                case 5:
                    System.out.printf(
                            "===============================================");
                    System.out.println("\nExiting Student Management System...");
                    scanner.close();
                    System.exit(0);
                    System.out.println(
                            "===============================================");
                    break;

                default:
                    System.out.printf(
                            "===============================================");
                    System.out.println("Invalid choice. Please try again!!!");
                    System.out.println(
                            "===============================================");
            }
        }
    }
}