import java.util.Scanner;
public class account {
    int balance;
    int prevTransac;
    String customerName;
    String customerID;

    account(String name, String ID){
        customerName = name;
        customerID = ID;
    }

    void deposit(int amount){
        if(amount>0){
            balance += amount;
            prevTransac = amount;
            System.out.println("Success!");
        }else{
            System.out.println("Invalid input");
        }
    }

    void withdraw(int amount){
        if(balance<amount){
            System.out.println("Not enough balance");
        }else{
            balance -= amount;
            prevTransac = -amount;
            System.out.println("Success!");
        }
    }

    void previoutTrans(){
        if(prevTransac>0){
            System.out.println("Deposited: "+prevTransac);
        }else if(prevTransac<0){
            System.out.println("Withdrawn: "+Math.abs(prevTransac));
        }else{
            System.out.println("No Previous Transaction");
        }
    }

    void interest(int year){
        double interestRate = 0.03157;
        double newBalance = (balance*interestRate*year) + balance;
        System.out.println("Interest Rate: "+ (100*interestRate)+"%");
        System.out.println("Balance after "+year+" year/s: "+newBalance);
    }

    void menu(){
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to DWGG Bank");
        System.out.println("Name:" +customerName);
        System.out.println("ID: "+customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. View Previous Transaction\n5. Calculate Interest\n6. Exit");


        do {
            System.out.print("Enter an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println();
                    System.out.println("Your current balance is: " + balance);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Enter amount to deposit: ");
                    int depAmount = sc.nextInt();
                    deposit(depAmount);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = sc.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    previoutTrans();
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.print("Enter years: ");
                    int interestAmount = sc.nextInt();
                    interest(interestAmount);
                    System.out.println();
                    break;
                case 6:
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid input");
                    System.out.println();
                    break;
            }
        }while(option!=6);
        System.out.println();
        System.out.println("Thank you for banking with DWGG Bank!");
    }

}
