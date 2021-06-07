import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Manager {
    // Attributes
    private String contactFileName = "contacts.txt";
    private String usersFileName = "login.txt";
    private ArrayList<User> currentUsers = new ArrayList<User>();
    private ArrayList<UserContact> currentContacts = new ArrayList<UserContact>();

    // Constructor
    public Manager() {
    }

    // Methods
    public void addUser(User newUser) {
        this.currentUsers.add(newUser);
    }

    public void addContact(UserContact newContact) {
        this.currentContacts.add(newContact);
    }

    public boolean fileCheck(String fileName) {

        File file = new File(fileName);

        try {
            // Check if it exists
            if (!file.exists()) {
                file.createNewFile(); // Creates the file
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return this.currentUsers;
    }

    public void updateUsers() {
        boolean exists = fileCheck(this.usersFileName);

        if (exists) {
            try {
                File file = new File(this.usersFileName);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                int max = -1;

                while ((line = br.readLine()) != null) {
                    String[] inputLineArray = line.split(":");

                    String id = inputLineArray[0];
                    int userID = Integer.parseInt(id);
                    if (userID >= max) {
                        max = userID;
                    }

                    String fullName = inputLineArray[1];
                    String[] name = fullName.split(" ");

                    String userName = inputLineArray[2];

                    String password = inputLineArray[3];

                    User user = new User(name[0], name[1], password);
                    user.changeUserName(userName);

                    currentUsers.add(user);
                }

                User.count = max;
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("| WARNING: User File is empty.");
        }
    }

    public ArrayList<UserContact> getContacts() {
        return this.currentContacts;
    }

    public void updateContacts() {
        boolean exists = fileCheck(this.contactFileName);

        if (exists) {
            try {
                File file = new File(contactFileName);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                int max = -1;

                while ((line = br.readLine()) != null) {
                    String[] inputLineArray = line.split(":");
                    String id = inputLineArray[0];
                    int userID = Integer.parseInt(id);
                    if (userID >= max) {
                        max = userID;
                    }

                    String fullName = inputLineArray[1];
                    String[] name = fullName.split(" ");

                    String email = inputLineArray[2];
                    String[] userEmails = email.split(";");
                    ArrayList<String> emails = new ArrayList<String>(Arrays.asList(userEmails));

                    String phone = inputLineArray[3];
                    String[] userPhones = phone.split(";");
                    ArrayList<String> phoneNumbers = new ArrayList<String>(Arrays.asList(userPhones));

                    String address = inputLineArray[4];
                    String[] userAddress = address.split(";");
                    ArrayList<String> addresses = new ArrayList<String>(Arrays.asList(userAddress));

                    UserContact uc = new UserContact(name[0], name[1], phoneNumbers);
                    uc.setAddress(addresses);
                    uc.setEmails(emails);

                    currentContacts.add(uc);
                }

                UserContact.contactCount = max;
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("| WARNING: Contact File is empty.");
        }
    }

    public void updateUserFile() {
        try {
            FileWriter fileWriter = new FileWriter(this.usersFileName);

            String output = "";
            for (User user : currentUsers) {
                output += user.toString() + "\n";
            }

            fileWriter.write(output);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("* An error occured.");
            e.printStackTrace();
        }
    }

    public void updateContactFile() {
        try {
            FileWriter fileWriter = new FileWriter(this.contactFileName);

            String output = "";
            for (UserContact userContact : currentContacts) {
                output += userContact.toString() + "\n";
            }

            fileWriter.write(output);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("* An error occured.");
            e.printStackTrace();
        }
    }

    public int findContact(String firstName, String lastName, ArrayList<UserContact> allContacts) {
        String contactName = firstName + " " + lastName;
        int location = -1;

        if (allContacts == null || allContacts.size() == 0) {
            return location;
        }

        for (int i = 0; i < allContacts.size(); i++) {
            UserContact contact = allContacts.get(i);

            if (contact.getFullName().equals(contactName)) {
                location = i;
                break;
            }
        }

        return location;
    }

    public boolean removeContact(String fullName) {
        boolean removed = false;

        String[] name = fullName.split(" ");
        int location = findContact(name[0], name[1], this.currentContacts);

        if (location != -1) {
            this.currentContacts.remove(location);
            removed = true;
        }

        return removed;
    }
}
