package model;

import java.util.Date;

public class BiodiversePlace {
    private String name;
    private double area;
    private String photo;
    private Date inaugurationDate;
    private double requiredFunding;
    private Department department;
    private Community caretakerCommunity;
    private Specie[] species;

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

    String addCaretakerCommunity(Community caretakerCommunity) {
        String message = "Ya existe una comunidad encargada de este lugar biodiverso";
        if (this.caretakerCommunity == null) {
            this.caretakerCommunity = caretakerCommunity;
            message = "Comunidad asignada como encargada del lugar biodiverso";
        }
        return message;
    }
    @Override
    public String toString() {
        String message = "Lugar biodiverso: " + name + "\nArea: " + area + "\nFecha de inauguración: "
                + inaugurationDate.toString()
                + "\nFinanciamiento requerido: " + requiredFunding + "\nDepartamento: " + department.getName();
        if (caretakerCommunity != null) {
            message += "\nComunidad encargada: " + caretakerCommunity.getName();
        }
        if (species.length > 0) {
            message += "\nEspecies: ";
            for (int i = 0; i < species.length; i++) {
                if (species[i] != null) {
                    message += species[i].getName() + ", ";
                }
            }
        }
        return message;
    }
}
