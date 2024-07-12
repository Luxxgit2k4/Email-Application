# Email-Application


## Overview

### This Java project is a simple email generation system for a company. This project handles the exceptions well and it uses regex for strict email validation. It creates an email for a new worker based on their first name, last name, and chosen department and then at last prints the worker's info.

#### 1. Generate an email in the format `firstnamelastname.department@company.com` with the worker's username given as an input.
#### 2. Determine the department of the worker and exit the program if it is none.
#### 3. Enter the worker's alternate email address:
   #### Regex is used to validate the email so read the following guidelnes for the email validation

   ```
           * Numeric values from 0 to 9 are allowed
           * Both uppercase and lowercase letters from a to z are allowed.
           * Allowed are underscore “_”, hyphen “-“, and dot “.”
           * Dot isn’t allowed at the start and end of the local part.
           * Consecutive dots aren’t allowed.
           * For the local part, a maximum of 64 characters are allowed

              #### If you don't want an alternate email simply press enter
               hence it prints alternate email as `null`
   ```
           
   
  #### If you don't want an alternate email simply press enter hence it prints alternate email as `null`

#### 5. Generate a random password
#### 6. Have get and set methods to change and display the alternate email, password and mailbox capacity if necessary
#### 7. At last print the workers details with their name, email address , alternate email and mailbox capacity.*

## Features

- **Email Generation:** Creates a company email address based on the employee's first name, last name, and department.
- **Password Generation:** Generates a random password for the employee.
- **Alternate Email:** Allows entering an alternate email address and validates it using regex, the email should be like this for example `worker1234@gmail.com` 
- **Set Mailbox Capacity and new password:** Allows setting the mailbox capacity and new password.
- **Display Employee Information:** Prints the employee's information, including their company email and mailbox capacity.

## How to Use

1. Clone the Repository:

```
git clone https://github.com/Luxxgit2k4/Email-Application.git
```
2. Compile the code:
 ```
 javac Main.java
```
3. Run the application:
```
java Main
```
4. Follow the prompts: 
- Enter the worker's first name and last name.
- Select a department from the available options.
- Enter the worker's alternate email address
  

  #### NOTE: Enter valid email address because regex is used
   for validation refer the overview for details
  
- Optionally, set a new password and mailbox capacity.

## Contributing

Contributions are welcome! Please fork this repository and submit a pull request for any enhancements or bug fixes.

## License

This project is open-source and available under the [MIT License](https://opensource.org/license/mit)
