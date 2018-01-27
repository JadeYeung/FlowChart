/**
 * Zafar Ali
 * 500688075
 */

import java.awt.Color;
import java.awt.Graphics2D;

public class RectangleNode extends GraphElement{
  //instance variables for coordinate of rectangle 
  int x;
  int y;
  
  //width and height constants of rectangle
  private static final int WIDTH=100;
  private static final int HEIGHT=20;
   /**
   * Constructor for RectangleNode
   * @param x The x coordinate of rectangle
   * @param y The y coordinate of rectangle
   */
  public RectangleNode(int x, int y){
    this.x=x;
    this.y=y;
    
    //sets xPos and yPos variables located in GraphElement to the value of x and y coordinate of the rectangle
    setXPos(x);
    setYPos(y);
    
    
  }
  
   /**
   * Draws the rectangle
   * @param g2 graphics object
   */
  public void  draw(Graphics2D g2){
    //sets x and y variables to values of xPos and yPos located in GraphElement 
    x=(int)getXPos();
    y=(int)getYPos();
    
    g2.drawRect(x,y,WIDTH,HEIGHT);
    g2.drawString (getLabel(),x+30,y+15);
    
  }
  
   /**
   * Checks if the rectangle is clicked 
   * @param x The x coordinate of the rectangle
   * @param y The x coordinate of the rectangle
   * @return boolean True if the rectangle is clicked otherwise false depending on contains method return 
   */
  public boolean isClicked(double x, double y){
    
    return contains(x,y);
    
  }
  
  /**
   * Applies the label to the rectangle object 
   * @return boolean true if label is applied else otherwise
   */
  public boolean applyLabel(){
    return true;
  }
 
    /**
   * Checks if the rectangle is  clicked within boundaries
   * @param x The x coordinate of the mouse click
   * @param y The y coordinate of the mouse click
   * @return boolean True if the rectangle is clicked in boundaries
   */
  public boolean contains (double x, double y){
    if (((x<this.x+100)&&(x>this.x))&&((y<this.y+20)&&(y>this.y))){
      return true;
    }else{
      return false;
    }
  }
  
  
  
}