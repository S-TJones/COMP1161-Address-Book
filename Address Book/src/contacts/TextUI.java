import java.util.Scanner;

public class TextUI {
    // Attributes
    private Scanner sc = new Scanner(System.in);
    private Manager controller;

    // Constructor
    public TextUI() {
        this.controller = new Manager();
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
        // TODO
    }
}
