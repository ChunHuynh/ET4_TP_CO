package Hanoi2;

class MesEntiers implements Comparable<MesEntiers> {
    Integer val;

    public MesEntiers(int nb) {
	val = nb;
    }

    public int compareTo(MesEntiers m) {
        //System.out.println("MesEntiers.compareTo");
	return val.compareTo(m.val); // compareTo de Integer :-)
    }

    public String toString() {
	return "MesEntiers[" + val +"]";
    }
}
