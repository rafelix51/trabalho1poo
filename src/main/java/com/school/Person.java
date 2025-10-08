package com.school;
/**
 * Base class representing a person with common attributes
 */
public abstract class Person {
    protected String name;
    protected int id;
    protected String email;
    
    public Person(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id == person.id;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
