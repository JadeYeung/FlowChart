/**
 * Zafar Ali
 * 500688075
 */


import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;


public class EllipseNode extends GraphElement{
  //coordinate instance variables
  double x;
  double y;
  
   /**
   * Constructor for EllipseNode
   * @param x The x coordinate of ellipse
   * @param y The y coordinate of ellipse
   */
  public EllipseNode(double x, double y){
    this.x=x;
    this.y=y;
    //set xPos and yPos variables from GraphElement to value of x and y of the ellipse
    setXPos(x);
    setYPos(y);
    
  }
  /**
   * Draws the ellipse
   * @param g2 graphics object
   */
  public void  draw(Graphics2D g2){
    //sets x and y variables to values of xPos and yPos located in GraphElement
    x=(int)getXPos();
    y=(int)getYPos();
    
    
    //create ellipse object
    Ellipse2D.Double circle= new Ellipse2D.Double(x,y,100,20);
    
    g2.draw(circle);
    g2.drawString (getLabel(),(int)x+30,(int)y+15);
  }
  /**
   * Checks if the ellipse is clicked 
   * @param x The x coordinate of the ellipse
   * @param y The x coordinate of the ellipse
   * @return boolean True if the ellipse is clicked otherwise false depending on contains method return 
   */
  public boolean isClicked(double x, double y){
    return contains(x,y);
  }
  
  /**
   * Applies the label to the ellipse object 
   * @return boolean true if label is applied else otherwise
   */
  public boolean applyLabel(){
    return true;
  }
   /**
   * Checks if the ellipse is  clicked within boundaries
   * @param x The x coordinate of the mouse click
   * @param y The y coordinate of the mouse click
   * @return boolean True if the ellipse is clicked in boundaries
   */
  public boolean contains (double x, double y){
    if (((x<this.x+100)&&(x>this.x))&&((y<this.y+20)&&(y>this.y))){
      return true;
    }else{
      return false;
    }
  }
}
