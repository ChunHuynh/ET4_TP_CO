public class InsAffectation extends Instruction{

    private Declaration declaration;
    private Expression expression;

    public InsAffectation(Declaration d, Expression e){
    	super();
        declaration = d;
        expression = e;
    }

	@Override
	public void exec() {
		declaration.setValeur(expression.eval());
	}

}
