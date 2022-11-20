package ws6;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.JButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
public class TextFieldFrame extends JFrame 
{
private JTextField fname; 
private JTextField lname; 
private JTextField id; 
private JTextField courses;
private JButton submitButton;
private  JLabel label2;
private  JLabel label1;
private JLabel label3;
private  JLabel label4;
private JTextArea textArea1;
private  JButton readButton; 
ArrayList<Student> stu = new ArrayList<Student>();
public TextFieldFrame()
{
   super("Student information - Write");
  
	  
	   Box box = Box.createHorizontalBox();
	   Student s = new Student();
	   
	   //First name
	   label1 = new JLabel("Student First Name : ", SwingConstants.LEFT); //text
	   label1.setBounds(50,50, 100,30); 
	   fname = new JTextField(20); //input
	    
	   try {
			s.setFirstName(fname.getText());
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	   box.add(label1);
	   box.add(fname); 
	   System.out.println(s.getFirstName());
	   
	   //Last name
	   label2 = new JLabel("Student Last Name : ", SwingConstants.LEFT); 
	   label2.setBounds(50,100, 100,30);
	   lname = new JTextField(20);

	 
	   box.add(label2);
	   box.add(lname);
	   //ID
	   label3 = new JLabel("Student ID : ", SwingConstants.LEFT); 
	   label3.setBounds(50,150, 100,30);
	   id = new JTextField(10);
	   
	  
	   box.add(label3);
	   box.add(id); 
	   
	   //Courses
	   ArrayList<String> courseArr = new ArrayList<String>();
	   label4 = new JLabel("Student Courses : ", SwingConstants.LEFT); 
	   label4.setBounds(50,200, 100,30);
	   courses = new JTextField(10);

	   box.add(label4);
	   box.add(courses);
	   
	   submitButton = new JButton("Submit");
	   box.add(submitButton);
	   
	   submitButton.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent event) {
			   //File f = new File("./output.txt");
			      try {
							
			    	try {
			  			s.setLastName(lname.getText());
			  		} catch (Exception e){
			  			System.out.println(e.getMessage());
			  		}
			    	  try {
			  			s.setFirstName(fname.getText());
			  		} catch (Exception e){
			  			System.out.println(e.getMessage());
			  		}
			    	  try {
			  			s.setStdID(id.getText());
			  		} catch (Exception e){
			  			System.out.println(e.getMessage());
			  		}
			       
			       String a = courses.getText(); //convert to string
			   	   String parsed[] = a.split(","); // 0 -> a , 1-> b, 2 - > c
			   	   for(int i = 0; i<parsed.length; i++) {
			   		   courseArr.add(parsed[i]);
			   	   }
			    	  try {
			  			s.setCourse(courseArr);
			  		} catch (Exception e){
			  			System.out.println(e.getMessage());
			  		}
						
			    	 stu.add(s);
						
						JOptionPane.showMessageDialog(null, "Successfully added!");
						 FileOutputStream fos = new FileOutputStream("file.out");
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(stu); //save object into file
							oos.flush();
							fos.close();
			      } catch (IOException ex) {
			    	  JOptionPane.showMessageDialog(null, "ERROR!");
			          ex.printStackTrace();
			      }
		   }
	   });
	   
	     //read 
	     
	   textArea1 = new JTextArea(15, 15);
	     
	   box.add(new JScrollPane(textArea1));
	    
	   readButton = new JButton("Read File"); 
	   box.add(readButton); //add button to box
	      
	   readButton.addActionListener(new ActionListener() 
	   { 
		   //ArrayList<Student> s = new ArrayList<Student>();
			
			//Student s1 = new Student();
	      @Override
	      public void actionPerformed(ActionEvent event)
          {
          	try {

          		FileInputStream fis = new FileInputStream("file.out");

    			ObjectInputStream ois = new ObjectInputStream(fis);

    			stu = (ArrayList<Student>)ois.readObject();
 
    		
    			fis.close();
    			System.out.println("student array size" + stu.size());
    			for(int i=0; i<stu.size(); i++) {
    				textArea1.append("Student " + (i +1) + "\n");
    				System.out.println(stu.get(i));
    				textArea1.append("First Name : " + stu.get(i).getFirstName()+ "\n");
    				textArea1.append("Last Name : " + stu.get(i).getLastName()+ "\n");
    				textArea1.append("Courses"+ "\n");
    				//textArea1.setText(stu.get(i).getID());
    				ArrayList<String> temp = stu.get(i).getCourse();
    				for(String c : temp) {
    					textArea1.append(c+ "\n");
    				}
    				
    			}
                //textArea1.read(ois, "READING FILE :-)");      

              } catch (Exception e){

                  e.printStackTrace();
              }

          } 
       });

   //when button is clicked, it will show message and write the inputs to the file.
  
   add(box);
   
}
} // end class TextFieldFrame