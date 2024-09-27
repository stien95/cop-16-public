package model;

import java.util.Date;

/**
 * The CopXVIController class represents a controller for managing routes in the
 * COP XVI system.
 */
public class CopXVIController {
    // Attributes
    private String sponsor;
    private String country;
    // Constants
    public static final int MAX_ROUTES = 5;
    public static final int MAX_DEPARTMENTS = 5;
    public static final int MAX_BIODIVERSE_PLACES_PER_DEPARTMENT = 30;
    // Relations
    private Route[] routes;
    private Department[] departments;

    /**
     * Constructor method.
     * 
     * @param sponsor the sponsor of the COP XVI system
     * @param country the country of the COP XVI system
     *                <b>pre:</b> The parameters must not be null. <br>
     *                <b>post:</b> The attributes of the class are initialized. <br>
     */
    public CopXVIController(String sponsor, String country) {
        this.sponsor = sponsor;
        this.country = country;
        departments = new Department[5];
        routes = new Route[3];
    }

    /**
     * Show the routes of the controller.
     * 
     * @return A message with the routes of the controller.
     *         <b>post:</b> The routes of the controller are shown. <br>
     */
    public String showRoutes() {
        String message = "";
        for (int i = 0; i < routes.length; i++) {
            if (routes[i] != null) {
                String nameMsg = "   Nombre: " + routes[i].getName();
                String addressMsg = "   Dirección de punto de encuentro: " + routes[i].getAddress();
                String startTimeMsg = "   Hora de inicio: " + routes[i].getStartTime();
                String endTimeMsg = "   Hora de fin: " + routes[i].getEndTime();
                message = message + "Ruta " + (i + 1) + ":\n" + nameMsg + "\n" + addressMsg + "\n" + startTimeMsg + "\n"
                        + endTimeMsg + "\n";
            }
        }
        return message;
    }

    /**
     * Add a route to the controller.
     * 
     * @param name      The name of the route.
     * @param address   The address of the meeting point.
     * @param startTime The start time of the route.
     * @param endTime   The end time of the route.
     * @return A message with the result of the operation.
     *         <b>post:</b> The route is added to the controller.<br>
     */
    public String addRoute(String name, String address, String startTime, String endTime) {
        String message;
        boolean added = false;
        for (int i = 0; i < routes.length; i++) {
            if (routes[i] == null) {
                routes[i] = new Route(name, address, startTime, endTime);
                added = true;
            }
        }
        if (added)
            message = "La ruta ha sido agregada exitosamente en el sistema";
        else
            message = "No se puede agregar la ruta, el sistema está lleno";
        return message;
    }

    public boolean searchDepartment(String name) {
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null && departments[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String addDepartment(String name) {
        String message;
        boolean added = false;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] == null) {
                departments[i] = new Department(name);
                added = true;
            }
        }
        if (added)
            message = "El departamento ha sido agregado exitosamente en el sistema";
        else
            message = "No se puede agregar el departamento, el sistema está lleno";
        return message;
    }

    public String addBiodiversePlace(String name, double area, String photo, int inagurationDay, int inagurationMonth,
            int inagurationYear, double requiredFunding, String departmentName) {
        // Search the department
        Department department = null;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null && departments[i].getName().equals(departmentName)) {
                department = departments[i];
            }
        }
        if (department == null) {
            return "No se puede agregar el lugar biodiverso, el departamento no existe";
        }
        Date inagurationDate = new Date(inagurationYear, inagurationMonth, inagurationDay);
        // Add the biodiverse place
        String message = department.addBioDiversePlace(departmentName, area, photo, inagurationDate, requiredFunding);
        return message;
    }

    public BiodiversePlace[] getAllBiodiversePlaces() {
        int count = 0;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null) {
                BiodiversePlace[] departmentPlaces = departments[i].getBiodiversePlaces();
                if (departmentPlaces != null) {
                    for (int j = 0; j < departmentPlaces.length; j++) {
                        if (departmentPlaces[j] != null) {
                            count++;
                        }
                    }
                }
            }
        }
        BiodiversePlace[] biodiversePlaces = new BiodiversePlace[count];
        int index = 0;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null) {
                BiodiversePlace[] departmentPlaces = departments[i].getBiodiversePlaces();
                if (departmentPlaces != null) {
                    for (int j = 0; j < departmentPlaces.length; j++) {
                        if (departmentPlaces[j] != null) {
                            biodiversePlaces[index] = departmentPlaces[j];
                            index++;
                        }
                    }
                }
            }
        }

        return biodiversePlaces;
    }

    public String showBiodiversePlaces() {
        String message = "";
        BiodiversePlace[] biodiversePlaces = getAllBiodiversePlaces();
        // Show the biodiverse places
        for (int i = 0; i < biodiversePlaces.length; i++) {
            if (biodiversePlaces[i] != null) {
                message = message + biodiversePlaces[i].toString() + "\n";
            }
        }
        return message;
    }

    public String findMostBiodiverseDepartment() {
        String message = "";
        // Find the most biodiverse department
        int max = 0;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null
                    && departments[i].getBiodiversePlaces().length > departments[max].getBiodiversePlaces().length) {
                max = i;
            }
        }
        message = "El departamento con más lugares biodiversos es: " + departments[max].getName();
        return message;
    }

    // Getters and Setters
    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
