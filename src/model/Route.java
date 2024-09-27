package model;

public class Route {
    private String name;
    private String address;
    private String startTime;
    private String endTime;
    private BiodiversePlace[] biodiversePlaces;
    // Constants
    public static final int MAX_BIODIVERSE_PLACES = 5;
    /**
     * Constructor method.
     * @param name The name of the route.
     * @param address The address of the route.
     * @param startTime The start time of the route.
     * @param endTime The end time of the route.
     * <b>pre:</b> The parameters must not be null. <br>
     * <b>post:</b> The attributes of the class are initialized. <br>
     */
    public Route(String name, String address, String startTime, String endTime) {
        this.name = name;
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
        biodiversePlaces = new BiodiversePlace[MAX_BIODIVERSE_PLACES];
    }
    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public BiodiversePlace[] getBiodiversePlace() {
        return biodiversePlaces;
    }
    public void setBiodiversePlaces(BiodiversePlace[] biodiversePlace) {
        this.biodiversePlaces = biodiversePlace;
    }
    public BiodiversePlace searchBiodiversePlace(String name) {
        for (int i = 0; i < biodiversePlaces.length; i++) {
            if (biodiversePlaces[i] != null && biodiversePlaces[i].getName().equals(name)) {
                return biodiversePlaces[i];
            }
        }
        return null;
    }
    public String addPlaceToRoute(BiodiversePlace biodiversePlace) {
        String message = ""; // Initialize the message variable with an empty string
        boolean added = false;
        // Verify if the biodiverse place can be added
        BiodiversePlace place = searchBiodiversePlace(biodiversePlace.getName());
        if (place != null) {
            message = "No se puede agregar el lugar biodiverso, ya existe";
        } else {
            for (int i = 0; i < biodiversePlaces.length && !added; i++) {
                if (biodiversePlaces[i] == null) {
                    biodiversePlaces[i] = biodiversePlace;
                    added = true;
                    message = "Lugar biodiverso agregado a la ruta";
                }
            }
            if (!added) {
                message = "No se puede agregar el lugar biodiverso, la ruta está llena";
            }
        }
        
        return message;
    }
    public String toString() {
        String message = "Ruta: " + name + "\n" + "  Dirección punto de encuentro: " + address + "\n" + "  Hora de inicio: "
                + startTime + "\n" + "  Hora de fin: " + endTime + "\n" + "  Lugares biodiversos asociados: \n";
        for (int i = 0; i < biodiversePlaces.length; i++) {
            if (biodiversePlaces[i] != null) {
                message = message + "       Lugar " + (i+1) + ": " + biodiversePlaces[i].getName() + "\n";
            }
        }
        return message;
    }
}
