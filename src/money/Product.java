
/**
 * Класс продукт, содержит имя и цену
 */
public class Product {

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