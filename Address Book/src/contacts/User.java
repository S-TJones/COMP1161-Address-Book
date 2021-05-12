public class User {
    // Attributes
    private String firstName, lastName, userName;
    private String password = "None";
    private int userID;
    public static int count;
    private static String format = "FL";

    // Constructors
    public User() {
        this.userID = count++;
    }

    public User(String fName, String lName, String pass) {
        this.userID = count++;
        this.firstName = fName;
        this.lastName = lName;
        this.password = pass;
    }

    public User(String fName, String lName, String uName, String pass) {
        this.userID = count++;
        this.firstName = fName;
        this.lastName = lName;
        this.userName = uName;
        this.password = pass;
    }

    // Methods
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        String fullName;

        if (format.equals("FL")) {
            fullName = getFirstName() + " " + getLastName();
        } else {
            fullName = getLastName() + ", " + getFirstName();
        }

        return fullName;
    }

    public int getID() {
        return this.userID;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserPassword() {
        return this.password;
    }

    public void setCounter(int number) {
        count = number;
    }

    public void changeFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public void changeLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public void changeUserName(String newUserName) {
        this.userName = newUserName;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public String toString() {
        String repr = getID() + ":" + getFullName() + ":" + getUserName() + ":" + getUserPassword();
        return repr;
    }

}
