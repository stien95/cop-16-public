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
        departments = new Department[MAX_DEPARTMENTS];
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
                message = message + "--------------------- \n" + routes[i].toString() + "\n";
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
        for (int i = 0; i < routes.length && !added; i++) {
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

    public int searchDepartment(String name) {
        int index = -1;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null && departments[i].getName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public BiodiversePlace searchBiodiversePlace(String name) {
        BiodiversePlace biodiversePlace = null;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null) {
                biodiversePlace = departments[i].searchBiodiversePlace(name);
                if (biodiversePlace != null) {
                    break;
                }
            }
        }
        return biodiversePlace;
    }

    public Route searchRoute(String name) {
        Route route = null;
        for (int i = 0; i < routes.length; i++) {
            if (routes[i] != null && routes[i].getName().equals(name)) {
                route = routes[i];
                break;
            }
        }
        return route;
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
        String message;
        Department department = null;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null && departments[i].getName().equals(departmentName)) {
                department = departments[i];
                break;
            }
        }
        if (department == null) {
            message = "No se puede agregar el lugar biodiverso, el departamento no existe";
        } else {
            Date inaugurationDate = new Date(inagurationYear, inagurationMonth, inagurationDay);
            // Add the biodiverse place
            message = department.addBioDiversePlace(name, area, photo, inaugurationDate, requiredFunding);
        }
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

    public String associatePlacesToRoute(String routeName, String placeName) {
        String message = "";
        // Search the route
        Route route = searchRoute(routeName);
        if (route == null) {
            return "No se puede asociar el lugar a la ruta, la ruta no existe";
        }
        // Search the biodiverse place
        BiodiversePlace place = searchBiodiversePlace(placeName);
        if (place == null) {
            return "No se puede asociar el lugar a la ruta, el lugar no existe";
        }
        // Associate the place to the route
        message = route.addPlaceToRoute(place);
        return message;
    }
    public String addCommunity(String name, String type, String representativeName, String representativePhoneNumber,
            String[] problems, int population, String biodiversePlaceName) {
        String message;
        
        if ()
        CommunityRepresentative representative = new CommunityRepresentative(representativeName,
                representativePhoneNumber);
        CommunityProblem[] communityProblems = new CommunityProblem[problems.length];
        for (int i = 0; i < problems.length; i++) {
            if (problems[i].equalsIgnoreCase("hospital")) {
                communityProblems[i] = CommunityProblem.LACK_OF_HOSPITAL;
            }
            if (problems[i].equalsIgnoreCase("escuela")) {
                communityProblems[i] = CommunityProblem.LACK_OF_SCHOOL;
            }
            if (problems[i].equalsIgnoreCase("agua potable")) {
                communityProblems[i] = CommunityProblem.LACK_OF_POTABLE_WATER;
            if (problems[i].equalsIgnoreCase("alimentos basicos")) {
                communityProblems[i] = CommunityProblem.LACK_OF_BASIC_FOOD;
            
        }
        Community community = new Community(name, communityType, representative, communityProblems, population);
        // Add the community to the biodiverse place
        BiodiversePlace biodiversePlace = searchBiodiversePlace(biodiversePlaceName);
        if (biodiversePlace == null) {
            message = "No se puede agregar la comunidad, el lugar biodiverso no existe";
        } else {
            message = biodiversePlace.addCaretakerCommunity(community);
        }
        message = "La comunidad ha sido agregada exitosamente en el sistema";
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
