
public class Session02CSE374 {
    
    while (!p.isEmpty()) {
        if (c.isEmpty()) {
            return p.size();      
        } if (c.get(0).isFull()) {
            c.remove(0);
            if (c.isEmpty()) {
                return p.size();
            }
        }
        c.get(0).addPassenger(p.get(0));
        p.remove(0);
    }
    return 0;
}

/*
while (!p.isEmpty()) {
    if (c.isEmpty()) {
        return p.size();      
    } if (c.get(0).isFull()) {
        c.remove(0);
        continue;
    }
    c.get(0).addPassenger(p.get(0));
    p.remove(0);
}  */
return 0;
}

