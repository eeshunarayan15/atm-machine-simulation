This is a simple ATM Machine Simulation implemented in Java. The program simulates basic ATM functionalities, such as:

Account Balance Inquiry
Cash Withdrawal
Cash Deposit
PIN Change
Transaction History
Features
Account Balance Inquiry: View the current balance in your account.
Cash Withdrawal: Withdraw cash from the account, ensuring there are sufficient funds.
Cash Deposit: Deposit cash into the account.
PIN Change: Change the account PIN.
Transaction History: View a record of all transactions, including deposits, withdrawals, and PIN changes.
Requirements
Java (Version 17 or higher recommended)
Setup and Running the Program
Prerequisites
Ensure you have Java installed on your system. You can download the latest version from the official Java website.

Steps to Run the Program:
Download the Code:
Download the ATM Machine Simulation code (or clone it if you are using a version control system).

Compile the Code:
Open a terminal or command prompt and navigate to the folder where the Java files are located. Then, compile the Java program using the following command:

bash
Copy code
javac ATMSimulation.java
This will compile the Java code and generate a .class file.

Run the Program:
After compiling, you can run the program using the command:

bash
Copy code
java ATMSimulation
Test the Program:

The default PIN is 1234. You can use this PIN to log in.
Once logged in, you can access various ATM features via the menu.
Example of input/output:

markdown
Copy code
Welcome to the ATM Machine!
Please enter your PIN: 1234

ATM Menu:
1. Check Balance
2. Deposit Cash
3. Withdraw Cash
4. Change PIN
5. View Transaction History
6. Exit
Please select an option: 1
Your current balance is: $1000.0
Modifying the Default PIN
If you'd like to change the default PIN, you can modify the following line in the ATMSimulation.java file:

java
Copy code
User currentUser = new User("1234", 1000.0); // Change PIN here
For example, if you'd like to change the PIN to 123456, modify it to:

java
Copy code
User currentUser = new User("123456", 1000.0); // New PIN is 123456
Available Operations:
Check Balance: View your current account balance.
Deposit Cash: Deposit an amount into the account.
Withdraw Cash: Withdraw an amount from the account, as long as there are sufficient funds.
Change PIN: Change your account PIN.
View Transaction History: View the history of all transactions made, including deposits, withdrawals, and PIN changes.
Example Interaction
bash
Copy code
Welcome to the ATM Machine!
Please enter your PIN: 1234

ATM Menu:
1. Check Balance
2. Deposit Cash
3. Withdraw Cash
4. Change PIN
5. View Transaction History
6. Exit
Please select an option: 1
Your current balance is: $1000.0

ATM Menu:
1. Check Balance
2. Deposit Cash
3. Withdraw Cash
4. Change PIN
5. View Transaction History
6. Exit
Please select an option: 2
Enter deposit amount: $500
Deposited: $500.0

ATM Menu:
1. Check Balance
2. Deposit Cash
3. Withdraw Cash
4. Change PIN
5. View Transaction History
6. Exit
Please select an option: 5
Transaction History:
Account created with balance: $1000.0
Deposited: $500.0
Code Overview
Main Class: ATMSimulation
The ATMSimulation class contains the main logic for the ATM machine simulation. It presents a menu to the user and handles authentication, transactions, and other operations.

User Class: User
The User class represents an individual bank account. It contains the user's PIN, balance, and a transaction history. It provides methods to:

Check balance
Deposit money
Withdraw money
Change PIN
Show transaction history
Validate PIN
Transaction History
Each transaction (deposit, withdrawal, PIN change) is logged in the transactionHistory list, allowing the user to review their activity.

Future Improvements
This project is a basic simulation, and there are several improvements and features that can be added, such as:

Multiple Accounts: Support for multiple users with different balances and PINs.
Transfer Between Accounts: Allow users to transfer money between accounts.
Error Handling: More comprehensive error checking (e.g., for invalid inputs).
User Interface: Create a GUI for better user interaction.
Security: Implement encryption for storing and validating PINs.
