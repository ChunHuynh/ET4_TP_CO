public abstract class ExArithmetique extends Expression{
	protected Expression exGauche;
	protected Expression exDroite;
	
	public ExArithmetique(Expression g, Expression d) {
		super();
		exGauche = g;
		exDroite = d;
	}
	
}