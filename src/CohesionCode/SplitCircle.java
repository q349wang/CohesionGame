package CohesionCode;

import java.awt.geom.*;

/**
 * File Name:	SplitCircle
 * Programmer:	Qiuhan (Leo) Wang
 * Date: January 23, 2017
 * Description: Object which holds all methods and variables native to a
 * SplitCircle (rotating circle consisting of two parts) obstacle
 */
public class SplitCircle extends Obstacle {

    private Arc2D.Double[] half = new Arc2D.Double[2]; // Arrray to store half of the circle
    private Rectangle2D.Double splitter; // Rectangle which acts as splitter between the two 

    // Constructer to build SplitCircle with inputted x and y positions and number of shapes and splitter
    public SplitCircle(int x, int y, int num) {

        super(x, y, num); // Calls superclass constructor
        
        setType(0); // Sets the obstacle type to SplitCircle (0)

        // Creates circle halves
        this.half[0] = new Arc2D.Double(x, y, 300, 300, 90, 180, Arc2D.CHORD);
        this.half[1] = new Arc2D.Double(x, y, 300, 300, 90, -180, Arc2D.CHORD);

        // Creates splitter
        this.splitter = new Rectangle2D.Double(160, y - 30, 80, 360);

    }

    // Changes the height of obstacle to inputted yPos value
    @Override
    public void setY(double y) {

        this.yPos = y; // Updates yPos variable
      
        // Reconfigure obstacle values based on new y value

        this.half[0].setArc(this.xPos, y, 300, 300, 90, 180, Arc2D.CHORD);
        this.half[1].setArc(this.xPos, y, 300, 300, 90, -180, Arc2D.CHORD);
        this.splitter.setRect(160, y - 30, 80, 360);

    }

    // Returns shape at inputted index of the half array
    @Override
    public Arc2D.Double getShape(int index, int placeholder) {
        
        return this.half[index];

    }

    // Returns splitter (index is not used)
    @Override
    public Rectangle2D.Double getShape(double index) {

        return this.splitter;

    }

}
