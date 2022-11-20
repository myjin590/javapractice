 package ws6;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TextAreaFrame extends JFrame 
{
   private final JTextArea textArea1;
   private final JButton readButton; 

   public TextAreaFrame() 
   {
	 
      super("Read File"); 
      Box box = Box.createHorizontalBox();
      JFrame frame = new JFrame();
      textArea1 = new JTextArea(10, 10);
     
      box.add(new JScrollPane(textArea1));
    
      readButton = new JButton("Read File"); 
      box.add(readButton); //add button to box
      
      readButton.addActionListener(new ActionListener() 
    	         { 
    	            @Override
    	            public void actionPerformed(ActionEvent event)
    	            {
    	            	try {

    	                    textArea1.read(new BufferedReader(new FileReader("./output.txt")), null);

    	                } catch (Exception e){

    	                    e.printStackTrace();
    	                }

    	            } 
    	         } 
    	      );
      add(box);
   } 
} 

