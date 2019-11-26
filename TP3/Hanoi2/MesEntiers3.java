package Hanoi2;

public class MesEntiers3  {
    Integer val;

    public MesEntiers3(int nb) {
	val = new Integer(nb);
    }

    public int compareTo(MesEntiers m) {
	return val.compareTo(m.val);
    }

    public String toString() {
	return "MesEntiers[" + val.intValue() +"]";
    }
}

