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

    public void setGender(String gender) {
        this.gender = gender;
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
    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPan() {
        return pan;
    }
    public void setPAN(String pan) {
        this.pan = pan;
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

            String number;
            while (true) {
                System.out.print("Enter Mobile Number: ");
                number = sc.nextLine();
                number = number.replace("+91", "").replace(" ", "");
                if (number.length() == 10 && number.matches("[0-9]+")) {
                    System.out.println("Valid Mobile Number");
                    break;
                } else {
                    System.out.println("Invalid Mobile Number. Please enter a valid 10-digit mobile number.");
                }
            }
            
            String Email;
            while (true) {
                System.out.print("Enter Email: ");
                Email = sc.nextLine();
                if (Email.contains("@") && Email.endsWith(".com")) {
                    System.out.println("Valid Email ");
                    break;
                } else {
                    System.out.println("Invalid Email. Please enter a valid email address.");
                }
            }

            System.out.print("Enter Address : ");
            String address = sc.nextLine();

            long aadhar;
            while (true) {
                System.out.print("Enter Aadhar Number: ");
                aadhar = sc.nextLong();
                if (String.valueOf(aadhar).length() == 12) {
                    System.out.println("Valid Aadhar Number");
                    break;
                } else {
                    System.out.println("Invalid Aadhar Number. Please enter a valid 12-digit Aadhar number.");
                }
            }

            String pan;
            while (true) {
                System.out.print("Enter PAN Number: ");
                pan = sc.next();
                if (pan.length() == 10 && pan.matches("[A-Z]{5}[0-9]{4}[A-Z]")) {
                    System.out.println("Valid PAN Number");
                    break;
                } else {
                    System.out.println("Invalid PAN Number. Please enter a valid PAN number.");
                }
            }

            double balance;
            while (true) {
                System.out.print("Enter Opening Balance: ");
                balance = sc.nextDouble();

                if (balance >= 500) {
                    break;
                } else {
                    System.out.println("Balance must be at least 500. Try again.");
                }
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
        System.out.println("Mobile         : +91-"+acc.getMobile());
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
    try {
        System.out.print("Enter Account Number : ");
        int accNo = sc.nextInt();
        sc.nextLine();
        Account acc = searchAccount(accNo);
        if (acc == null) {
            System.out.println("Account Not Found.");
            return;
        }
        System.out.println("\n Modify Account Details ");
    System.out.println("1. Modify Name");
    System.out.println("2. Modify Mobile");
    System.out.println("3. Modify Email");
    System.out.println("4. Modify Address");
    System.out.println("5. Modify Age");
    System.out.println("6. Modify Gender");
    System.out.println("7. Modify Aadhar number");
    System.out.println("8. Modify PAN");
    System.out.println("9. Modify All");
    System.out.println("10. Exit");

    System.out.print("Enter Your Choice : ");
    int choice = sc.nextInt();
    sc.nextLine();

    switch (choice) {

        case 1:
            System.out.print("Enter New Name : ");
            acc.setName(sc.nextLine());
            System.out.println("Name Updated Successfully.");
            break;

        case 2:
            String number = "0";
            while (true) {
                System.out.print("Enter New Mobile Number: ");
                number = sc.nextLine();
                number = number.replace("+91", "").replace(" ", "");
                if (number.length() == 10 && number.matches("[0-9]+")) {
                    System.out.println("Valid Mobile Number");
                    break;
                } else {
                    System.out.println("Invalid Mobile Number. Please enter a valid 10-digit mobile number.");
                }
            }
            acc.setMobile(number);
            System.out.println("Mobile Updated Successfully.");
            break;

        case 3:
            
        String Email;
            while (true) {
                System.out.print("Enter New Email: ");
                Email = sc.nextLine();
                if (Email.contains("@") && Email.endsWith(".com")) {
                    System.out.println("Valid Email ");
                    break;
                } else {
                    System.out.println("Invalid Email. Please enter a valid email address.");
                }
            }
            acc.setEmail(Email);
            System.out.println("Email Updated Successfully.");
            break;

        case 4:
            System.out.print("Enter New Address : ");
            acc.setAddress(sc.nextLine());
            System.out.println("Address Updated Successfully.");
            break;

        case 5:
            System.out.print("Enter New Age : ");
            int age = sc.nextInt();
            sc.nextLine();
            if (age < 18)
                throw new UnderAgeException();
            if (age > 60)
                throw new OverAgeException();
            acc.setAge(age);
            System.out.println("Age Updated Successfully.");
            break;

        case 6:
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
                acc.setGender(gender);
        case 7:
            long aadhar;
            while (true) {
                System.out.print("Enter Aadhar Number: ");
                aadhar = sc.nextLong();
                if (String.valueOf(aadhar).length() == 12) {
                    System.out.println("Valid Aadhar Number");
                    break;
                } else {
                    System.out.println("Invalid Aadhar Number. Please enter a valid 12-digit Aadhar number.");
                }
            }
            acc.setAadhar(String.valueOf(aadhar));
            System.out.println("Aadhar Updated Successfully.");
            break;

        case 8:
            String pan;
            while (true) {
                System.out.print("Enter PAN Number: ");
                pan = sc.next();
                if (pan.length() == 10 && pan.matches("[A-Z]{5}[0-9]{4}[A-Z]")) {
                    System.out.println("Valid PAN Number");
                    break;
                } else {
                    System.out.println("Invalid PAN Number. Please enter a valid PAN number.");
                }
            }
            acc.setPAN(pan);
            System.out.println("PAN Updated Successfully.");
            break;

        case 9:
            System.out.print("Enter New Name : ");
            acc.setName(sc.nextLine());

            System.out.print("Enter New Mobile : ");
            number = "0";
            while (true) {
                number = sc.nextLine();
                number = number.replace("+91", "").replace(" ", "");
                if (number.length() == 10 && number.matches("[0-9]+")) {
                    System.out.println("Valid Mobile Number");
                    break;
                } else {
                    System.out.println("Invalid Mobile Number. Please enter a valid 10-digit mobile number.");
                }
            }
            acc.setMobile(number);

            Email = "";
            while (true) {
                System.out.print("Enter New Email : ");
                Email = sc.nextLine();
                if (Email.contains("@") && Email.endsWith(".com")) {
                    System.out.println("Valid Email ");
                    break;
                } else {
                    System.out.println("Invalid Email. Please enter a valid email address.");
                }
            }
            acc.setEmail(Email);

            System.out.print("Enter New Address : ");
            acc.setAddress(sc.nextLine());

            System.out.print("Enter New Age : ");
            age = sc.nextInt();
            sc.nextLine();
            if (age < 18)
                throw new UnderAgeException();
            if (age > 60)
                throw new OverAgeException();
            acc.setAge(age);
            System.out.println("Age Updated Successfully.");

            System.out.print("Enter Gender (Male/Female/Other) : ");
            gender = sc.nextLine();
            if(!(gender.equalsIgnoreCase("Male") ||
                gender.equalsIgnoreCase("Female") ||
                gender.equalsIgnoreCase("Other")||
                gender.equalsIgnoreCase("M") ||
                gender.equalsIgnoreCase("F") ||
                gender.equalsIgnoreCase("O")))
                {
                    throw new Exception();
                }
                acc.setGender(gender);

            aadhar = 0;
            while (true) {
                System.out.print("Enter Aadhar Number: ");
                aadhar = sc.nextLong();
                if (String.valueOf(aadhar).length() == 12) {
                    System.out.println("Valid Aadhar Number");
                    break;
                } else {
                    System.out.println("Invalid Aadhar Number. Please enter a valid 12-digit Aadhar number.");
                }
            }
            acc.setAadhar(String.valueOf(aadhar));
            System.out.println("Aadhar Updated Successfully.");

            pan = "";
            while (true) {
                System.out.print("Enter PAN Number: ");
                pan = sc.next();
                if (pan.length() == 10 && pan.matches("[A-Z]{5}[0-9]{4}[A-Z]")) {
                    System.out.println("Valid PAN Number");
                    break;
                } else {
                    System.out.println("Invalid PAN Number. Please enter a valid PAN number.");
                }
            }
            acc.setPAN(pan);

            System.out.println("Account Updated Successfully.");
            break;


        default:
            System.out.println("Invalid Choice.");
    }
    }
    catch (UnderAgeException e) {
        System.out.println(e.getMessage());
    }
    catch (OverAgeException e) {
        System.out.println(e.getMessage());
    }
    catch (Exception e) {
        System.out.println("Invalid Input.");
    }
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

