package model;

public class Route {
    private String name;
    private String address;
    private String startTime;
    private String endTime;
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
    
}
