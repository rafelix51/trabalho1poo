package com.school;
import java.util.ArrayList;
import java.util.List;

/**
 * Teacher class extending Person with teacher-specific functionality
 */
public class Teacher extends Person {
    private String department;
    private List<Student> students;
    
    public Teacher(String name, int id, String email, String department) {
        super(name, id, email);
        this.department = department;
        this.students = new ArrayList<>();
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public List<Student> getStudents() {
        return new ArrayList<>(students); // Return copy to maintain encapsulation
    }
    
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }
    
    public void removeStudent(Student student) {
        students.remove(student);
    }
    
    public void gradeStudent(Student student, String subject, double score, String comments) {
        if (students.contains(student)) {
            Grade grade = new Grade(this, student, subject, score, comments);
            student.addGrade(grade);
        } else {
            System.out.println("Error: Student is not assigned to this teacher.");
        }
    }
    
    public String getStudentList() {
        StringBuilder list = new StringBuilder();
        list.append("Students assigned to ").append(name).append(":\n");
        
        if (students.isEmpty()) {
            list.append("  No students assigned.\n");
        } else {
            for (int i = 0; i < students.size(); i++) {
                list.append("  ").append(i + 1).append(". ").append(students.get(i).toString()).append("\n");
            }
        }
        
        return list.toString();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Department: " + department;
    }
}
