public class Multiplication extends ExArithmetique{

	public Multiplication(Expression g, Expression d) {
		super(g, d);
	}

	@Override
	public int eval() {
		return this.exGauche.eval() * this.exDroite.eval();
	}

	@Override
	public boolean estStatique() {
		return exGauche.estStatique() && exDroite.estStatique();
	}
}