import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("1234567890", 500.0);
        account.deposit(100.0);
        assertEquals(600.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() throws InsufficientFundsException {
        BankAccount account = new BankAccount("1234567890", 500.0);
        account.withdraw(200.0);
        assertEquals(300.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount("1234567890", 500.0);
        Exception exception = assertThrows(InsufficientFundsException.class, () -> {
            account.withdraw(600.0);
        });

        String expectedMessage = "Недостаточно средств";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testInvalidAccountNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("12345", 500.0);
        });

        String expectedMessage = "Номер счета должен состоять из 10 цифр.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
