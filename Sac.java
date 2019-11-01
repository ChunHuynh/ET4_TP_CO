public class Sac extends Item {

    protected double perte; /* taux de perte */
    public final double masseInitiale;

    public Sac(double masse, double perte) {
        this(masse, perte, Position.positionDefaut());
    }

    public Sac(double masse, double perte, Position p) {
	    super(masse, p);
	    this.perte = perte;
	    this.masseInitiale = masse;
    }

    @Override
    public String toString() {  return String.format("%-10s %3d", "Sac", id()) +
                                       String.format(", %s: %5.1f", "Masse", masse()) +
                                       ", Position " + this.position().toString() +
                                       ", Niveau " + niveau() +
                                       String.format(", %s: %5.1f", "Masse initiale", masseInitiale) +
                                       ", Taux de perte " + this.perte; }
}
