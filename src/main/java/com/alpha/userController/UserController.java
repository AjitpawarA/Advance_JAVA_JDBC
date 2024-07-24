package com.alpha.userController;

import java.util.List;
import java.util.Scanner;

import com.alpha.userDao.UserDao;
import com.alpha.userDto.User;

public class UserController {
    public static Scanner sc = new Scanner(System.in);
    static UserDao userDao = new UserDao();

    public static void createUser() {
        System.out.println("Enter User ID:");
        int userId = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter User Name:");
        String userName = sc.nextLine();
        System.out.println("Enter User Email:");
        String userEmail = sc.nextLine();
        System.out.println("Enter User Password:");
        String passward = sc.nextLine();
        System.out.println("Enter User Phone Number:");
        String phoneNo = sc.nextLine();

        User user = new User(userId, userName, userEmail, passward, phoneNo);
        User userToBeSaved = userDao.saveUser(user);
        if (userToBeSaved != null) {
            System.out.println("User saved to the UserDB");
        }
    }

    public static void updateUser() {
        System.out.println("Enter User ID to update:");
        int userId = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter new User Name:");
        String userName = sc.nextLine();
        System.out.println("Enter new User Email:");
        String userEmail = sc.nextLine();
        System.out.println("Enter new User Password:");
        String passward = sc.nextLine();
        System.out.println("Enter new User Phone Number:");
        String phoneNo = sc.nextLine();

        User user = new User(userId, userName, userEmail, passward, phoneNo);
        User updatedUser = userDao.updateUser(user);
        if (updatedUser != null) {
            System.out.println("User updated in the UserDB");
        }
    }

    public static void findUserByID() {
        System.out.println("Enter User ID to find:");
        int userId = sc.nextInt();
        User user = userDao.getUserById(userId);
        if (user != null) {
            System.out.println("User ID: " + user.getUserId());
            System.out.println("User Name: " + user.getUserName());
            System.out.println("User Email: " + user.getUserEmail());
            System.out.println("User Password: " + user.getPassward());
            System.out.println("User Phone Number: " + user.getPhoneNo());
        } else {
            System.out.println("User not found with ID: " + userId);
        }
    }

    public static void displayAllUsers() {
        List<User> users = userDao.getAllUsers();
        if (users != null && !users.isEmpty()) {
            for (User user : users) {
                System.out.println("User ID: " + user.getUserId());
                System.out.println("User Name: " + user.getUserName());
                System.out.println("User Email: " + user.getUserEmail());
                System.out.println("User Password: " + user.getPassward());
                System.out.println("User Phone Number: " + user.getPhoneNo());
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("No users found in the UserDB");
        }
    }

    public static void deleteUserByID() {
        System.out.println("Enter User ID to delete:");
        int userId = sc.nextInt();
        boolean isDeleted = userDao.deleteUser(userId);
        if (isDeleted) {
            System.out.println("User deleted from the UserDB");
        } else {
            System.out.println("User not found with ID: " + userId);
        }
    }

    public static void main(String[] args) {

        System.out.println("---Welcome to User Management System---");
        boolean exit = true;

        while (exit) {
            System.out.println("---Choose an option---");
            System.out.println("1: Save user");
            System.out.println("2: Update user");
            System.out.println("3: Find user by ID");
            System.out.println("4: Display all users");
            System.out.println("5: Delete user by ID");
            System.out.println("0: Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    findUserByID();
                    break;
                case 4:
                    displayAllUsers();
                    break;
                case 5:
                    deleteUserByID();
                    break;
                case 0: {
                    exit = false;
                    System.out.println("Thank you for using User Management System");
                }
                break;
                default: {
                    System.out.println("Wrong input, please choose a correct option");
                }
            }
        }
    }
}
