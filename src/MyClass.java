import geomty.*;

import java.util.Arrays;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 4);

        Point p3 = new Point(0, 0);
        Point p4 = new Point(4, 3);

        Point center = new Point(98, 3);

        Rectangle r1 = new Rectangle(p1, p2);
        Square s1 = new Square(p1, p2);
        Circle c1 = new Circle(center, 2);

        System.out.println("Суммарная площадь: " + calculateFiguresArea(Arrays.asList(r1, s1, c1)));
    }

    public static double calculateFiguresArea(List<Figura> figures) {
        double sumArea = 0;
        for(Figura f : figures) {
            sumArea += f.calculateArea();
        }

        return sumArea;
    }
}
