package Hanoi2;

import java.util.ArrayList;

public class Hanoi<C extends Comparable<? super C>> { // En tete tres approximatif.

    protected Tour<C> depart, milieu, arrivee;


    public Hanoi(ArrayList<? extends C> inits) throws ErreurPile { // En tete tres approximatif.
	int nb = inits.size();
	depart = new Tour<C>(nb);
        milieu = new Tour<C>(nb);
	arrivee = new Tour<C>(nb);
        for(C monC: inits) {
            depart.empiler(monC);
        }
    }


    public void jouer() {
	try {
	    oneStep(depart.capacite(), depart, arrivee, milieu);
	} catch (ErreurTour e) {
	    System.out.println("Erreur de manipulation des Tours: "
			       + e.getMessage());
	} catch (ErreurPile e) {
	    System.out.println("Erreur de manipulation des Piles: "
			       + e.getMessage());
	}
    }


    public void affiche() {
	System.out.println("Depart:"); depart.affiche();
	System.out.println("Milieu:"); milieu.affiche();
	System.out.println("Arrivee:"); arrivee.affiche();
    }

    // Empiler nb Disque de D vers A en se servant de M comme Tour auxiliaire
    protected void oneStep(int nb, Tour<C> D, Tour<C> A, Tour<C> M) 
                   throws ErreurPile {
	if (nb > 0) {
	    oneStep(nb-1, D, M, A);
	    C c = D.sommet();
	    D.depiler();
	    A.empiler(c);
	    oneStep(nb-1, M, A, D);
	}
    }
}
