package Hanoi1;
public class Disque {
	
    protected int val;
    
    public Disque(int v) {
	val = v;
    }

    public String toString() {
	return "Disque[" + val + "]";
    }

    public int compareTo(Disque d) {
	// utile pour les traces.
	//  System.out.println("Disque.compareTo");
	if (val < d.val) return -1;
	else if (val == d.val) return 0;
	else return 1;
    }
}
