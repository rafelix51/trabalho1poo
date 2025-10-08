package com.school;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Grade class representing a grade given by a teacher to a student
 */
public class Grade {
    private Teacher teacher;
    private Student student;
    private String subject;
    private double score;
    private String comments;
    private LocalDateTime dateTime;
    
    public Grade(Teacher teacher, Student student, String subject, double score, String comments) {
        this.teacher = teacher;
        this.student = student;
        this.subject = subject;
        this.score = score;
        this.comments = comments;
        this.dateTime = LocalDateTime.now();
    }
    
    // Getters
    public Teacher getTeacher() {
        return teacher;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public double getScore() {
        return score;
    }
    
    public String getComments() {
        return comments;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    // Setters
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public void setScore(double score) {
        this.score = score;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public String getLetterGrade() {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("%s - %s: %.1f (%s) - %s [%s]", 
                           subject, student.getName(), score, getLetterGrade(), 
                           comments, dateTime.format(formatter));
    }
}
