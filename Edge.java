/**
 * Zafar Ali
 * 500688075
 */


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;


public class Edge extends GraphElement{
  //coordinate instance variables
   int x1;
  int  y1;
  int  x2;
  int  y2;
  
 //hitbox constant
  private static final int HIT_BOX_SIZE=2;
  //create Line2D
  Line2D.Double line;
  
   /**
   * Constructor for Edge
   * @param x1 The x coordinate of first point of edge
   * @param y1 The y coordinate of first point of edge
   * @param x2 The x coordinate of second point of edge
   * @param y2 The y coordinate of second point of edge
   */
  public Edge(int  x1,int  y1,int  x2, int  y2){
    this.x1=x1;
    this.y1=y1;
    this.x2=x2;
    this.y2=y2;
  }
  
   /**
   * Draw the edge
   * @param g2 graphics object
   */
  public void  draw(Graphics2D g2){
   line = new Line2D.Double(x1,y1,x2,y2);
    g2.draw(line);
  }
  
   /**
   * Checks if the edge is clicked 
   * @param x1 The x coordinate of the first point of edge
   * @param y1 The x coordinate of the first point of edge
   * @return boolean True if the edge is clicked otherwise false depending on contains method return 
   */
  public boolean isClicked(double x1, double y1){
    return contains(x1,y1);
  }
   /**
   * Applies the label to the edge object (is used in this case but needed in order to override GraphElement)
   * @return boolean true if label is applied else otherwise
   */
  public boolean applyLabel(){
    return false;
  }
  
   /**
   * Updates the coordinates of the edge
   * @param x1 The x coordinate of first point of edge
   * @param y1 The y coordinate of first point of edge
   * @param x2 The x coordinate of second point of edge
   * @param y2 The y coordinate of second point of edge
   */
  public void update(int x1, int y1, int x2, int y2){
    this.x1=x1;
    this.y1=y1;
    this.x2=x2;
    this.y2=y2;
  }
  
  /**
   * Checks if the edge is located within the hitbox of mouse
   * @param x The x coordinate of mouse click
   * @param y The y coordinate of mouse click
   * @return True if the edge is within the hitbox created around the mouse false otherwise
   */
  public boolean contains (double x, double y){
    int boxX=(int)x-HIT_BOX_SIZE/2;
    int boxY=(int)y-HIT_BOX_SIZE/2;
    if (line.intersects(boxX,boxY,HIT_BOX_SIZE,HIT_BOX_SIZE)){
      return true;
    }else{
      return false;
        
  }
  }
}