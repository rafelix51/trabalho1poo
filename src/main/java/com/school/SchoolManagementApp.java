package com.school;
import java.util.Scanner;

/**
 * Main application class for the School Management System
 */
public class SchoolManagementApp {
    private School school;
    private Scanner scanner;
    private boolean running;
    
    public SchoolManagementApp() {
        this.school = new School();
        this.scanner = new Scanner(System.in);
        this.running = true;
        initializeSampleData();
    }
    
    public void run() {
        System.out.println("=== WELCOME TO SCHOOL MANAGEMENT SYSTEM ===");
        System.out.println("A simple platform for managing students and teachers");
        
        while (running) {
            displayMainMenu();
            int choice = getMenuChoice();
            handleMenuChoice(choice);
        }
        
        school.close();
        scanner.close();
        System.out.println("Thank you for using School Management System!");
    }
    
    private void displayMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("MAIN MENU");
        System.out.println("=".repeat(50));
        System.out.println("1. Add Student");
        System.out.println("2. Add Teacher");
        System.out.println("3. View All Students");
        System.out.println("4. View All Teachers");
        System.out.println("5. Assign Student to Teacher");
        System.out.println("6. Grade Student");
        System.out.println("7. View Student Grades");
        System.out.println("8. Exit");
        System.out.println("=".repeat(50));
    }
    
    private int getMenuChoice() {
        System.out.print("Enter your choice (1-8): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
            System.out.print("Enter your choice (1-8): ");
        }
        return scanner.nextInt();
    }
    
    private void handleMenuChoice(int choice) {
        scanner.nextLine(); // consume newline after reading int
        
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                addTeacher();
                break;
            case 3:
                school.displayAllStudents();
                break;
            case 4:
                school.displayAllTeachers();
                break;
            case 5:
                school.assignStudentToTeacher();
                break;
            case 6:
                school.gradeStudent();
                break;
            case 7:
                school.viewStudentGrades();
                break;
            case 8:
                running = false;
                break;
            default:
                System.out.println("Invalid choice! Please select 1-8.");
        }
        
        if (choice != 8) {
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    
    private void addStudent() {
        System.out.println("\n=== ADD NEW STUDENT ===");
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student ID (unique number): ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter student ID (e.g., STU001): ");
        String studentId = scanner.nextLine();
        
        Student student = new Student(name, id, email, studentId);
        school.addStudent(student);
    }
    
    private void addTeacher() {
        System.out.println("\n=== ADD NEW TEACHER ===");
        
        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter teacher ID (unique number): ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        
        Teacher teacher = new Teacher(name, id, email, department);
        school.addTeacher(teacher);
    }
    
    private void initializeSampleData() {
        System.out.println("Initializing sample data...");
        
        // Create sample teachers
        Teacher teacher1 = new Teacher("Dr. Sarah Johnson", 1001, "sarah.johnson@school.edu", "Mathematics");
        Teacher teacher2 = new Teacher("Prof. Michael Chen", 1002, "michael.chen@school.edu", "Computer Science");
        Teacher teacher3 = new Teacher("Dr. Emily Rodriguez", 1003, "emily.rodriguez@school.edu", "Physics");
        
        school.addTeacher(teacher1);
        school.addTeacher(teacher2);
        school.addTeacher(teacher3);
        
        // Create sample students
        Student student1 = new Student("Alice Williams", 2001, "alice.williams@student.edu", "STU001");
        Student student2 = new Student("Bob Smith", 2002, "bob.smith@student.edu", "STU002");
        Student student3 = new Student("Carol Davis", 2003, "carol.davis@student.edu", "STU003");
        Student student4 = new Student("David Brown", 2004, "david.brown@student.edu", "STU004");
        Student student5 = new Student("Eva Garcia", 2005, "eva.garcia@student.edu", "STU005");
        
        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);
        school.addStudent(student4);
        school.addStudent(student5);
        
        // Assign students to teachers
        teacher1.addStudent(student1);
        teacher1.addStudent(student2);
        teacher2.addStudent(student3);
        teacher2.addStudent(student4);
        teacher3.addStudent(student5);
        teacher3.addStudent(student1); // Alice is also taking Physics
        
        // Add some sample grades
        teacher1.gradeStudent(student1, "Calculus I", 85.5, "Good understanding of derivatives");
        teacher1.gradeStudent(student1, "Linear Algebra", 92.0, "Excellent work on matrix operations");
        teacher1.gradeStudent(student2, "Calculus I", 78.0, "Needs improvement in integration");
        
        teacher2.gradeStudent(student3, "Java Programming", 88.0, "Strong object-oriented programming skills");
        teacher2.gradeStudent(student4, "Data Structures", 95.0, "Outstanding performance");
        
        teacher3.gradeStudent(student5, "Mechanics", 82.0, "Good grasp of fundamental concepts");
        teacher3.gradeStudent(student1, "Thermodynamics", 90.0, "Excellent problem-solving skills");
        
        System.out.println("Sample data loaded successfully!");
        System.out.println("- 3 Teachers (Math, Computer Science, Physics)");
        System.out.println("- 5 Students with various assignments");
        System.out.println("- Sample grades already recorded");
        System.out.println();
    }
    
    public static void main(String[] args) {
        SchoolManagementApp app = new SchoolManagementApp();
        app.run();
    }
}
