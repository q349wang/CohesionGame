package CohesionCode;

import java.awt.geom.*;

/**
 * File Name:	QuadCircle
 * Programmer:	Qiuhan (Leo) Wang
 * Date: January 23, 2017
 * Description: Object which holds all methods and variables native to a
 * QuadCircle (four rotating circles) obstacle
 */
public class QuadCircle extends Obstacle {

    private Arc2D.Double[] circles = new Arc2D.Double[4]; // Arrray to store circles

    // Constructer to build QuadCircle with inputted x and y positions and number of shapes
    public QuadCircle(int x, int y, int num) {

        super(x, y, num); // Calls superclass constructor

        setType(1); // Sets the obstacle type to QuadCircle (1)

        // Creates circles
        
        this.circles[0] = new Arc2D.Double(x + 200, y, 100, 100, 0, 360, Arc2D.PIE);
        this.circles[1] = new Arc2D.Double(x, y, 100, 100, 0, 360, Arc2D.PIE);
        this.circles[2] = new Arc2D.Double(x, y + 200, 100, 100, 0, 360, Arc2D.PIE);
        this.circles[3] = new Arc2D.Double(x + 200, y + 200, 100, 100, 0, 360, Arc2D.PIE);

    }

    // Changes the height of obstacle to inputted yPos value
    @Override
    public void setY(double y) {

        this.yPos = y; // Updates yPos variable
        
        // Reconfigure obstacle values based on new y value
        
        this.circles[0].setArc(this.xPos + 200, y, 100, 100, 0, 360, Arc2D.PIE);
        this.circles[1].setArc(this.xPos, y, 100, 100, 0, 360, Arc2D.PIE);
        this.circles[2].setArc(this.xPos, y + 200, 100, 100, 0, 360, Arc2D.PIE);
        this.circles[3].setArc(this.xPos + 200, y + 200, 100, 100, 0, 360, Arc2D.PIE);

    }

    // Returns shape at inputted index of the circles array
    @Override
    public Arc2D.Double getShape(int index, int placeholder) {

        return this.circles[index];

    }

}
