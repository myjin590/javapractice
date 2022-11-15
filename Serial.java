package ws5;
import java.io.*;

import java.util.Scanner;
import java.util.ArrayList;

//enter info for student objects -> save student objects into file

public class Serial {
	public static void main(String args[]){
		
		//get input for student objects

		Scanner userInput = new Scanner (System.in);
		ArrayList<Student> stu = new ArrayList<Student>();
		
		int exit = 0;
		
		while(exit != 1) {
			System.out.println("Enter Student First name: ");
			String firstName = userInput.next();
			Student s = new Student();
			try {
				s.setFirstName(firstName);
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
			
			System.out.println("Enter Student Last name: ");
			String lastName = userInput.next();
			try {
				s.setLastName(lastName);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			System.out.println("Enter Student id: ");
			int stdID = userInput.nextInt();
			try {
				s.setStdID(stdID);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			System.out.println("Enter total courses: ");
			int num = userInput.nextInt();
			ArrayList<String> courseArr = new ArrayList<String>();
			
			System.out.println("Enter course name");
			for(int i = 0; i < num; i++) {
				System.out.println(i+1 + ": "); 
				courseArr.add(userInput.next());
			}
			
			try {
				s.setCourse(courseArr);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			stu.add(s);
			System.out.println("Exit? Yes - 1 , No - 0");
			exit = userInput.nextInt();
		
		};
		
		
		userInput.close();
		
		try {
			FileOutputStream fos = new FileOutputStream("file.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(stu); //save object into file
			oos.flush();
			fos.close();
			
			for(int i = 0; i < stu.size(); i++) {
				System.out.println("serialization--writeObject fname: " + stu.get(i).getFirstName());
				System.out.println("serialization--writeObject lname: " + stu.get(i).getLastName());
				System.out.println("serialization--writeObject id: " + stu.get(i).getID());
				System.out.println("serialization--writeObject course: ");
	
				ArrayList<String> temp = stu.get(i).getCourse();
				for(String c : temp) {
					System.out.println(c);
				}
			}
			

		} catch (Throwable e) {
			System.err.println(e);
		}
		
		
	}
	

}
