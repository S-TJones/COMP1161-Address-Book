import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Manager {
    // Attributes
    private String contactFileName = "contact.txt";
    private String usersFileName = "name&pass.txt";
    private ArrayList<User> currentUsers = new ArrayList<User>();
    private ArrayList<UserContact> currentContacts = new ArrayList<UserContact>();

    // Constructor
    public Manager() {
    }

    // Methods
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

    public void getUsersFile(String userFileName) {
    }

    public ArrayList<UserContact> getContacts() {

        return this.currentContacts;
    }

    public void getContactsFile(String contactFileName) {
        boolean exists = fileCheck(contactFileName);

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
            System.out.println("* Contact File is empty.");
        }
    }
}
