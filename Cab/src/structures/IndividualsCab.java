package structures;

public class IndividualsCab implements Cab {
    private int seats;
    private Person[] peopleInCab;
    
    
    public IndividualsCab(int seats) {
        this.seats = seats;
        this.peopleInCab = new Person[seats];
    }
    
    public boolean isFull() {
        return peopleInCab.length >= seats;
    }
    
    public boolean addPassenger(People p) {
        for (int i = 0; i < seats; i++) {
            if (peopleInCab[i] == null) {
                peopleInCab[i] = (Person)p;
                return true;
            }
        }
        return false;
    }
}
