import java.lang.Math;

public class SacDeSable extends Sac {


    public SacDeSable(double masse, double perte) {
        this(masse, perte, Position.positionDefaut());
    }

    public SacDeSable(double masse, double perte, Position p) {
	    super(masse, perte, p);
    }

    @Override
    public String toString() {  return String.format("%-10s %3d", "Sac Sable", id()) +
                                       String.format(", %s: %5.1f", "Masse", masse()) +
                                       ", Position " + this.position().toString() +
                                       ", Niveau " + niveau() +
                                       String.format(", %s: %5.1f", "Masse initiale", masseInitiale) +
                                       ", Taux de perte " + this.perte; }
									  
	
	@Override
	 public void movePosition(double dx, double dy){
	 	int dist = (int)(dx+dy);
	 	for (int i=1; i<dist; i++)
	 		setMasse(masse() * (1.0-perte));
		//setMasse(masse() - perte * (Math.sqrt(Math.pow(dx-position().x(), 2) + Math.pow(dy-position().y(), 2))) );
		super.movePosition(dx, dy);	 
     }
}