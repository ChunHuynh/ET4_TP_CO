package Hanoi2;

public class TourNommee<T extends Comparable<? super T>> extends Tour<T> { // tres approximatif

    protected String nom;

    public TourNommee(int nb, String n) {
	super(nb); nom = n;
    }

    public void empiler(T d) throws ErreurPile {
	System.out.println("On empile " + d.toString() + " sur " + nom);
	super.empiler(d);
    }

    public void depiler() throws ErreurPile {
	System.out.println("On depile " + nom);
	super.depiler();
    }

    public void affiche() {
	System.out.println(nom + ":"); super.affiche();
    }
}
