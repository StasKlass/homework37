import java.util.logging.Logger;
public class BankAccount {


    private static final Logger logger = Logger.getLogger(BankAccount.class.getName());
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        if (accountNumber == null || !accountNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Номер счета должен состоять из 10 цифр.");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        logger.info("Created account " + accountNumber + " with initial balance " + initialBalance);

}

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма депозита не может быть отрицательной.");
        }
        balance += amount;
        logger.info("Deposited " + amount + ". New balance: " + balance);
    }
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
        logger.info("Withdrew " + amount + ". New balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
