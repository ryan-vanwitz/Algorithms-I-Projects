package main;

import java.util.List;

import structures.Cab;
import structures.People;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int storePeople(List<People> p,  List<Cab> c){
		while(!p.isEmpty()){ //while there are people needing cabs
			if(c.isEmpty()) return p.size(); //error, stranded people
			if(c.get(0).isFull()){ //if the current cab is full…
				c.remove(0); //…that cab is dealt with
				if(c.isEmpty()) return p.size(); //got more cabs?
			}
			//the current person can get into the current cab
			c.get(0).addPassenger(p.get(0)); 
			p.remove(0); //person dealt with
		}
		return 0;
	}

}
