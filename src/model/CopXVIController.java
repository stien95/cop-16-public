package model;

/**
 * The CopXVIController class represents a controller for managing routes in the COP XVI system.
 */
public class CopXVIController {
    // atributos
    private String sponsor;
    private String country;
    // relaciones
    private Route[] routes;
    
    /**
     * Constructor method.
     * @param sponsor the sponsor of the COP XVI system
     * @param country the country of the COP XVI system
     * <b>pre:</b> The parameters must not be null. <br>
     * <b>post:</b> The attributes of the class are initialized. <br>
     */
    public CopXVIController(String sponsor, String country) {
        this.sponsor = sponsor;
        this.country = country;
        routes = new Route[5];
        addRoutesDefault();
    }
    
    /**
     * Add default routes to the controller.
     * <b>post:</b> The routes are added to the controller. <br>
     */
    public void addRoutesDefault() {
        routes[0] = new Route("Ruta 1", "Calle 1", "10:00 am", "12:00 pm");
        routes[1] = new Route("Ruta 2", "Calle 2", "11:00 am", "1:00 pm");
        routes[2] = new Route("Ruta 3", "Calle 3", "12:00 pm", "2:00 pm");
    }
    
    /**
     * Show the routes of the controller.
     * @return A message with the routes of the controller.
     * <b>post:</b> The routes of the controller are shown. <br>
     */
    public String showRoutes() {
        String message = "";
        for (int i = 0; i < routes.length; i++) {
            if (routes[i] != null) {
                String nameMsg =        "   Nombre: " + routes[i].getName();
                String addressMsg =     "   Dirección de punto de encuentro: " + routes[i].getAddress();
                String startTimeMsg =   "   Hora de inicio: " + routes[i].getStartTime();
                String endTimeMsg =     "   Hora de fin: " + routes[i].getEndTime();
                message = message + "Ruta " + (i + 1) + ":\n" + nameMsg + "\n" + addressMsg + "\n" + startTimeMsg + "\n" + endTimeMsg + "\n";
            }
        }
        return message;
    }
    
    /**
     * Add a route to the controller.
     * @param name The name of the route.
     * @param address The address of the meeting point.
     * @param startTime The start time of the route.
     * @param endTime The end time of the route.
     * @return A message with the result of the operation.
     * <b>post:</b> The route is added to the controller.<br>
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
        if (added) message = "La ruta ha sido agregada exitosamente en el sistema";
        else message = "No se puede agregar la ruta, el sistema está lleno";
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
