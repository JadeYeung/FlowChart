/**
 * Zafar Ali
 * 500688075
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphDrawViewer implements ActionListener
{
  //create GrawDrawComponent object
  GraphDrawComponent graphComp;
  
  //create textfield
  JTextField labelField;
  
   /**
   * Constructor for GraphDrawViewer
   */
  public GraphDrawViewer(){
    //create frame 
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //set size of frame
    frame.setSize(500, 700);
    
    // set title of frame
    frame.setTitle("Graph Draw");
    
    frame.setLayout(new BorderLayout());
    
    //initializes GraphDrawComponent object
    graphComp = new GraphDrawComponent();
    
    //adds GraphDrawComponent to frame
    frame.add(graphComp,BorderLayout.CENTER);
    
    //create panel
    JPanel panel = new JPanel();
    
    //add panel to frame
    frame.add(panel,BorderLayout.NORTH);
    
    //create buttons
    JButton rectangleButton = new JButton("Rectangle");
    JButton ellipseButton = new JButton("Ellipse");
    JButton edgeButton = new JButton("Edge");
    JButton labelButton= new JButton("Label");
    
    //initialize textfield
    labelField = new JTextField(10);
    
    //Add all buttons
    panel.add(rectangleButton);
    panel.add(ellipseButton);
    panel.add(edgeButton);
    panel.add(labelButton);
    panel.add(labelField);
    
    //listeners for buttons
    rectangleButton.addActionListener(this);
    ellipseButton.addActionListener(this);
    labelButton.addActionListener(this);
    edgeButton.addActionListener(this);
    
    frame.setVisible(true);
  }
  public static void main(String[] args)
  {
    GraphDrawViewer gdv=new GraphDrawViewer ();
    
  }
  
   /**
   * Runs when a button is pressed and calls the associated GraphDrawComponent method
   * @param e The ActionEvent object
   */
  public void actionPerformed(ActionEvent e)
  {
    
    if  ((((JButton) e.getSource()).getText() ).equals("Rectangle")){
      graphComp.addRectangle();
      
    }else if ((((JButton) e.getSource()).getText() ).equals("Ellipse")){
      graphComp.addEllipse();
      
      
    }else if  ((((JButton) e.getSource()).getText() ).equals("Edge")){
      graphComp.addEdge();
    }else if ((((JButton) e.getSource()).getText() ).equals("Label")){
      graphComp.addLabel();
      graphComp.setLabel(labelField.getText());
      
      
    }
  }
}


