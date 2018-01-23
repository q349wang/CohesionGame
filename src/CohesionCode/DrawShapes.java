package CohesionCode;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * File Name:	DrawShapes
 * Programmer:	Qiuhan (Leo) Wang
 * Date: January 23, 2017
 * Description: Holds methods used to draw 2D shapes used for the obstacles and
 * character icon
 */
public class DrawShapes extends JPanel {

    public static Polygon character; // Shape of the character
    public static Color colour = Color.RED; // Sets character colour to red
    public static int xBase, yBase; // Co-ordinates which the rest of the ones are based off of
    private static int[] xPoints, yPoints; // Holds the value of the x and y coordinates of every vertex of the character
    private static int numPoints; // Number of vertices on the character shape

    public static double radians = 0; // Number of degrees to rotate shapes

    public static ArrayList<Obstacle> obs = new ArrayList(); // ArrayList to hold obstacles that need to be drawn

    public final static void setPoints(int x, int y) { // Assigns values of vertex coordinates

        numPoints = 4; // Sets number of points

        // Sets base coordinates
        xBase = x;
        yBase = y;

        // Initalizes arrays and assigns values to them
        xPoints = new int[4];

        xPoints[0] = xBase;
        xPoints[1] = xBase + 20;
        xPoints[2] = xBase + 40;
        xPoints[3] = xBase + 20;

        yPoints = new int[4];

        yPoints[0] = yBase;
        yPoints[1] = yBase - 40;
        yPoints[2] = yBase;
        yPoints[3] = yBase - 12;

        character = new Polygon(xPoints, yPoints, numPoints); // Assigns coordinates and numPoints to new Polygon

    }
    // Override paint to perform painting

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        Graphics2D g2 = (Graphics2D) g; // Casts the Graphics to Graphics2D

        // Turns on Anti-Aliasing
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setRenderingHints(rh);

        // Sets background
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 400, 600);

        // Repeats until all obstacles in obs ArrayList are drawn
        for (int i = 0; i < obs.size(); i++) {

            int obsType = obs.get(i).getType(); // Gets obstacle type

            AffineTransform saveXform = g2.getTransform(); // Save's graphics original transform method
            AffineTransform toCenterAt = new AffineTransform();
            toCenterAt.rotate(radians, 200, (obs.get(i).getY() + 150)); // Sets transformation to a rotation of nth radians around middle of the shape counter clockwise

            if (obsType == 2) { // Do not rotate the shape if the obstacle is a TriRect

                g2.setTransform(saveXform); // Returns g2 to original transformation

            } else {

                g2.transform(toCenterAt); // Applies transformation to Graphics2D

            }

            for (int j = 0; j < obs.get(i).numShapes; j++) { // Repeats based on the number of shapes to colour in a obstacle

                g2.setColor(obs.get(i).getCol(j)); // Sets colour of the next shape drawn

                if (obsType == 2) { // If the obstacle uses rectangles, use the Rectangle2D getShape()

                    double index = (double) j; // Convert j to a double

                    g2.fill(obs.get(i).getShape(index));

                } else { // Otherwise use the Arc2D getShaoe()

                    g2.fill(obs.get(i).getShape(j, 0));

                }

            }

            // If there are are shapes dedicated to spliting a shape apart (checking the type of obstacle it is)
            g2.setColor(Color.WHITE); // Sets colour to white (splitters must blend into background

            if (obsType == 0) { // If obstacle is a SplitCircle

                g2.fill(obs.get(i).getShape(0d)); // Draws the splitter

            } else if (obsType == 3) { // If obstacle is a TriPie

                g2.fill(obs.get(i).getShape(-1, 0));

            }

            g2.setTransform(saveXform); // Returns g2 to original transformation

        }

        // Draws player
        g2.setColor(colour);
        g2.fillPolygon(character);
        
        // Draws score
        g2.setColor(Color.BLACK);
        g2.setFont(new java.awt.Font("Tahoma", 0, 24));
        g2.drawString(Integer.toString(CohesionGame.currentScore), 20, 20);

    }
}
