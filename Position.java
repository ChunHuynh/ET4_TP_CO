public class Position {
    private double x, y;
    private static Position defaultPosition = new Position(0.0, 0.0);

    public static Position positionDefaut () { return new Position(); }

    public Position() {
        this.x = defaultPosition.x();
        this.y = defaultPosition.y();
    }

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() { return this.x; }

    public double y() { return this.y; }

    public void setX(double newX) {x = newX;}

    public void setY(double newY) {y = newY;}

    public void move(double dx, double dy) {
        x += dx; // TODO: vérifier que ce n'est pas un mouvement illégal (?)
        y += dy;
    }

    @Override
    public String toString()  { return String.format("(%4.1f, %4.1f)", x(), y()); }

}
