package com.school;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * School class to manage students and teachers
 */
public class School {
    private List<Student> students;
    private List<Teacher> teachers;
    private Scanner scanner;
    
    public School() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Student already exists!");
        }
    }
    
    public void addTeacher(Teacher teacher) {
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
            System.out.println("Teacher added successfully!");
        } else {
            System.out.println("Teacher already exists!");
        }
    }
    
    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
    
    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }
    
    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    
    public Teacher findTeacherById(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }
    
    public void displayAllStudents() {
        System.out.println("\n=== ALL STUDENTS ===");
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i).toString());
            }
        }
    }
    
    public void displayAllTeachers() {
        System.out.println("\n=== ALL TEACHERS ===");
        if (teachers.isEmpty()) {
            System.out.println("No teachers registered.");
        } else {
            for (int i = 0; i < teachers.size(); i++) {
                System.out.println((i + 1) + ". " + teachers.get(i).toString());
            }
        }
    }
    
    public void assignStudentToTeacher() {
        if (students.isEmpty() || teachers.isEmpty()) {
            System.out.println("No students or teachers available for assignment.");
            return;
        }
        
        displayAllStudents();
        System.out.print("\nEnter student ID to assign: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        displayAllTeachers();
        System.out.print("\nEnter teacher ID to assign to: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Teacher teacher = findTeacherById(teacherId);
        if (teacher == null) {
            System.out.println("Teacher not found!");
            return;
        }
        
        teacher.addStudent(student);
        System.out.println("Student " + student.getName() + " assigned to teacher " + teacher.getName());
    }
    
    public void gradeStudent() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers available.");
            return;
        }
        
        displayAllTeachers();
        System.out.print("\nSelect teacher ID: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Teacher teacher = findTeacherById(teacherId);
        if (teacher == null) {
            System.out.println("Teacher not found!");
            return;
        }
        
        if (teacher.getStudents().isEmpty()) {
            System.out.println("No students assigned to this teacher.");
            return;
        }
        
        System.out.println(teacher.getStudentList());
        System.out.print("Enter student ID to grade: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Student student = teacher.getStudents().stream()
            .filter(s -> s.getId() == studentId)
            .findFirst()
            .orElse(null);
            
        if (student == null) {
            System.out.println("Student not found or not assigned to this teacher!");
            return;
        }
        
        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();
        
        System.out.print("Enter score (0-100): ");
        double score = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        
        System.out.print("Enter comments: ");
        String comments = scanner.nextLine();
        
        teacher.gradeStudent(student, subject, score, comments);
        System.out.println("Grade recorded successfully!");
    }
    
    public void viewStudentGrades() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        
        displayAllStudents();
        System.out.print("\nEnter student ID to view grades: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        System.out.println(student.getGradeReport());
    }
    
    public void close() {
        scanner.close();
    }
}
