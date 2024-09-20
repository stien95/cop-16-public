package ui;

import java.util.Scanner;

import model.CopXVIController;

public class Main {
    public static CopXVIController copXVIController;
    public static Scanner sc;
    /**
     * Add a route to the controller and show a message
     * with the result of the operation.
     * <b>pre:</b> The controller must be initialized. <br>
     * <b>post:</b> The route is added to the controller. <br>
     */
    public static void addRoute() {
        System.out.print("Ingrese el nombre de la ruta: ");
        String name = sc.nextLine();
        System.out.print("Ingrese la dirección de punto de encuentro: ");
        String address = sc.nextLine();
        System.out.print("Ingrese la hora de inicio de la ruta (formato: HH:mm aa): ");
        String startTime = sc.nextLine();
        System.out.print("Ingrese la hora de fin de la ruta (formato: HH:mm aa): ");
        String endTime = sc.nextLine();
        String msg = copXVIController.addRoute(name, address, startTime, endTime);
        System.out.println(msg);
    }
    /**
     * Initialize the controller with the sponsor and country
     * entered by the user.
     * <b>pre:</b> The controller is null. <br>
     * <b>post:</b> The controller is initialized. <br>
     */
    public static void makeController() {
        System.out.print("Ingrese el nombre del patrocinador de la cop-16: ");
        String sponsor = sc.nextLine();
        System.out.print("Ingrese el país de la cop-16: ");
        String country = sc.nextLine();
        copXVIController = new CopXVIController(sponsor, country);
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        makeController();
        while (true) {
            System.out.println("-------------MENÚ-------------");
            System.out.println("1. Agregar ruta");
            System.out.println("2. Mostrar rutas");
            System.out.println("3. Salir");
            System.out.print("Ingrese la opción deseada: ");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    addRoute();
                    break;
                case 2:
                    System.out.println(copXVIController.showRoutes());
                    break;
                case 3:
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}