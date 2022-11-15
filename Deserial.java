package ws5;
import java.io.*;
import java.util.ArrayList;
import java.util.ArrayList;

//read student objects from the file -> show info in the console
public class Deserial {

	public static void main(String args[]) {

		ArrayList<Student> stu = new ArrayList<Student>();
		
		Student s1 = new Student();
		try {
			FileInputStream fis = new FileInputStream("file.out");

			ObjectInputStream ois = new ObjectInputStream(fis);

			stu = (ArrayList<Student>)ois.readObject();

			fis.close();

		} catch (Throwable e) {
			System.err.println(e);
		}
		for(int i=0; i<stu.size(); i++) {
			System.out.println("Deserialization--readObject first name: " + stu.get(i).getFirstName());
			System.out.println("Deserialization--readObject last name: " + stu.get(i).getLastName());
			System.out.println("Deserialization--readObject ID: " + stu.get(i).getID());
			System.out.println("Deserialization--readObject courses: ");
			ArrayList<String> temp = stu.get(i).getCourse();
			for(String c : temp) {
				System.out.println(c);
			}
		}
		

	}
}
