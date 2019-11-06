public class InsWhile extends Instruction{

    private Expression condition;
    private Instruction body;
    
    public InsWhile(Expression cond,Instruction corps) {
    	super();
        condition = cond;
        body = corps;
    }

	@Override
	public void exec() {
		while(condition.eval() != 0)
			body.exec();
	}
}
