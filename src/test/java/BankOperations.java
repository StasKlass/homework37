public class BankOperations {
    public static void main(String[] args) {
        BankAccount account = null;
        try {
            account = new BankAccount("1234567890", 500.0);
            account.deposit(150.0);
            System.out.println("Депозит успешен. Текущий баланс: " + account.getBalance());

            account.withdraw(700.0);
            System.out.println("Вывод успешен. Текущий баланс: " + account.getBalance());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.err.println("Ошибка: " + e.getMessage() + " Shortage: " + e.getShortage());
        } finally {
            System.out.println("Операция завершена.");
        }
    }
}
