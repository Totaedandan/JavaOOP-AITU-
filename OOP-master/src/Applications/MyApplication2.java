package Applications;

import CarStore.Car;
import controrllers.CarController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyApplication2 {

    private  final CarController carController;

    private  final Scanner scanner;
    public  static List<Car> cars =  new ArrayList<>();


    public  MyApplication2 (CarController carController){
        this.carController = carController;
        scanner = new Scanner(System.in);
    }
    public static  void addForCar (Car car){
        cars.add(car);
    }
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Admin Operations");
            System.out.println("Select option:");
            System.out.println("1. Get all Cars");
            System.out.println("2. Get car by id");
            System.out.println("3. Create CarMenu");
            System.out.println("4. Insert CarMenu");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                switch (option){
                    case 1:getAllCarMenu();break;
                    case 2:getCarByIdMenu();break;
                    case 3:createCarMenu();break;
                    case 4:insertCarMenu();break;
                    default: return;
                }

            }catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("--------------------------");

        }
    }
    public  void getAllCarMenu(){
        String response = carController.getAllCarController();
        System.out.println(response);
    }
    public  void getCarByIdMenu(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = carController.getCarByIdController(id);
        System.out.println(response);
    }
    public void createCarMenu(){
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter mileage");
        int mileage = scanner.nextInt();
        System.out.print("Enter date (yyyy-MM-dd): ");
        String release_date = scanner.next();
        LocalDate date = LocalDate.parse(release_date, DateTimeFormatter.ISO_DATE);
        System.out.println("Please enter price");
        double price = scanner.nextDouble();

        String response = carController.createCarByController(name , mileage ,  date , price);
        System.out.println(response);
    }
    public void  insertCarMenu(){
        for (Car c:  cars){
            String response = carController.insertCarController(c.getName(), c.getMileage() , c.getReleaseDate() , c.getPrice());
            System.out.println(response);
        }
    }
}
