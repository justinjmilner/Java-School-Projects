package MilnerJustin_lab7;

/**
 * Represents a point in a two-dimensional coordinate system.
 * Instances of this class are immutable.
 * 
 * @author C0535365 Justin Milner
 */
public class Point {
    /**
     * The x-coordinate of the point.
     */
    public final double x;
    
    /**
     * The y-coordinate of the point.
     */
    public final double y;
    
    /**
     * Constructs a point with the coordinates (0, 0).
     */
    public Point() {
        this.x = 0;
        this.y = 0;
    }
    
    /**
     * Constructs a point with the specified coordinates.
     * 
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Calculates the distance between this point and the specified coordinates.
     * 
     * @param x2 the x-coordinate of the target point
     * @param y2 the y-coordinate of the target point
     * @return the distance between this point and the target point
     */
    private double distanceFrom(double x2, double y2) {
        double distance = Math.sqrt(Math.pow((this.x - x2), 2) + Math.pow((this.y - y2), 2));
        return Double.parseDouble(String.format("%.2f", distance));
    }
    
    /**
     * Calculates the distance between this point and another point.
     * 
     * @param point the target point
     * @return the distance between this point and the target point
     */
    public double distanceFrom(Point point) {
        double x2 = point.x;
        double y2 = point.y;
        return distanceFrom(x2, y2);
    }
    
    /**
     * Returns a string representation of this point.
     * 
     * @return a string representation of this point in the format "Point: [x, y]"
     */
    @Override
    public String toString() {
        return String.format("Point: [%.2f, %.2f]", this.x, this.y);
    }
}
