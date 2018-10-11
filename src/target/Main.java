package target;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //составляем список продуктов
        List<Product> productList = new ArrayList<>();

        Money newZeland = new Money(400000, Currency.USD);
        productList.add(new Product("Велингтон", newZeland));

        Money amsterdam = new Money(895000, Currency.EUR);
        productList.add(new Product("Амстердам", amsterdam));

        Money novosibirsk = new Money(4000000, Currency.RUB);
        productList.add(new Product("Новосибирск", novosibirsk));

        //создаем конвертер валют с курсом на текущий день
        CurrencyConverter currencyConvertor = new CurrencyConverter(1.0, 66.9707, 0.85626);

        //выводим на экран сумму всех товаров в рублях, по текущему курсу
        System.out.println(
                "Цена всех товаров в рублях: " + String.format("%.2f", calculateCosts(productList, Currency.RUB,
                        currencyConvertor)));

        // узнать курс валют на сегодняший день
        // USD 65,7585 EUR 77,3846
        // USD 67.0098 EUR 78.3613
        //27.09 RUB 1 = 0.0152 USD = 0.01292 EUR
        //27.09 RUB 1 = 0.01492 USD = 0.01276 EUR

        //
        CurrencyConverter today = new CurrencyConverter(1,65.7585, 1.1705);
        CurrencyConverter twenty = new CurrencyConverter(1,67.0098,1.1767);

        double todayCost =  calculateCosts(productList, Currency.RUB, today);
        double twentyCost =  calculateCosts(productList, Currency.RUB, twenty);

        System.out.println("Twenty:  " + twentyCost);
        System.out.println("Today:  " + todayCost);

        System.out.println(String.format("%.2f",todayCost - twentyCost));

    }

    /**
     * Класс продукт, содержит имя и цену
     */
    public static class Product {
        public String productName;
        public Money price;

        public Product(String productName, Money price) {
            this.productName = productName;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "productName='" + productName + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    /**
     * Класс деньги, содержит значение и валюту
     */
    public static class Money {
        public Money(double value, Currency moneyCurrency) {
            this.value = value;
            this.moneyCurrency = moneyCurrency;
        }

        public double value;
        public Currency moneyCurrency;

        @Override
        public String toString() {
            return "Money{" +
                    "" + value +
                    " " + moneyCurrency +
                    '}';
        }
    }

    /**
     * Список возможных валют
     */
    public enum Currency {
        USD, RUB, EUR
    }

    /*
    Утилитный класс, знающий цену валютной единицы и осуществляющий, конвертацию
    из одной валютной еденицы в другую, напиример:
    unitUSD = 1, RUB = 66,9707, EUR = 0,85626
    тогда 10 рублей будут равны 0,14921 доллара
     */
    public static class CurrencyConverter {
        public final double unitUSD;
        public final double unitRUB;
        public final double unitEUR;

        public CurrencyConverter(double unitUSD, double unitRUB, double unitEUR) {
            this.unitUSD = unitUSD;
            this.unitRUB = unitRUB;
            this.unitEUR = unitEUR;
        }

        public Money convertByCurrencty(Money money, Currency convertToCurrency) {
            //проверяем на совпадение исходной валюты и валюты, в которую конвертируем
            if (money.moneyCurrency != convertToCurrency) {
                //если конвертируемая валюта не равна заданной тогда расчитываем стоимость в заданной валюте

                Money returnMoney = new Money(0, convertToCurrency);
                double unitValue = 0;

                switch (convertToCurrency) {
                    case RUB: {
                        unitValue = money.value * unitRUB;
                        break;
                    }
                    case EUR: {
                        unitValue = money.value * unitEUR;
                        break;
                    }
                    case USD: {
                        unitValue = money.value * unitUSD;
                        break;
                    }
                }

                //записываем вычисленную сумму и возращаем результат
                returnMoney.value = unitValue;
                return returnMoney;
            } else {
                //возращаем сумму в исходной валюте т.к. конвертируемая валюта равна исходной
                return money;
            }
        }
    }


    /**
     * Функция возращают сумму всех товаров в задданой валюте, по текущему курсу
     *
     * @param productList       список продуктов, для которых нужно посчитать стоимость
     * @param costsCurrency     валюта в которой требуется вернуть сумму
     * @param currencyConverter конвертер валют
     * @return
     */
    public static double calculateCosts(List<Product> productList, Currency costsCurrency,
                                        CurrencyConverter currencyConverter) {
        double summ = 0;
        for (Product i : productList) {
            System.out.println("product: " + i);
            summ += currencyConverter.convertByCurrencty(i.price, costsCurrency).value;
            System.out.println(currencyConverter.convertByCurrencty(i.price, costsCurrency));
        }
        return summ;


    }
}