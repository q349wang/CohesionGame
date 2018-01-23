package CohesionCode;

import java.awt.geom.*;

/**
 * File Name:	TriRect
 * Programmer:	Qiuhan (Leo) Wang
 * Date: January 23, 2017
 * Description: Object which holds all methods and variables native to a TriRect
 * (three stationary rectangles) obstacle
 */
public class TriRect extends Obstacle {

    private Rectangle2D.Double[] rect = new Rectangle2D.Double[3]; // Arrray to store rectangle

    // Constructer to build TriRect with inputted x and y positions and number of shapes
    public TriRect(int x, int y, int num) {

        super(x, y, num); // Calls superclass constructor

        setType(2); // Sets the obstacle type to TriRect (2)

        // Creates rectangle shapes
        
        this.rect[0] = new Rectangle2D.Double(x, y, 300, 50);
        this.rect[1] = new Rectangle2D.Double(x, y + 125, 300, 50);
        this.rect[2] = new Rectangle2D.Double(x, y + 250, 300, 50);

    }

    // Changes the height of obstacle to inputted yPos value
    @Override
    public void setY(double y) {

        this.yPos = y; // Updates yPos variable
        
        // Reconfigure obstacle values based on new y value
        
        this.rect[0].setRect(this.xPos, y, 300, 50);
        this.rect[1].setRect(this.xPos, y + 125, 300, 50);
        this.rect[2].setRect(this.xPos, y + 250, 300, 50);

    }

    // Returns shape at inputted index of the rect array
    @Override
    public Rectangle2D.Double getShape(double index) {

        int i = (int) index;

        return this.rect[i];

    }

}
