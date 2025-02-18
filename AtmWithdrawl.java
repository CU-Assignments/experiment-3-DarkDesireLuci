import java.util.Scanner;

class InvalidPINException extends Exception 
{
    public InvalidPINException(String message) 
    {
        super(message);
    }
}
class InsufficientBalanceException extends Exception 
{
    public InsufficientBalanceException(String message) 
    {
        super(message);
    }
}
class ATM 
{
    private int pin = 1696;
    private double balance = 3000;
    public void authenticate(int enteredPin) throws InvalidPINException 
    {
        if (enteredPin != pin) 
        {
            throw new InvalidPINException("Error: Invalid PIN.");
        }
    }
    public void withdraw(double amount) throws InsufficientBalanceException
     {
        if (amount > balance)
        {
            throw new InsufficientBalanceException("Error: Insufficient balance. Current Balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining Balance: " + balance);
    }
    public double getBalance() 
    {
        return balance;
    }
}
public class AtmWithdrawl 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();
        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();
        try 
        {
            atm.authenticate(enteredPin);
            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();
            atm.withdraw(amount);
        } 
        catch (InvalidPINException | InsufficientBalanceException e) 
        {
            System.out.println(e.getMessage());
        } 
        finally 
        {
            System.out.println("Current Balance: " + atm.getBalance());
        }
    }
}
