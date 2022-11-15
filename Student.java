package ws5;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	private String lastName;
	private String firstName;
	private int stdID;
	private ArrayList<String> courses;
	
	public Student(){}
	
	public Student(String lastName, String firstName, int stdID, ArrayList<String> courses){
		this.lastName = lastName;
		this.firstName = firstName;
		this.stdID = stdID;
		this.courses = courses;
		
	}
	
	//getter
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public ArrayList<String> getCourse(){
		return courses;
	}
	public int getID(){
		return stdID;
	}
	
	//setter
	public void setFirstName(String firstName)throws Exception{
		if(firstName != null) {
			this.firstName = firstName;
		}
		else {
			throw new Exception("Invalid first name");
		}
	}
	public void setLastName(String lastName)throws Exception{
		if(lastName != null) {
			this.lastName = lastName;
		}
		else {
			throw new Exception("Invalid last name");
		}
	}
	public void setCourse(ArrayList<String> courses) throws Exception{
		if(courses != null) {
			this.courses = courses;
		}
		else {
			throw new Exception("Invalid courses");
		}
	}
	public void setStdID(int stdID) throws Exception{
		if(stdID > 0) {
			this.stdID = stdID;
		}
		else {
			throw new Exception("Invalid student id");
		}
	}
}
