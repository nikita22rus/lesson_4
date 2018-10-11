package geomty;

public class Rectangle implements Figura {

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    private Point p1;
    private Point p2;

    @Override
    public double calculateArea() {
        double dlina = Math.abs(p1.getX() - p2.getX());
        double shirina = Math.abs(p1.getY() - p2.getY());

        return dlina * shirina;
    }

    public Point getP1() {
        return p1;
    }

    public void setCoordinates(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP2() {
        return p2;
    }


    @Override
    public String toString() {
        return "Rectangle{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
