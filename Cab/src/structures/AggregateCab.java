package structures;

public class AggregateCab implements Cab {
    
    private int seats;
    private int passengers;

    public AggregateCab(int seats) {
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
