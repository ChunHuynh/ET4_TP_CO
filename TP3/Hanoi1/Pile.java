package Hanoi1;
// Pile Homogene de <T>, de capacite fixee a l'instantiation
import java.util.Stack;

public class Pile<T> {
    final int capacite;
    protected Stack<T> pile;

    // suppose 'capa' strictement positif !
    public Pile(int capa) {
    	capacite = capa;
    	pile  = new Stack<>();
        //throw new UnsupportedOperationException();
    }

    public void empiler(T v) throws ErreurPile {
        if ( pile.size() == capacite )
        	throw new ErreurPile("Pile pleine.");
        pile.push(v);	
    }

    public void depiler () throws ErreurPile {
    	if (this.estVide())
    		throw new ErreurPile("Pile vide.");
    	pile.pop();
    }

    public T sommet() throws ErreurPile {
    	if (this.estVide())
    		throw new ErreurPile("Pile vide.");
        return pile.peek();
    }

    public boolean estVide() {
    	return pile.empty();
        //throw new UnsupportedOperationException();
    }

    public int hauteur () {
    	return pile.size();
        //throw new UnsupportedOperationException();
    }

    public int capacite () {
    	return capacite;
        //throw new UnsupportedOperationException();
    }

    /* on imprime le sommet de pile au dessus ! */
    public void affiche () { 
    	System.out.println("Pile : " + pile);
        //throw new UnsupportedOperationException();
    }
}
