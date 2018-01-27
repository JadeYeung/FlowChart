/**
 * Zafar Ali
 * 500688075
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel ;
import java.awt.event.MouseListener ;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent ;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;




public class GraphDrawComponent extends JComponent 
{ 
  // initialize all boolean variables for buttons to false
  private boolean rectangleButton=false;;
  private boolean ellipseButton=false;
  private boolean edgeButton=false;
  private boolean labelButton=false;
  
  //instance variablet for element of shapes array list that is clicked
  private int select;
  
  //instance variable for starting x and y of first point for edge
  private int startX;
  private int startY;
  
  //rectangle, ellipse and edge objects
  public RectangleNode rectangle;
  public EllipseNode ellipse;
  public Edge edge;
  
  //array list for shapes
  ArrayList <GraphElement> shapes= new ArrayList <GraphElement>();
  
  //array list for dragging edges
  ArrayList <GraphElement> draggingEdges= new ArrayList <GraphElement>();  
  {  
    
    
    class MyListener  implements MouseListener 
    {
      
      /**
       * Runs when mouse is pressed
       * @param event MouseEvent object
       */
      public void mousePressed(MouseEvent event)
      {
       
        //if the left mouse button is pressed
        if( SwingUtilities.isLeftMouseButton(event)){
          
          //none of the shapes are selected
          select=-1;
          
          //loops through shapes array list and checks if it is selected
          for (int i=0;i<shapes.size();i++){
            
            if ((shapes.get(i).isClicked(event.getX(),event.getY()))){
              
              //set selected to the index of shapes list
              select=i;
              
            }
            
          }
          
          //create rectangle object and add to list
          if (rectangleButton){
            RectangleNode rectangle = new RectangleNode (event.getX(),event.getY());
            shapes.add(rectangle);
            rectangleButton=false;
          }
          
          //create ellipse object and add to list
          if (ellipseButton){
            EllipseNode ellipse= new EllipseNode(event.getX(),event.getY());
            shapes.add(ellipse);
            ellipseButton=false;
          }
          
          //gets the starting x and starting y point of edge
          if (edgeButton){
            startX=event.getX();
            startY=event.getY();
           
          }
          
          
        }
        repaint() ;
      }
      
      /**
       * Runs when mouse is released
       * @param event MouseEvent object
       */
      public void mouseReleased(MouseEvent event)
      {
        if (edgeButton){
          
          //creates an edge object with starting point and end point after release then adds to list
          edge= new Edge(startX,startY,event.getX(),event.getY());
          edgeButton=false;
          shapes.add(edge);
         
          repaint();
        }
        
        //loops through draggingEdges list and removes all 
        for (int j=0;j<draggingEdges.size();j++){
          
          draggingEdges.remove(j);
          repaint();
        }
        
      }
      
      /**
       * Runs when mouse is clicked
       * @param event MouseEvent object
       */
      public void mouseClicked(MouseEvent event)
      {
        //if the right mouse button is clicked loop through array list and remove the selected index
        if( SwingUtilities.isRightMouseButton(event)){
          
          
          for (int i=0;i<shapes.size();i++){
            if (select==i){
              if (shapes.get(i).isClicked(event.getX(),event.getY())){
                shapes.remove(i);
                
                //set select to none of the indexes
                select=-1;
              }
              
              repaint(); 
            }
            
          }
        }
        
      }
      
      /**
       * Runs when the mouse exits a component.
       * @param event MouseEvent object
       */
      public void mouseExited(MouseEvent event)
      {
        
      }
      
      /**
       * Runs when the mouse enters a component
       * @param event MouseEvent object
       */
      public void mouseEntered(MouseEvent event)
      {
      }
    }
    
    //create mouse listener object
    MouseListener listener = new MyListener() ;
    addMouseListener(listener) ;
    
    // inner class for that handles motion listeners for mouse
    class MyMotionListener implements MouseMotionListener
    {
      //create edge object that is used to update to create a dragging line
      Edge edge2= new Edge (startX,startY,startX,startY);
      
      /**
       * Runs when mouse is dragged
       * @param event MouseEvent object
       */
      public void mouseDragged(MouseEvent event)
      {
        if( SwingUtilities.isLeftMouseButton(event)){
          
          if (edgeButton){
            edge2.update(startX,startY,event.getX(),event.getY());
            draggingEdges.add(edge2);
            repaint();
          }
          
          for (int i=0;i<shapes.size();i++){
            
            if (select==i){
              shapes.get(i).moveTo(event.getX(),event.getY());
            }
          } 
          
        }
      }
      
      /**
       * Runs when mouse is moved but does nothing in this program
       * @param event MouseEvent object
       */
      public void mouseMoved(MouseEvent event)
      {
        //do nothing 
      }
    }
    
    
    // Create mouse motion listener object and connect to component objec
    MouseMotionListener mlistener = new MyMotionListener() ;
    addMouseMotionListener(mlistener) ;
  }
  
  /**
   * Sets the rectangle button to true and all others to false
   */
  public void addRectangle(){
    rectangleButton=true;
    ellipseButton=false;
    edgeButton=false;
  }
  
  /**
   * Sets the ellipse button to true and all others to false
   */
  public void addEllipse(){
    ellipseButton=true;
    rectangleButton=false;
    edgeButton=false;
  }
  
  /**
   * Sets the edge button to true and all others to false
   */
  public void addEdge(){
    edgeButton=true;
    rectangleButton=false;
    ellipseButton=false;
  }
  
  /**
   * Sets the label button to true and all others to false
   */
  public void addLabel(){
    edgeButton=false;
    rectangleButton=false;
    ellipseButton=false;
    labelButton=true;
    
  }
  
  /**
   * Sets label for objects in shapes array list
   * @param text The label text
   */
  public void setLabel(String text){
    for (int i=0;i<shapes.size();i++){
      if (i==select){
        shapes.get(i).setLabel(text);
        repaint();
      }}}
  
  /**
   * Draws the rectangle
   * @param g2 graphics object
   */
  public void paintComponent(Graphics g)
  {  
    
    Graphics2D g2 = (Graphics2D)g;
    
    //draw dragging edges list
    for (int i=0;i<draggingEdges.size();i++){
      draggingEdges.get(i).draw(g2);
    }
    
    //draw shapes list
    for (int i=0;i<shapes.size();i++){
      if ((select!=i)){
        g2.setColor(Color.black);
        shapes.get(i).draw(g2);
        
        
        
        
      }else{ 
        g2.setColor(Color.BLUE);
        shapes.get(i).draw(g2);
      }
      
    }
  }
  
}



