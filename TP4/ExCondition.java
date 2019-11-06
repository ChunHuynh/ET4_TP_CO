public class ExCondition extends Expression {
	
	private Expression si;
	private Expression alors;
	private Expression sinon;
	
	public ExCondition(Expression condition, Expression consequence, Expression alternative) {
		super();
		si = condition;
		alors = consequence;
		sinon = alternative;
	}
	
	@Override
	public int eval() {
		return(si.eval()!=0 ? alors.eval() : sinon.eval());
	}

	@Override
	public boolean estStatique() {
		if (!si.estStatique())
			return false;
		else {
			if(si.eval() !=0) {
				return si.estStatique() && alors.estStatique();
			}else {
				return si.estStatique() && sinon.estStatique();
			}

		 }
	}
}