/**
 * This class defines the behavior for shapes
 * as defined in the instructions in the exam
 * @author Manuela Osorio
 */
public class Shape {

    /**
     * Stores the name of the shape
     */
    private String name;

    /**
     * Is the type of figure
     * 0 for point
     * 1 for rectangle
     * 2 for triangle
     * 3 for circle
     */
    private int figure;

    /**
     * Is the cartesian coordinate
     * in the x axis
     */
    private double x;

    /**
     * Is the cartesian coordinate
     * in the y axis
     */
    private double y;

    /**
     * Is the width of the figure.
     * In rectangles represents the
     * normal width.
     * In circles represents the
     * radius.
     * In triangles represents the size
     * of the base.
     */
    private double width;

    /**
     * Is the height of the figure.
     */
    private double height;

    /**
     * Initializes a shape without
     * a name and with zero value
     * parameters. After initialized
     * it behaves as an unnamed point
     * at (0, 0)
     */
    public Shape() {
        this.name = "no name";
        this.figure = 0;
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    /**
     * Initializer for point shapes with custom
     * name, x and y.
     * @param name the name of the point
     * @param figure the type of figure
     * @param x the position in x axis
     * @param y the position in y axis
     */
    public Shape(String name, int figure, double x, double y) { //Constructor for point
        if (figure == 0) {
            this.name = name;
            this.figure = 0;
            this.set(x, y);
        } else {
            System.out.println("More parameters for more complex figures.");
        }
    }

    /**
     * Initializer for circle shapes with custom
     * name, x, y and width
     * @param name the name of the circle
     * @param figure the type of figure
     * @param x the position in x axis
     * @param y the position in y axis
     * @param width the radius
     */
    public Shape(String name, int figure, double x, double y, double width) { //Constructor for circle
        if (figure == 3) {
            this.name = name;
            this.figure = 3;
            this.set(x, y, width);
        }
    }

    /**
     * Initializer for triangle and rectangle shapes with custom
     * name, x, y, width and height
     * @param name the name of the triangle or rectangle
     * @param figure the type of figure. 1 for rectangle, 2 for triangle
     * @param x the position in x axis
     * @param y the position in y axis
     * @param width the size of the base of the figure
     * @param height the height size value
     */
    public Shape(String name, int figure, double x, double y, double width, double height) { //Constructor for triangles and rectangles
        if (figure == 1 || figure == 2) {
            this.name = name;
            this.figure = figure;
            this.set(x, y, width, height);
        }
    }

    /**
     * Modifies the x and y coordinate values
     * @param x the position in x axis
     * @param y the position in y axis
     */
    public void set(double x, double y) { //Setter for points
        this.x = x;
        this.y = y;
    }

    /**
     * Modifies the x, y and width values
     * @param x the position in x axis
     * @param y the position in y axis
     * @param width the width value
     */
    public void set(double x, double y, double width) { //Setter for circles
        this.x = x;
        this.y = y;
        this.width = width;
    }

    /**
     * Modifies the x, y, width and height values
     * @param x the position in x axis
     * @param y the position in y axis
     * @param width the width value
     * @param height the height value
     */
    public void set(double x, double y, double width, double height) { //Setter for triangles and rectangles
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * This method calculates the area
     * of a figure
     * @return area
     */
    public double area() {
        switch (this.figure) {
            case 0: //point
                return 0;
            case 1: //rectangle
                return this.width * this.height;
            case 2: //triangle
                return ((this.width * this.height) * 2);
            case 3: //circle
                return (Math.PI * (Math.pow((this.width / 2), 2)));
            default:
                return 0;
        }
    }

    /**
     * This method calculates the perimeter
     * of a figure
     * @return perimeter
     */
    public double perimeter() {
        switch (this.figure) {
            case 0: //point
                return 0;
            case 1: //rectangle
                return ((this.width + this.height) * 2);
            case 2: //triangle
                return (this.width + this.height + Math.sqrt((Math.pow(width, 2)) + (Math.pow(height, 2))));
            case 3: //circle
                return 2 * Math.PI * this.width;
            default:
                return 0;
        }
    }

    /**
     * This method determines if two figures
     * are equal as the definition in the problem
     * @param f2 object to be compared with first shape
     * @return true if equal, else false.
     */
    public boolean equals(Shape f2) {
        return (this.figure == f2.figure && this.area() == f2.area());
    }

    @Override
    /**
     * This method prints the object
     * with a format given in the problem
     */
    public String toString() {
        String figure = "";
        switch (this.figure) {
            case 0:
                figure = "point";
                break;
            case 1:
                figure = "rectangle";
                break;
            case 2:
                figure = "triangle";
                break;
            case 3:
                figure = "circle";
                break;
            default:
                figure = "";
        }

        double diameter = 0;

        if (this.figure == 3) {
            diameter = this.width * 2;
        } else {
            diameter = this.width;
        }

        String toString = this.name + " is a " + figure + " at " +
                "(" + this.x + ", " + this.y + ") " + "with a diameter of " + diameter;

        return toString;
    }
}
