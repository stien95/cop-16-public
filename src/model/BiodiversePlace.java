package model;

import java.util.Date;

public class BiodiversePlace {
    private String name;
    private double area;
    private String photo;
    private Date inagurationDate;
    private double requiredFunding;
    private Department department;
    // caretakerCommunity, residentSpecies.
    
    public BiodiversePlace(String name, double area, String photo, Date inagurationDate, double requiredFunding, Department department) {
        this.name = name;
        this.area = area;
        this.photo = photo;
        this.inagurationDate = inagurationDate;
        this.requiredFunding = requiredFunding;
        this.department = department;
    }
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    double getArea() {
        return area;
    }
    void setArea(double area) {
        this.area = area;
    }
    String getPhoto() {
        return photo;
    }
    void setPhoto(String photo) {
        this.photo = photo;
    }
    Date getInagurationDate() {
        return inagurationDate;
    }
    void setInagurationDate(Date inagurationDate) {
        this.inagurationDate = inagurationDate;
    }
    double getRequiredFunding() {
        return requiredFunding;
    }
    void setRequiredFunding(double requiredFunding) {
        this.requiredFunding = requiredFunding;
    }
    Department getDepartment() {
        return department;
    }
    void setDepartment(Department department) {
        this.department = department;
    }
}

