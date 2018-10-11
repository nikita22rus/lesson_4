package geomty;

public class Square extends Rectangle {

    public Square(Point p1, Point p2) {
        super(p1, p2);

        checkIsSquare(p1, p2);
    }

    @Override
    public void setCoordinates(Point p1, Point p2) {
        checkIsSquare(p1, p2);
        super.setCoordinates(p1, p2);
    }

    private void checkIsSquare(Point p1, Point p2) {
        double dlina = Math.abs(p1.getX() - p2.getX());
        double shirina = Math.abs(p1.getY() - p2.getY());
        double epsilon = 0.00000001;

        //проверим  равенство дробных чисел
        if (Math.abs(dlina - shirina) > epsilon) {
            throw new RuntimeException("Это не квадрат!");
        }
    }
}
