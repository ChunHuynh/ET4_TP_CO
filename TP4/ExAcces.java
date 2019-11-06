public class ExAcces extends Expression{
	
	private Declaration variable;
	
	public ExAcces(Declaration d) {
		super();
		variable = d;
	}
	
	@Override
	public int eval() {
		return variable.getValeur();
	}

	@Override
	public boolean estStatique() {
		return false;
	}
}