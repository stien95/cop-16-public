package model;

import java.util.Date;

public class BiodiversePlace {
    private String name;
    private double area;
    private String photo;
    private Date inaugurationDate;
    private double requiredFunding;
    private Department department;
    // caretakerCommunity, residentSpecies.

    public BiodiversePlace(String name, double area, String photo, Date inaugurationDate, double requiredFunding,
            Department department) {
        this.name = name;
        this.area = area;
        this.photo = photo;
        this.inaugurationDate = inaugurationDate;
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

    Date getInaugurationDate() {
        return inaugurationDate;
    }

    void setInaugurationDate(Date inaugurationDate) {
        this.inaugurationDate = inaugurationDate;
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

    public String toString() {
        return "Lugar biodiverso: " + name + "\nArea: " + area + "\nFecha de inauguración: "
                + inaugurationDate.toString()
                + "\nFinanciamiento requerido: " + requiredFunding + "\nDepartamento: " + department.getName();
    }
}
