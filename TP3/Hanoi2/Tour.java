package Hanoi2;

public class Tour<T extends Comparable<? super T>> extends Pile<T> { // Tres approximatif

    public Tour(int capa) {
	super(capa);
    }

    public void empiler(T v) throws ErreurPile {
	if (estVide() || sommet().compareTo(v) >= 0)
	    super.empiler(v);
	else throw new ErreurTour("Disque inadapte");
    }
}
