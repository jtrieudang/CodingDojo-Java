  
import java.text.DecimalFormat;

public class BankAccount{
    DecimalFormat df = new DecimalFormat("#.00");
    private String accountNumber;
    private static int accountsCount = 0;
    private static double totalAmount = 0;
    private double savingsBalance;
    private double checkingBalance;

    public BankAccount(){
        this.accountNumber = getAccountNumber();
        accountsCount++;
    }

    public String getAccountNumber(){
        String accountNumber = "";
        for(int i=0; i<10; i++){
            int random = (int) (Math.random()*10);
            accountNumber += random;
        } 
        return accountNumber;
    }

    private double getCheckingBalance(){
        return this.checkingBalance;
    }

    private double getSavingsBalance(){
        return this.savingsBalance;
    }

    public void getBalances(){
        System.out.println("Checking account: $"+df.format(getCheckingBalance()));
        System.out.println("Savings account: $"+df.format(getSavingsBalance()));
        
    }

    public void deposit(String accountType, double amount){
        if(accountType == "checking"){
            this.checkingBalance += amount;
        } else if(accountType == "savings"){
            this.savingsBalance += amount;
        } else {
            System.out.println("Make a deposit.");
        }
        totalAmount += amount;
        System.out.println("Deposited $"+df.format(amount)+" in "+accountType+" account.");        
    }
    
    public void withdraw(String accountType, double amount){
        if(accountType == "checking"){
            if(amount > this.checkingBalance){
                System.out.println("Not enough funding.");
            }
            this.savingsBalance -= amount;
        } else {
            System.out.println("Make a withdraw.");
        }
        totalAmount -= amount;
        System.out.println("Withdrawn $"+df.format(amount)+" from"+accountType+" account.");
    }
}