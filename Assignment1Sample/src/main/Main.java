package main;

import specifics.SelectivePublicUniversity;
import structures.Student;
import structures.University;

public class Main {

	public static void main(String[] args) {
		
		Student s1 = new Person(2.0, "Ohio");
		Student s2 = new Person(4.0, "Ohio");
		Student s3 = new Person(1.0, "Illinois");
		
		University miamiOH = new SelectivePublicUniversity("Ohio");
		System.out.println(miamiOH.enroll(s3));
		System.out.println(miamiOH.enroll(s2));
	}
	
	private static class Person implements Student {
		private double GPA;
		public String residence;
		
		public Person (double GPA, String residence) {
			this.GPA = GPA;
			this.residence = residence;
		}
		
		public double getGPA() {
			return GPA;
		}
		
		public String getStateResidence() {
			return residence;
		}
		
	}
}
