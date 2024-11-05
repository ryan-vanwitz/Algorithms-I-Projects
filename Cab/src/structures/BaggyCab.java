package structures;

public class BaggyCab implements Cab {

    private int seats;
    private int passengers;

    public BaggyCab(int seats) {
        this.seats = seats;
        passengers = 0;  
    }
    
    public boolean isFull() {    
        return passengers >= seats;
    }
    
    public boolean addPassenger(People p) {
        if (passengers >= seats) {
            return false;
        }
        passengers++;
        return true;
    }
}
