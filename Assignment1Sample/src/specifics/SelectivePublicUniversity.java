package specifics;

import java.util.List;
import java.util.ArrayList;

import structures.Student;
import structures.University;

public class SelectivePublicUniversity implements University{

	private String state;
	private List<Student> students;
	private int revenue;
	
	public SelectivePublicUniversity(String state) {
		this.state = state;
		students = new ArrayList<Student>();
		revenue = 0;
	}
	
	@Override
	public boolean enroll(Student s) {
		if (s.getGPA() > 3.5) {
			if (s.getStateResidence() == state) {
				revenue += 7000;
			} else {
				revenue += 21000;
			} try {
				students.add(s);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		return false;
	}
			

}
