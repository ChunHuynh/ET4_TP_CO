package Hanoi2;

import java.util.ArrayList;

public class HanoiNommee<C extends Comparable<? super C>> extends Hanoi<C> { // Approximatif

    public HanoiNommee(ArrayList<? extends C> inits) throws ErreurPile { // Approximatif
	super(inits);
	int nb = inits.size();
	depart = new TourNommee<C>(nb, "Depart");
	milieu = new TourNommee<C>(nb, "Milieu");
	arrivee = new TourNommee<C>(nb, "Arrivee");
        for(C monC: inits) {
            depart.empiler(monC);
        }
    }

    public void affiche() {
	depart.affiche(); milieu.affiche(); arrivee.affiche();
    }

}
