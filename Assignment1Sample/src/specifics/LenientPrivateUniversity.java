package specifics;

import java.util.List;
import java.util.ArrayList;

import structures.Student;
import structures.University;

public class LenientPrivateUniversity implements University{

	private List<Student> students;
	private int revenue;
	
	public LenientPrivateUniversity(String state) {
		students = new ArrayList<Student>();
		revenue = 0;
	}
	
	@Override
	public boolean enroll(Student s) {
		try {
			students.add(s);
		} catch (Exception e) {
			return false;
		}
		revenue += 65000;
		return true;
	}
			

}