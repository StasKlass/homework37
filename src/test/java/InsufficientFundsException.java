public class InsufficientFundsException extends Exception {
    private double shortage;

    public InsufficientFundsException(double shortage) {
        super("Недостаточно средств: нехватка " + shortage);
        this.shortage = shortage;
    }

    public double getShortage() {
        return shortage;
    }
}
