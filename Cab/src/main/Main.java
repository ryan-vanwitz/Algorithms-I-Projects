package main;

import java.util.List;
import java.util.ArrayList;

import com.github.javafaker.Faker;

import structures.Cab;
import structures.People;
import structures.Person;
import structures.AggregateCab;
import structures.IndividualsCab;
import structures.BagADT;
import structures.ConstrainedCapacityBag;
import structures.BaggyCab;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    People p1 = new Person("James");
	    People p2 = new Person("Chen");
	    System.out.println(p1);
	    
	    Cab aggregate = new AggregateCab(3);
	    Cab indiviuals = new IndividualsCab(5);
	    aggregate.addPassenger(new Person("Paula"));
	    aggregate.addPassenger(new Person("Vijay"));
	    aggregate.addPassenger(new Person("Brad"));
	    if(aggregate.isFull()) {
	        System.out.println("Your implementation seems to work!");
	    }
	    
	    Faker faker = new Faker();
	    People p3 = new Person(faker.name().fullName());
	    People p4 = new Person(faker.name().fullName());
	    System.out.println(p3 + "\n" + p4);
	    
	    if(test1()) {
	        System.out.println("\ntest1 sucessful!");
	    }
	    
	    System.out.println("\nThe leftover people from test2: ");
	    List<People> leftoverPeople = test2();
	    for (People p: leftoverPeople) {
	        System.out.println(((Person) p).toString());
	    }
	}
	
	public static boolean test1() {
	    List<People> peopleList = new ArrayList<People>();
	    List<Cab> cabList = new ArrayList<Cab>();
	    Faker randomPeople = new Faker();
	    
	    for (int i = 0; i < 50; i++) {
	        People newFaker = new Person(randomPeople.name().fullName());
	        peopleList.add(newFaker);
	    }
	    
	    cabList.add(new AggregateCab(8));
	    cabList.add(new AggregateCab(6));
	    cabList.add(new AggregateCab(4));
	    cabList.add(new AggregateCab(5));
	    cabList.add(new AggregateCab(9));
	    cabList.add(new IndividualsCab(4));
	    cabList.add(new IndividualsCab(7));
	    cabList.add(new IndividualsCab(6));
	    cabList.add(new IndividualsCab(8));
	    
	    storePeople(peopleList, cabList);
	    
	    return true;
	}
	
	public static List<People> test2() {
	    List<People> peopleList = new ArrayList<People>();
        List<Cab> cabList = new ArrayList<Cab>();
        Faker randomPeople = new Faker();
        
        for (int i = 0; i < 50; i++) {
            People newFaker = new Person(randomPeople.name().fullName());
            peopleList.add(newFaker);
        }
        
        cabList.add(new AggregateCab(8));
        cabList.add(new AggregateCab(6));
        cabList.add(new AggregateCab(5));
        cabList.add(new IndividualsCab(4));
        cabList.add(new IndividualsCab(7));
        cabList.add(new IndividualsCab(6));
        
        storePeople(peopleList, cabList);
        
        return peopleList;
	}
	
	public static int storePeople(List<People> p,  List<Cab> c){
		while(!p.isEmpty()){ //while there are people needing cabs
			if(c.isEmpty()) return p.size(); //error, stranded people
			if(c.get(0).isFull()){ //if the current cab is full�
				c.remove(0); //�that cab is dealt with
				if(c.isEmpty()) return p.size(); //got more cabs?
			}
			//the current person can get into the current cab
			c.get(0).addPassenger(p.get(0)); 
			p.remove(0); //person dealt with
		}
		return 0;
	}

}
