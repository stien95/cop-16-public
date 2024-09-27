package model;

/**
 * CommunityRepresentative
 */
public class CommunityRepresentative {
    // Attributes
    private String name;
    private String phoneNumber;
    // Constructor
    public CommunityRepresentative(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String toString() {
        return "Representante:" + name + "\nTelefono del representante:" + phoneNumber;
    }
    
}