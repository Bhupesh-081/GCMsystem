import java.util.ArrayList;
import java.util.Scanner;

// Student class to store student details and grades
class Student {
    private String name;
    private int rollNumber;
    private ArrayList<Integer> marks;
    private int totalMarks;
    private double average;
    private String grade;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = new ArrayList<>();
        this.totalMarks = 0;
        this.average = 0.0;
        this.grade = "N/A";
    }

    // Method to add marks for different subjects
    public void addMarks(int mark) {
        marks.add(mark);
        totalMarks += mark;
        calculateAverageAndGrade();
    }

    // Method to calculate average and assign grade
    private void calculateAverageAndGrade() {
        if (!marks.isEmpty()) {
            this.average = (double) totalMarks / marks.size();
        }
        
        if (average >= 90) {
            this.grade = "A+";
        } else if (average >= 80) {
            this.grade = "A";
        } else if (average >= 70) {
            this.grade = "B";
        } else if (average >= 60) {
            this.grade = "C";
        } else if (average >= 50) {
            this.grade = "D";
        } else {
            this.grade = "F (Fail)";
        }
    }

    // Display student details and grade card
    public void displayGradeCard() {
        System.out.println("\n--- Grade Card ---");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Subjects: " + marks.size());
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average: " + String.format("%.2f", average));
        System.out.println("Grade: " + grade);
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

// Main class to manage the Grade Card System
public class GradeCardSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== Grade Card Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. Enter Marks");
            System.out.println("3. Display Grade Card");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            while (!scanner.hasNextInt()) { 
                System.out.println("Invalid input! Enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    enterMarks();
                    break;
                case 3:
                    displayGradeCard();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
    }

    // Add a new student
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Enter a valid roll number.");
            scanner.next();
        }
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        students.add(new Student(name, rollNumber));
        System.out.println("Student added successfully!");
    }

    // Enter marks for a student
    private static void enterMarks() {
        System.out.print("Enter roll number of student: ");
        int rollNumber = scanner.nextInt();
        Student student = findStudent(rollNumber);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            int marks;
            while (true) {
                if (scanner.hasNextInt()) {
                    marks = scanner.nextInt();
                    if (marks >= 0 && marks <= 100) break;
                } else {
                    scanner.next(); // Clear invalid input
                }
                System.out.print("Invalid marks! Enter again (0-100): ");
            }
            student.addMarks(marks);
        }
        System.out.println("Marks added successfully!");
    }

    // Display a student's grade card
    private static void displayGradeCard() {
        System.out.print("Enter roll number of student: ");
        int rollNumber = scanner.nextInt();
        Student student = findStudent(rollNumber);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        student.displayGradeCard();
    }

    // Find a student by roll number
    private static Student findStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                return s;
            }
        }
        return null;
    }
}
