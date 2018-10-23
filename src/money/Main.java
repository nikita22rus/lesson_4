package money;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {


        Date date1 = new Date();
        date1.setDate(1);
        date1.setMonth(10);
        date1.setYear(18);

        List<Product> productList = new ArrayList<>();

        Money newZeland = new Money(1000000, Currency.USD);
        productList.add(new Product(" Wellington", newZeland));

        Money amsterdam = new Money(1, Currency.EUR);
        productList.add(new Product(" Amsterdam", amsterdam));

        Money novosibirsk = new Money(1, Currency.RUB);
        productList.add(new Product(" Novosibirsk", novosibirsk));

        Calculate productUtil = new Calculate("2018-10-01.txt");


        double totalPrice1 = productUtil.Calculatee(date1, productList);

    }

    public static void printPrice(double price) {
        NumberFormat formatter = new DecimalFormat("#0.00");

        System.out.println("Price: " + formatter.format(price));
    }
}

