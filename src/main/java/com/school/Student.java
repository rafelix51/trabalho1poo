package com.school;
import java.util.ArrayList;
import java.util.List;

/**
 * Student class extending Person with additional student-specific attributes
 */
public class Student extends Person {
    private String studentId;
    private List<Grade> grades;
    
    public Student(String name, int id, String email, String studentId) {
        super(name, id, email);
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public List<Grade> getGrades() {
        return new ArrayList<>(grades); // Return copy to maintain encapsulation
    }
    
    public void addGrade(Grade grade) {
        grades.add(grade);
    }
    
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (Grade grade : grades) {
            sum += grade.getScore();
        }
        return sum / grades.size();
    }
    
    public String getGradeReport() {
        StringBuilder report = new StringBuilder();
        report.append("Student: ").append(name).append(" (").append(studentId).append(")\n");
        report.append("Grades:\n");
        
        if (grades.isEmpty()) {
            report.append("  No grades recorded yet.\n");
        } else {
            for (Grade grade : grades) {
                report.append("  ").append(grade.toString()).append("\n");
            }
            report.append("Average: ").append(String.format("%.2f", getAverageGrade())).append("\n");
        }
        
        return report.toString();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId;
    }
}
