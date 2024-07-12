import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Main {
    public static void main(String[] args) {
        Scanner koomar = new Scanner(System.in);
        String firstName, lastName;
        // Enter the worker's first name
        while (true) {
            System.out.print("Enter your first name: ");
            firstName = koomar.nextLine();
            if (checkforNumber(firstName)) { // calling the method from boolean validation for firstname
                System.out.println("Warning!! : Name should not contain number\n Please enter again.");
            } else {
                break;
            }
        }
        // Enter the worker's last name
        while (true) {
            System.out.print("Enter your last name: ");
            lastName = koomar.nextLine();
            if (checkforNumber(lastName)) {// calling the method from boolean validation for lastname
                System.out.println("Warning!! : Name should not contain number\n Please enter again.");
            } else {
                break;
            }
        }
        // Create an Email object with first and last names
        Email obj1 = new Email(firstName, lastName);
        // obj1.setChangepassword(""); //Use this to set a new password and print it
        // obj1.getBoxCapacity(); //Use this to set a new mail box capacity
        //System.out.println("Alternate Email is " +obj1.getAlternateemail());

        obj1.printinfo(); //calling the printinfo method to display the worker's details
    }
    /* Boolean validation for checking the presence of number
    in firstname and lastname*/
    private static boolean checkforNumber(String str) { //creates a string named str for the
        for (char c : str.toCharArray()) { // converting the string str into array
            if (Character.isDigit(c)) { //looping through the converted array to check presence of number
                return true; // if true it goes to the while loop
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
        email = firstname.toLowerCase(Locale.ROOT) + lastname.toLowerCase() + "." + department + "@" + companysite;
        System.out.println("Your email is " + email);

        // calling the method to input alternateemail and check the validity using regex
        setAlternateemail();
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
                    System.out.println("INVALID INPUT!\nDepartment code doesn't exist");// Default case to handle unexpected input
                    continue; // Continues to the loop if the input given increases
            }
        } catch (InputMismatchException e) {
            System.out.println("Error!! : Enter a number"); //checks for string input exception
            bupd.next(); //discards the input if string is given
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
    public void setAlternateemail() { // Set method to have an alternate email
        // Using regex to validate email
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Scanner luxx = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an alternate email address: ");
            String altemail = luxx.nextLine();
            // Define the regex pattern for email validation
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(altemail);
            if (matcher.matches()) { // Check if the alternate email matches the regex pattern
                this.alternateEmail = altemail;
                break; // Exit the loop if the email format is valid
            } else if (altemail == "") { // This is used if you dont want to give an alternate mail
                System.out.println("null");
                break; // Exit the loop and prints null when printinfo() is called
            } else {
                System.out.println("Invalid email format. Please enter a valid email address.");
            }
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
