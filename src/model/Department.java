package model;

import java.util.Date;

public class Department {
    // Attributes
    private String name;
    // Relations
    private BiodiversePlace[] biodiversePlaces;

    public Department(String name) {
        this.name = name;
        biodiversePlaces = new BiodiversePlace[30];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BiodiversePlace[] getBiodiversePlaces() {
        return biodiversePlaces;
    }

    public void setBiodiversePlaces(BiodiversePlace[] biodiversePlaces) {
        this.biodiversePlaces = biodiversePlaces;
    }

    public boolean searchBiodiversePlace(String name) {
        for (int i = 0; i < biodiversePlaces.length; i++) {
            if (biodiversePlaces[i] != null && biodiversePlaces[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public String addBioDiversePlace(String name, double area, String photo, Date inagurationDate, double requiredFunding) {
        String message;
        boolean added = false;
        // Verify if the biodiverse place can be added
        for (int i = 0; i < biodiversePlaces.length; i++) {
            if (biodiversePlaces[i] == null) {
                biodiversePlaces[i] = new BiodiversePlace(name, area, photo, inagurationDate, requiredFunding, this);
                added = true;
            }
        }
        if (added) message = "El lugar biodiverso ha sido agregado exitosamente en el sistema";
        else message = "No se puede agregar el lugar biodiverso, el sistema está lleno";
        return message;
    }
}
