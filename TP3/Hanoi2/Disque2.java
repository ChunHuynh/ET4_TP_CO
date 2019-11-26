package Hanoi2;

public class Disque2  extends Disque  {

    private int val2;

    public Disque2(int v) {
	super(v); val2 = 2*v;
    }

    public String toString() {
	return "Disque2[" + val + ", " + val2 + "]";
    }

    /* Une redefinition de compareTo juste pour montrer dans les traces
     * qu'on appelle bien cette methode. La methode doit etre compatible
     * avec la version de la super-classe (par exemple si on travaille sur
     * une tour qui melange des instances de Disque et de Disque2.
     * Ici on se contente d'appeler compareTo de Disque donc pas de pb !
     */
    public int compareTo(Disque d) {
        // System.out.println("Disque2.compareTo");
	/* attention: l'appel ci-dessus va imprimer en plus le message
	 * relatif a compareTo de Disque
	 */
	return super.compareTo(d);
    }
}
