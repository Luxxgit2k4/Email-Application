import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner koomar = new Scanner(System.in);
        String firstName, lastName;
        // Enter the worker's first name
        while (true) {
            System.out.print("Enter your first name: ");
            firstName = koomar.nextLine();
            if (checkforNumber(firstName)) {
                System.out.println("Warning: Name should not contain numbers. Please enter again.");
            } else {
                break;
            }
        }

        // Enter the worker's last name
        while (true) {
            System.out.print("Enter your last name: ");
            lastName = koomar.nextLine();
            if (checkforNumber(lastName)) {
                System.out.println("Warning: Name should not contain numbers. Please enter again.");
            } else {
                break;
            }
        }

        // Create an Email object with first and last names
        Email obj1 = new Email(firstName, lastName);

        /* Enter the worker's alternate email address with @ in it
        otherwise it returns invalid format and prints null in the
        ALTERNATE EMAIL when the printinfo() method is called */

        System.out.print("Enter an alternate email address: ");
        String alternateEmail = koomar.nextLine();
        obj1.setAlternateemail(alternateEmail);

        // obj1.setChangepassword(""); //Use this to set a new password and print it
        // obj1.getBoxCapacity(); //Use this to set a new mail box capacity
        //System.out.println("Alternate Email is " +obj1.getAlternateemail());

        obj1.printinfo(); //calling the printinfo method to display the worker's details
    }
    private static boolean checkforNumber(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
class Email {
    // The strings are encapsulated to hide some information
    private String firstname, lastname;
    private String password, department, alternateEmail;
    private int boxCapacity = 200;
    private String email;
    private String companysite = "kumartraders.com";

    /* Constructor to take firstname and lastname as parameter */
    public Email(String firstname, String lastname) {
        /* this keyword is used to avoid confusion between class attributes and parameters here
           this is used to say the parameter passed is equal to the attribute in email class */
        this.firstname = firstname;
        this.lastname = lastname;
        //System.out.println("Your Email is created: " + this.firstname + " " + this.lastname);

        // Calling the method to show the available departments and input one
        this.department = setDepartment();
        /* If user selects none the system exits as there is no need to print email
        for a none department */
        if (this.department == "") {
            System.out.println("Email not created......exiting");
            System.exit(0);
        }
        System.out.println("Department: " + this.department);

        // Calling the method to generate and print a random password for a given length
        this.password = generatePassword(10); // Generating a random password of length 10
        System.out.println("Your Password is: " + this.password);

        /* Printing the worker's email with department and company address
        Note: The email printed here should consist of lowercase letters
         */
        email = firstname.toLowerCase(Locale.ROOT) + "." + lastname.toLowerCase() + "@" + department + "." + companysite;
        System.out.println("Your email is " + email);
    }

    private String setDepartment() {

        // Displaying the available departments
        Scanner bupd = new Scanner(System.in);
        while (true) {
            System.out.println("New worker: " + firstname + " " + lastname + "\nSELECT YOUR DEPARTMENT\n1 Manufacturing\n2 Production\n3 Sales\n4 Inspection\n5 None");
        /* Taking user input for desired department and using switch case to display it */
        try {
            int choice = bupd.nextInt();
            switch (choice) {
                case 1:
                    return "Manufacturing";
                case 2:
                    return "Production";
                case 3:
                    return "Sales";
                case 4:
                    return "Inspection";
                case 5:
                    return "";
                default:
                    return "Unexpected input"; // Default case to handle unexpected input
            }
        } catch (InputMismatchException e) {
            System.out.println(" INVALID INPUT !! Enter a number");
            bupd.next();
        }
        }
    }
    //Method to generate a random password
    private String generatePassword(int length) {
        String setPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * setPassword.length());
            password[i] = setPassword.charAt(random);
        }
        return new String(password);
    }

    /*Using get and set method to change and update mailboxcapacity,
    alternateemail and password if you're interested
     */
    public void setBoxCapacity(int capacity){ // Set method to change mail box capacity
        this.boxCapacity = capacity;
    }
    public void setAlternateemail(String altemail) {// Set method to have a alternate email
        if (altemail.contains("@")) { // The entered alternate email should consist of @ in it.
            this.alternateEmail = altemail;
        } else {
            System.out.println("Invalid format");
        }
    }
    public void setChangepassword(String passwd){ //Set method to change the password
        this.password = passwd;
    }
    public int getBoxCapacity() { // Get method to store the new mail box capacity
        return boxCapacity;
    }
    public String getAlternateemail() { // Get method to store the aternate email
        return alternateEmail;
    }
    public String getChangepassword() { // Get method to store the new password
        return password;
    }
    // Printing the workers details:
    public void printinfo() {
        System.out.println("WORKER NAME: " + firstname + " " + lastname);
        System.out.println("COMPANY EMAIL: " + email);
        System.out.println("ALTERNATE EMAIL: " +alternateEmail);
        System.out.println("MAILBOX CAPACITY: " + boxCapacity + "mb");
    }
}
