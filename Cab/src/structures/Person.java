package structures;

public class Person implements People {

    protected String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
}
