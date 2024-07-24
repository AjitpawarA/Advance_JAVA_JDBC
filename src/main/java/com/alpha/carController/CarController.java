package com.alpha.carController;

import java.util.List;
import java.util.Scanner;

import com.alpha.carDao.CarDao;
import com.alpha.carDto.Car;

public class CarController {
    public static Scanner sc = new Scanner(System.in);
    static CarDao carDao = new CarDao();

    public static void createCar() {
        System.out.println("Enter Car ID:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Car Name:");
        String name = sc.nextLine();
        System.out.println("Enter Car Brand:");
        String brand = sc.nextLine();
        System.out.println("Enter Car Cost:");
        int cost = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Car Manufacturing Year:");
        int manufactYear = sc.nextInt();

        Car car = new Car(id, name, brand, cost, manufactYear);
        Car carToBeSaved = carDao.saveCar(car);
        if (carToBeSaved != null) {
            System.out.println("Car saved to the CarDB");
        }
    }

    public static void updateCar() {
        System.out.println("Enter Car ID to update:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new Car Name:");
        String name = sc.nextLine();
        System.out.println("Enter new Car Brand:");
        String brand = sc.nextLine();
        System.out.println("Enter new Car Cost:");
        int cost = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new Car Manufacturing Year:");
        int manufactYear = sc.nextInt();

        Car car = new Car(id, name, brand, cost, manufactYear);
        Car updatedCar = carDao.updateCar(car);
        if (updatedCar != null) {
            System.out.println("Car updated in the CarDB");
        }
    }

    public static void findCarByID() {
        System.out.println("Enter Car ID to find:");
        int id = sc.nextInt();
        Car car = carDao.getCarById(id);
        if (car != null) {
            System.out.println("Car ID: " + car.getId());
            System.out.println("Car Name: " + car.getName());
            System.out.println("Car Brand: " + car.getBrand());
            System.out.println("Car Cost: " + car.getCost());
            System.out.println("Car Manufacturing Year: " + car.getManufact_year());
        } else {
            System.out.println("Car not found with ID: " + id);
        }
    }

    public static void displayAllCars() {
        List<Car> cars = carDao.getAllCars();
        if (cars != null && !cars.isEmpty()) {
            for (Car car : cars) {
                System.out.println("Car ID: " + car.getId());
                System.out.println("Car Name: " + car.getName());
                System.out.println("Car Brand: " + car.getBrand());
                System.out.println("Car Cost: " + car.getCost());
                System.out.println("Car Manufacturing Year: " + car.getManufact_year());
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("No cars found in the CarDB");
        }
    }

    public static void deleteCarByID() {
        System.out.println("Enter Car ID to delete:");
        int id = sc.nextInt();
        boolean isDeleted = carDao.deleteCar(id);
        if (isDeleted) {
            System.out.println("Car deleted from the CarDB");
        } else {
            System.out.println("Car not found with ID: " + id);
        }
    }

    public static void main(String[] args) {

        System.out.println("---Welcome to Car Rental System---");
        boolean exit = true;

        while (exit) {
            System.out.println("---Choose Correct option---");
            System.out.println("1: Save car");
            System.out.println("2: Update car");
            System.out.println("3: Find car by ID");
            System.out.println("4: Display all cars");
            System.out.println("5: Delete car by ID");
            System.out.println("0: Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createCar();
                    break;
                case 2:
                    updateCar();
                    break;
                case 3:
                    findCarByID();
                    break;
                case 4:
                    displayAllCars();
                    break;
                case 5:
                    deleteCarByID();
                    break;
                case 0: {
                    exit = false;
                    System.out.println("Thank you for using Car Rental System");
                }
                break;
                default: {
                    System.out.println("Wrong input, please choose a correct option");
                }
            }
        }
    }
}
