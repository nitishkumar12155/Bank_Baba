import java.util.ArrayList;
import java.util.Scanner;

// CUSTOM EXCEPTIONS
class UnderAgeException extends Exception{
    public UnderAgeException(){
        super("Sorry!!, you are under age.");
    }
}
class OverAgeException extends Exception{
    public OverAgeException(){
        super("Sorry!!, you are over age.");
    }
}
class InvalidAmountException extends Exception{
    public InvalidAmountException(){
        super("Sorry, invalid amount.");
    }
}
class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(){
        super("Sorry, insufficient balance.");
    }
}
class AccountNotFoundException extends Exception{
    public AccountNotFoundException(){
        super("Sorry, account not found.");
    }
}

class Bank{
    private String bankName;
    private String headOffice;

    // Constructor
    Bank(){
        bankName = "State Bank of India";
        headOffice = "Mumbai, Maharashtra";
    }

    // Method
    public void display(){
        System.out.println("Welcome to " + bankName);
        System.out.println("Head Office: " + headOffice);
        System.out.println("\nYou Should choose from the list to continue the process:");
    }
}

class Branch extends Bank{
    private String branchName;
    private String branchCode;
    private String IFSC;

    // Arrays
    static String branchNames[]={"Bhubaneswar","Cuttack","Puri","Sambalpur","Rourkela"};
    static String branchCodes[]={"101","102","103","104","105"};
    static String IFSCCode[]={"SBIN000101","SBIN000102","SBIN000103","SBIN000104","SBIN000105"};

    // Constructor
    Branch(){
    }

    // Methods
    public void chooseBranch(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSelect Branch");
        for(int i = 1;i <= branchNames.length;i++){
            System.out.println((i)+". "+branchNames[i-1]);
        }
        System.out.print("Enter Choice : ");
        int choice = sc.nextInt();

        if(choice>=1 && choice<=5){
            branchName = branchNames[choice-1];
            branchCode = branchCodes[choice-1];
            IFSC = IFSCCode[choice-1];
            System.out.println("Branch Selected Successfully.");
        }
        else{
            System.out.println("Invalid Choice bro......");
        }
    }

    public void displayBranch(){
        System.out.println("Branch Name    : "+branchName);
        System.out.println("Branch Code    : "+branchCode);
        System.out.println("IFSC           : "+IFSC);
    }

    // Getters
    public String getBranchName(){
        return branchName;
    }

    public String getIFSC(){
        return IFSC;
    }
}

class Account extends Branch {
    Scanner sc = new Scanner(System.in);

    ArrayList<Account> accounts = new ArrayList<>();

    // Data Members 
    private int accountNo;
    private String name;
    private int age;
    private String gender;
    private String mobile;
    private String email;
    private String address;
    private String aadhar;
    private String pan;
    private double balance;

    // Constructor
    Account() {
        super();
        System.out.println("\nWelcome to Account Creation Process.");
    }

    // Constructor with parameters
    Account(int accountNo, String name, int age, String gender,
            String mobile, String email, String address,
            long aadhar, String pan, double balance) {
            this.accountNo = accountNo;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.mobile = mobile;
            this.email = email;
            this.address = address;
            this.aadhar = String.valueOf(aadhar);
            this.pan = pan;
            this.balance = balance;
        }

    // Getters and Setters
    public int getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAadhar() {
        return aadhar;
    }

    public String getPan() {
        return pan;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Methods
    public void createAccount(){
        System.out.println("Notes:");
        System.out.println("  Account Number should be 6 digits.");
        System.out.println("  A minimum opening balance of Rs. 500 is required to create a new account.");
        try {
            chooseBranch();
            int accNo;
            do {
                accNo = (int)(Math.random() * 900000) + 100000;
            } while (searchAccount(accNo) != null);

            System.out.println("\nGenerated Account Number : " + accNo);

            System.out.print("Enter Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Age : ");
            int age = sc.nextInt();
            sc.nextLine();
            if (age < 18)
                throw new UnderAgeException();
            if (age > 60)
                throw new OverAgeException();

            System.out.print("Enter Gender (Male/Female/Other) : ");
            String gender = sc.nextLine();
            if(!(gender.equalsIgnoreCase("Male") ||
                gender.equalsIgnoreCase("Female") ||
                gender.equalsIgnoreCase("Other")||
                gender.equalsIgnoreCase("M") ||
                gender.equalsIgnoreCase("F") ||
                gender.equalsIgnoreCase("O")))
            {
                throw new Exception();
            }

            String number = "+91-";
            for (int i = 0; i < 10; i++) {
            int num =(int) (Math.random() * 9 )+ 1;
            number += num;
            }
            System.out.println("Mobile Number: " + number);
            String Email;
            while (true) {
                System.out.print("Enter Email: ");
                Email = sc.nextLine();
                if (Email.contains("@") && Email.endsWith(".com")) {
                    System.out.println("Valid Email "+Email);
                    break;
                } else {
                    System.out.println("Invalid Email. Please enter a valid email address.");
                }
            }
            // System.out.println(Email);

            System.out.print("Enter Address : ");
            String address = sc.nextLine();

            long aadhar = (long)(Math.random() * 9) + 1;
            for (int i = 1; i < 12; i++) {
                int digit = (int)(Math.random() * 10);
                aadhar = aadhar * 10 + digit;
            }
            System.out.println("Aadhar Number: " + aadhar);


            String pan = "";
            for (int i = 0; i < 5; i++) {
                char ch = (char) ((Math.random() * 26) + 'A');
                pan += ch;
            }
            for (int i = 0; i < 4; i++) {
                int digit = (int) (Math.random() * 10);
                pan += digit;
            }
            char ch = (char) ((Math.random() * 26) + 'A');
            pan += ch;
            System.out.println("PAN Number: " + pan);

            System.out.print("Enter Opening Balance: ");
            double balance = sc.nextDouble();
            if (balance < 500) {
                throw new InvalidAmountException();
            }

            Account obj = new Account(accNo,name,age,gender,number,Email,address,aadhar,pan,balance);
            accounts.add(obj);

            System.out.println();
            System.out.println("Account Created Successfully.");
            System.out.println("Total Accounts : " + accounts.size());
        }

        catch (UnderAgeException e) {
            System.out.println(e.getMessage());
        }

        catch (OverAgeException e) {
            System.out.println(e.getMessage());
        }

        catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        catch (Exception e) {
            System.out.println("Invalid Input.");
        }

        System.out.println("Process Completed.\n");
    }

    public Account searchAccount(int accNo){
        for(Account acc : accounts){
            if(acc.getAccountNo() == accNo){
                return acc;
            }
        }
        return null;
    }

    public void displayAccount(){
        System.out.print("Enter Account Number : ");
        int accNo = sc.nextInt();
        Account acc = searchAccount(accNo);
        if(acc == null){
            System.out.println("Account Not Found.");
            return;
        }
        
        System.out.println();
        displayBranch();
        System.out.println("Account Number : "+acc.getAccountNo());
        System.out.println("Name           : "+acc.getName());
        System.out.println("Age            : "+acc.getAge());
        System.out.println("Gender         : "+acc.getGender());
        System.out.println("Mobile         : "+acc.getMobile());
        System.out.println("Email          : "+acc.getEmail());
        System.out.println("Address        : "+acc.getAddress());
        System.out.println("Aadhar         : "+acc.getAadhar());
        System.out.println("PAN            : "+acc.getPan());
        System.out.println("Balance        : "+acc.getBalance());
        System.out.println();
    }

    public void displayAllAccounts(){
        if(accounts.isEmpty()){
            System.out.println("No Account Found.");
            return;
        }

        System.out.println("\nACCOUNT LIST ");
        for(Account acc : accounts){
            displayBranch();
            System.out.println("Account No     : "+acc.getAccountNo());
            System.out.println("Name           : "+acc.getName() + "\n");
        }
        System.out.println("Total no of Accounts : "+accounts.size());
    }

    public void deposit() {
        try {
            System.out.print("Enter Account Number : ");
            int accNo = sc.nextInt();

            Account acc = searchAccount(accNo);
            if (acc == null)
                throw new AccountNotFoundException();

            System.out.print("Enter Amount : ");
            double amount = sc.nextDouble();
            if (amount <= 0)
                throw new InvalidAmountException();

            acc.setBalance(acc.getBalance() + amount);

            System.out.println("\nAmount Deposited Successfully.");
            System.out.println("Current Balance : " + acc.getBalance());
        }
        catch (AccountNotFoundException | InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        catch (Exception e) {
            System.out.println("Invalid Input.");
        }
    }

    public void withdraw() {
        try {
            System.out.print("Enter Account Number : ");
            int accNo = sc.nextInt();
            Account acc = searchAccount(accNo);
            if (acc == null)
                throw new AccountNotFoundException();

            System.out.print("Enter Amount : ");
            double amount = sc.nextDouble();
            if (amount <= 0)
                throw new InvalidAmountException();

            if (amount > acc.getBalance())
                throw new InsufficientBalanceException();

            acc.setBalance(acc.getBalance() - amount);

            System.out.println("\nWithdraw Successful.");
            System.out.println("Remaining Balance : " + acc.getBalance());
        }
        catch (AccountNotFoundException |InvalidAmountException |InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Invalid Input.");
        }
    }

    public void checkBalance() {
        System.out.print("Enter Account Number : ");
        int accNo = sc.nextInt();
        Account acc = searchAccount(accNo);
        if (acc == null) {
            System.out.println("Account Not Found.");
            return;
        }

        System.out.println("\nCurrent Balance : " + acc.getBalance());
    }

    public void modifyAccount() {
        System.out.print("Enter Account Number : ");
        int accNo = sc.nextInt();
        sc.nextLine();
        Account acc = searchAccount(accNo);
        if (acc == null) {
            System.out.println("Account Not Found.");
            return;
        }
        System.out.print("Enter New Name : ");
        acc.setName(sc.nextLine());

        System.out.print("Enter New Mobile : ");
        acc.setMobile(sc.nextLine());

        System.out.print("Enter New Email : ");
        acc.setEmail(sc.nextLine());

        System.out.print("Enter New Address : ");
        acc.setAddress(sc.nextLine());

        System.out.println("\nAccount Updated Successfully.");
    }

    public class Main {

        public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            Account obj = new Account();
            obj.display();
            for(int choice = 1; choice != 0;){
                System.out.println();
                System.out.println("1. Create Account");
                System.out.println("2. Display Account Details");
                System.out.println("3. Display All Accounts");
                System.out.println("4. Deposit");
                System.out.println("5. Withdraw");
                System.out.println("6. Modify Account");
                System.out.println("7. Check Balance");
                System.out.println("0. Exit");
                System.out.println();
                System.out.print("Enter the Choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        obj.createAccount();
                        break;
                    case 2:
                        obj.displayAccount();
                        break;
                    case 3:
                        obj.displayAllAccounts();
                        break;
                    case 4:
                        obj.deposit();
                        break;
                    case 5:
                        obj.withdraw();
                        break;
                    case 6:
                        obj.modifyAccount();
                        break;
                    case 7:
                        obj.checkBalance();
                        break;
                    case 0:
                        System.out.println("Thank You... Visit Again.");
                        System.out.println();
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                }
            }
        }
    }
}