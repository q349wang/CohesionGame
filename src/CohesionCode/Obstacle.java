package CohesionCode;

import java.awt.Color;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;


/**
 * File Name:	Obstacle
 * Programmer:	Qiuhan (Leo) Wang
 * Date: January 23, 2017
 * Description: Object which holds all methods and variables native to all
 * obstacles such as x and y position
 */
    public class Obstacle{

    public double xPos, yPos; // Variables to hold center position of obstacle
    private int obsType; // Number to identify what obstacle is being used
    
    public int numShapes; // Number of shapes to colour in obstacle
    public Color shapeCol[]; // Array to hold all shapes' colour

    public Obstacle() { // Creates obstacle at position 0,0 with no shapes in it

        this.xPos = 0;
        this.yPos = 0;
        
        this.numShapes = 0;
        this.shapeCol = new Color[numShapes];
        
        setColour(shapeCol);

    }

    public Obstacle(int x, int y, int num) { // Creates obstacle at inputted position and inputted number of shapes. Also assigns random colour to the shape

        this.xPos = x;
        this.yPos = y;
        
        this.numShapes = num;
        this.shapeCol = new Color[numShapes];
        
        setColour(shapeCol);

    }

    public final double getX() { // Returns xPos value

        return this.xPos;

    }

    public final double getY() { // Returns yPos value

        return this.yPos;

    }

    public final int getType() { // Returns obsType

        return this.obsType;

    }
    
    public final Color getCol(int index) { // Returns colour value of shape from shapeCol array at index
        
        return shapeCol[index];
        
    }
    
    public Arc2D.Double getShape(int index, int placeholder) { // Method that returns arc shape of obstacle that needs to be drawn (Overriden by subclasses). Placeholder is only to differentiate this getShape from the Rectangle2D getShape
        
        return new Arc2D.Double();
        
    }
    
    public Rectangle2D.Double getShape(double index) { // Method that returns rectangle shape of obstacle that needs to be drawn (Overriden by subclasses)
        
        return new Rectangle2D.Double();
        
    }

    public void setColour(Color[] colour) { // Sets colour values to random colour value (red, green or blue) of all shapes in obstacle

        int randCol; // Variable to store random number which corresponds to a colour

        for (int i = 0; i < colour.length; i++) { // Repeats for the number of shapes which need random colours assigned

            randCol = (int) Math.ceil(Math.random() * 3); // Gets a random number 1 - 3

            switch (randCol) { // Sets colour of shape in obstacle based on random number

                case 1:

                    colour[i] = Color.RED;

                    break;

                case 2:

                    colour[i] = Color.BLUE;

                    break;

                case 3:

                    colour[i] = new Color(0, 153, 102);

                    break;
                    
                    default:
                
                break;

            }

        }

    }

    public final void setX(double x) { // Sets xPos value to input value

        this.xPos = x;

    }

    public void setY(double y) { // Sets yPos value to input value

        this.yPos = y;

    }

    public final void setType(int id) { // Sets obsType value to input value

        this.obsType = id;

    }

}
