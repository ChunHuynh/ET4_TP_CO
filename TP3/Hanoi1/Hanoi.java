package Hanoi1;
import java.util.ArrayList;

public class Hanoi {

    protected Tour depart, milieu, arrivee;

    // Utile uniquement pour les sous-classes qui donneront leurs
    // propres versions des Tours.
    protected Hanoi() throws ErreurPile { }

    // On prend en parametre une collection de disques a empiler sur la tour
    // de depart.
    // Dans l'arraylist les disques sont rangés par taille decroissante.
    public Hanoi(ArrayList<Disque> a) throws ErreurPile {
	// Cree une instance des tours de Hanoi avec le bon nombre de
	// disques empiles sur la tour de départ.
	int nb = a.size();
	depart = new Tour(nb); milieu = new Tour(nb); arrivee = new Tour(nb);
	for(Disque d : a) {
	    depart.empiler(d);
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
    protected void oneStep(int nb, Tour D, Tour A, Tour M) throws ErreurPile {
	if (nb > 0) {
	    oneStep(nb-1, D, M, A);
	    Disque d = (Disque) D.sommet();
	    D.depiler();
	    A.empiler(d);
	    oneStep(nb-1, M, A, D);
	}
    }

    static public void main (String[] args) throws ErreurPile {
	ArrayList<Disque> a = new ArrayList<>();

	// ArrayList fait un premier essai avec des Disques
	System.out.println("1er essai");
	for(int i = 6; i > 0; i -= 1) {
	    a.add(new Disque(i));
	}
	Hanoi h = new Hanoi(a);
	h.affiche();
	h.jouer();
	System.out.println("Situation finale:");
        h.affiche();

	// On fait maintenant pareil avec des Disque2
	System.out.println("\n2eme essai");
	a.clear();
	for(int i = 6; i > 0; i -= 1) {
	    a.add(new Disque2(i));
	}
        h = new Hanoi(a);
	h.affiche();
	h.jouer();
	System.out.println("Situation finale:");
        h.affiche();

	// On melange les deux types de Disque

	System.out.println("\n3eme essai");
	a.clear();
	for(int i = 6; i > 0; i -= 1) {
	    a.add(i%2 == 0 ? new Disque2(i) : new Disque(i));
	}
        h = new Hanoi(a);
	h.affiche();
	h.jouer();
	System.out.println("Situation finale:");
        h.affiche();
    }
}
