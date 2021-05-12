import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    // Attributes
    private Scanner sc = new Scanner(System.in);
    private Manager controller;

    // Constructor
    public TextUI() {
        this.controller = new Manager();
        this.controller.updateContacts();
        this.controller.updateUsers();
    }

    // Methods
    public void welcome() {
        System.out.println("*******************************");
        System.out.println("* Welcome");
        System.out.println("*******************************");
        enter();
    }

    public void goodbye() {
        System.out.println("*******************************");
        System.out.println("* GOODBYE");
        System.out.println("*******************************");
        this.sc.close();
    }

    public void enter() {
        System.out.println("*******************************");
        System.out.println("* Would you like to:");
        System.out.println("* 1 - Login");
        System.out.println("* 2 - Sign Up");
        System.out.println("* 0 - Exit");
        System.out.println("*******************************");

        String userOption = this.sc.nextLine().trim();

        switch (userOption) {
            case "1":
                logIn();
                break;

            case "2":
                signUp();
                break;

            case "0":
                save();
                break;

            default:
                enter();
                break;
        }
    }

    public void save() {

        System.out.println("\n* Would you like to save this changes?");
        System.out.println("* Enter 1 for \'YES\'\n* Enter 2 for \'NO\'");
        int save = sc.nextInt();

        switch (save) {
            case 1:
                this.controller.updateContactFile();
                this.controller.updateUserFile();
                break;

            case 2:
                System.out.println("\n* Thank you for using.");
                break;

            default:
                System.out.println("\n* Not a valid option.\n* The program will end without saving as default.");
                break;
        }
    }

    public String checkForUser(String name) {
        String found = "false";
        ArrayList<User> users = this.controller.getUsers();

        for (User user : users) {
            String currentName = user.getUserName();

            if (name.equals(currentName)) {
                return user.getUserPassword();
            }
        }

        return found;
    }

    public void logIn() {
        int maxTry = 3;
        int currentTry = 0;

        while (currentTry < maxTry) {
            System.out.println("* Enter your User Name: ");
            String userName = this.sc.nextLine().trim().toLowerCase();

            String pass = checkForUser(userName);
            if (pass.equals("false")) {
                System.out.println("* This User Name \'" + userName + "\' does not exist.");
                System.out.println("* You have \'" + (maxTry - (currentTry + 1)) + "\' remaining.");
            } else {
                System.out.println("* Enter your Password: ");
                String userPassword = this.sc.nextLine().trim().toLowerCase();

                if (pass.equals(userPassword)) {
                    options();
                    break;
                } else {
                    System.out.println("* The password entered is incorrect.");
                    System.out.println("* You have \'" + (maxTry - (currentTry + 1)) + "\' remaining.");
                }
            }

            currentTry++;
        }

        enter();
    }

    public void signUp() {
        System.out.println("*******************************");
        System.out.println("* SIGNUP");
        System.out.println("*******************************");

        System.out.println("* Enter your First Name:");
        String fName = this.sc.nextLine().trim().toLowerCase();

        System.out.println("* Enter your Last Name:");
        String lName = this.sc.nextLine().trim().toLowerCase();

        System.out.println("* Enter your User-Name:");
        String uName = this.sc.nextLine().trim().toLowerCase();

        System.out.println("* Enter your Password:");
        String password = this.sc.nextLine().trim();

        User user = new User(fName, lName, uName, password);

        this.controller.addUser(user);

        System.out.println("*******************************");
        System.out.println("* New User \'" + uName + "\' added successfully.");
        System.out.println("*******************************");

        enter();
    }

    public void options() {
        System.out.println("Options Coming soon.");
    }
}
