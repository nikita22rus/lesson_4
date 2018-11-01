
/**
 * Класс деньги, содержит значение и валюту
 */
public class Money {
    public Money(double value, Main.Currency moneyCurrency) {
        this.value = value;
        this.moneyCurrency = moneyCurrency;
    }

    public double value;
    public Main.Currency moneyCurrency;

    @Override
    public String toString() {
        return "Money{" +
                "" + value +
                " " + moneyCurrency +
                '}';
    }
}