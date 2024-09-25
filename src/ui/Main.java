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
    public static void addDepartment() {
        System.out.print("Ingrese el nombre del departamento: ");
        String name = sc.nextLine();
        String msg = copXVIController.addDepartment(name);
        System.out.println(msg);
    }
    public static void addBiodiversePlace() {
        System.out.print("Ingrese el nombre del lugar biodiverso: ");
        String name = sc.nextLine();
        System.out.print("Ingrese el área del lugar biodiverso en km2: ");
        double area = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese el diretorio de la foto del lugar biodiverso (imagenes/foto1.jpg): ");
        String photo = sc.nextLine();
        System.out.print("Ingrese el número de día de la inaguración (DD): ");
        int inagurationDay = sc.nextInt();
        System.out.print("Ingrese el número de mes de la inaguración (MM): ");
        int inagurationMonth = sc.nextInt();
        System.out.print("Ingrese el número de año de la inaguración (AAAA): ");
        int inagurationYear = sc.nextInt();
        System.out.print("Ingrese el financiamiento requerido del lugar biodiverso en pesos: ");
        double requiredFunding = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese el nombre del departamento del lugar biodiverso: ");
        String departmentName = sc.nextLine();
        String msg = copXVIController.addBiodiversePlace(name, area, photo, inagurationDay, inagurationMonth, inagurationYear , requiredFunding, departmentName);
        System.out.println(msg);
    }
    public static void showBiodiversePlaces() {
        System.out.println(copXVIController.showBiodiversePlaces());
    }
    public static void printMenu() {
        System.out.println("-------------MENÚ-------------");
        System.out.println("1. Agregar ruta");
        System.out.println("2. Mostrar rutas");
        System.out.println("3. Agregar departamento");
        System.out.println("4. Agregar lugar biodiverso");
        System.out.println("5. Para consultar los lugares ordenados de menor a mayor con respecto al área");
        System.out.println("6. Para consultar el departamento con que tiene más lugares con diversidad biológica registrados hasta el momento");
        System.out.println("6. Salir");
        System.out.print("Ingrese la opción deseada: ");
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        makeController();
        while (true) {
            printMenu();
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    addRoute();
                    break;
                case 2:
                    System.out.println(copXVIController.showRoutes());
                    break;
                case 3:
                    addDepartment();
                    break;
                case 4:
                    addBiodiversePlace();
                    break;
                case 5:
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
