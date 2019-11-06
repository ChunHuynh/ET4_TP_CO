public class ExCste extends Expression {
	
	private int valeur;
	
	public ExCste (int val) {
		super();
		valeur = val;
	}
	
	public int eval() {
		return valeur;
	}

	@Override
	public boolean estStatique() {
		return true;
	}
}