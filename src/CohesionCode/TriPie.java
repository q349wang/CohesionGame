package CohesionCode;

import java.awt.geom.*;

/**
 * File Name:	TriPie
 * Programmer:	Qiuhan (Leo) Wang
 * Date: January 23, 2017
 * Description: Object which holds all methods and variables native to a TriPie
 * (rotating circle consisting of three pie shaped portions) obstacle
 */
public class TriPie extends Obstacle {

    private Arc2D.Double[] pie = new Arc2D.Double[3]; // Arrray to store pie of the circle
    public Arc2D.Double splitter = new Arc2D.Double(); // Splitter to seperate three pies

    // Constructer to build TriPie with inputted x and y positions and number of shapes and splitter
    public TriPie(int x, int y, int num) {

        super(x, y, num); // Calls superclass constructor

        setType(3); // Sets the obstacle type to TriPie (3)

        // Creates pie shapes
        
        this.pie[0] = new Arc2D.Double(x, y, 300, 300, 0, 90, Arc2D.PIE);
        this.pie[1] = new Arc2D.Double(x, y, 300, 300, 120, 90, Arc2D.PIE);
        this.pie[2] = new Arc2D.Double(x, y, 300, 300, 240, 90, Arc2D.PIE);
        
        // Creates splitter shape

        splitter = new Arc2D.Double(x + 50, y + 50, 200, 200, 0, 360, Arc2D.PIE);

    }

    // Changes the height of obstacle to inputted yPos value
    @Override
    public void setY(double y) {

        this.yPos = y; // Updates yPos variable
        
        // Reconfigure obstacle values based on new y value

        this.pie[0].setArc(this.xPos, y, 300, 300, 0, 90, Arc2D.PIE);
        this.pie[1].setArc(this.xPos, y, 300, 300, 120, 90, Arc2D.PIE);
        this.pie[2].setArc(this.xPos, y, 300, 300, 240, 90, Arc2D.PIE);

        splitter.setArc(this.xPos + 50, y + 50, 200, 200, 0, 360, Arc2D.PIE);
        
    }

    // Returns shape at inputted index of the pie array
    @Override
    public Arc2D.Double getShape(int index, int placeholder) {

        if(index == -1)  { // If index is -1 (returns splitter)
            
            return splitter;
            
        }   else    { // Returns obstacle shapes
        
        return this.pie[index];
        
        }

    }

}
