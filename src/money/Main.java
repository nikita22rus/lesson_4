
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
        ReadCurrency readCurrency = new ReadCurrency("C:\\Users\\Eugenia\\IdeaProjects\\untitled\\scurrency.txt");
        readCurrency.readCurrency();
        CurrencyConverter currencyConvertor = new CurrencyConverter(readCurrency.getDollar(), readCurrency.getRub(), readCurrency.getEuro());



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
            summ += currencyConverter.convertByCurrencty(i.price, costsCurrency).value;
        }
        return summ;


    }
}