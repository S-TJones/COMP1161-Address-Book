import java.util.ArrayList;

public class UserContact {
    // Attributes
    private String firstName, lastName, nickName;
    private ArrayList<String> address;
    private ArrayList<String> emails;
    private ArrayList<String> phoneNumber;
    private int contactID;
    public static int contactCount;

    // Constructor
    public UserContact() {
        contactCount++;
        this.contactID = contactCount;
    }

    public UserContact(String fName, String lName, ArrayList<String> phone) {
        contactCount++;
        this.contactID = contactCount;
        this.firstName = fName;
        this.lastName = lName;
        this.phoneNumber = phone;
    }

    // Methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public int getContactID() {
        return contactID;
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public String getNickName() {
        return nickName;
    }

    public ArrayList<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public static void setContactCount(int contactCount) {
        UserContact.contactCount = contactCount;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public void setPhoneNumber(ArrayList<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addEmail(String newEmail) {
        this.emails.add(newEmail);
    }

    public void addPhoneNumber(String newNumber) {
        this.phoneNumber.add(newNumber);
    }

    public String getEmailsString() {
        String allEmails = "";

        for (String string : this.emails) {
            allEmails = allEmails + string + ";";
        }

        return allEmails;
    }

    public String getAddressString() {
        String fullAddress = "";

        for (String string : this.address) {
            fullAddress = fullAddress + string + ";";
        }

        return fullAddress;
    }

    public String getPhoneString() {
        String phoneNumbers = "";

        for (String string : this.phoneNumber) {
            phoneNumbers = phoneNumbers + string + ";";
        }

        return phoneNumbers;
    }

    @Override
    public String toString() {
        String repr = getContactID() + ":" + getFirstName() + " " + getLastName() + ":";
        repr = repr + getEmailsString() + ":" + getPhoneString() + ":" + getAddressString();

        return repr;
    }

    public String displayString() {
        String display = "";

        display += "|Name: " + getFirstName() + " " + getLastName() + "\n";

        if (this.phoneNumber.size() == 1) {
            display += "|Phone: " + phoneNumber.get(0);
        } else {
            display += "|Phone: ";
            for (String string : phoneNumber) {
                display += string + ", ";
            }
        }

        if (this.address.size() == 0) {
            display += "|Address: No Address added.";
        } else {
            display += "|Address:\n|";
            for (String string : address) {
                display += string + "\n|";
            }
        }

        if (this.emails.size() == 0) {
            display += "|Email: No Emails added.";
        } else {
            display += "|Email:\n|";
            for (String string : address) {
                display += string + "\n|";
            }
        }

        return display;
    }
}
