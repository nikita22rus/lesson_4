package money;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        float USD;
        float RUB;
        float EUR;
        ArrayList a = new ArrayList();

        BufferedReader br = null;
        File file1 = new File("file1.txt");

        br = new BufferedReader(new FileReader("file1.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            a.add(Float.parseFloat(line));

        }

        USD = (float) a.get(0);
        RUB = (float) a.get(1);
        EUR = (float) a.get(2);

        //составляем список продуктов
        List<Product> productList = new ArrayList<>();

        Money newZeland = new Money(400000, Currency.USD);
        productList.add(new Product("\n" + "Wellington", newZeland));

        Money amsterdam = new Money(895000, Currency.EUR);
        productList.add(new Product("\n" + "Amsterdam", amsterdam));

        Money novosibirsk = new Money(4000000, Currency.RUB);
        productList.add(new Product("\n" + "Novosibirsk", novosibirsk));

        //создаем конвертер валют с курсом на текущий день
        CurrencyConverter currencyConvertor = new CurrencyConverter(USD,RUB,EUR);

        //выводим на экран сумму всех товаров в рублях, по текущему курсу
        System.out.println(
                "The price of all goods in rubles: " + String.format("%.2f", calculateCosts(productList, Currency.RUB,
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
