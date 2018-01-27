/**
 * Zafar Ali
 * 500688075
 */



import java.awt.Color;
import java.awt.Graphics2D;

// General element of a graph (nodes and edges)

abstract public class GraphElement
{
  //instance variables
  private double xPos;
  private double yPos;
  protected String label;
  protected Color color;
  boolean selected;

  /**
   * Constructor for GraphElement
   */
  public GraphElement()
  {
    xPos = 0;
    yPos = 0;
    label = "";
    color = Color.BLACK;
  }
  
  /**
   * Constructor for GraphElement
   * @param x The x coordinate of the node
   * @param y The y coordinate of the node
   */
  //Edge inherits superclass GraphElement
  public GraphElement(double x, double y)
  {
    xPos = x;
    yPos = y;
    label = "";
    color = Color.BLACK;
  }
  
  /**
   * Gets the x position of node
   * @return double xPos the x position
   */
  public final double getXPos()
  {
    return xPos;
  }
  
   /**
   * Gets the yx position of node
   * @return double yPos the y position
   */
  public final double getYPos()
  {
    return yPos;
  }
  
   /**
   * Sets the x position of node 
   * @param x The x position of node
   */
  public final void setXPos(double x){
    xPos=x;
  }
  
   /**
   * Sets the y position of node 
   * @param y The y position of node
   */
  public final void setYPos(double y){
    yPos=y;
  }
   
   /**
   * Sets the color of node 
   * @param x The color object
   */
  public void setColor(Color color)
  {
    this.color = color;
  }
  
   /**
   * Positions the node when moving 
   * @param xLoc the x location of the node
   * @param yLoc the y location of the node
   */
  public void moveTo (double xLoc, double yLoc)
  {
    xPos = xLoc;
    yPos = yLoc;
  }
  
  /**
   * Outputs coordinates of node object when called
   * @return str The string of the coordinates
   */
  public String toString()
  {
    String str = "(X,Y) Position: (" + xPos + "," + yPos + ")\n";
    return str;
  }
  
   /**
   * Abstract method for draw to be overriden by subclass
   * @param g2 Graphics object
   */
  abstract void    draw(Graphics2D g2); 
  
  /**
   * Abstract method hecks if the node is clicked to be overriden by subclass
   * @param x The x coordinate of the node
   * @param y The x coordinate of the node
   * @return boolean True if the node is clicked otherwise false 
   */
  abstract boolean isClicked(double x, double y);
  
   /**
   * Applies the label to the node to be overriden by subclass
   * @return boolean true if label is applied else otherwise
   */
  abstract boolean applyLabel();
  
   /**
   * Gets the label 
   * @return label The label string
   */
  public String getLabel()
  {
    return label;
  }
   /**
   * Sets the label 
   * @param label The label
   */
  public void setLabel(String label)
  {
    this.label = label;
  }
  
}
