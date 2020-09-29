
public class BankAccountTest{

    public static void main(String[] args){
        BankAccount account = new BankAccount();
        account.deposit("savings", 750);
        account.deposit("checking", 10);
        account.withdraw("checking", 125);
        account.getBalances();
    }
}