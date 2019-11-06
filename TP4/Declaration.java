public class Declaration{
    
    private String nom;
    private int valeur;
    
    public Declaration(String s, Expression init){
        nom = s;
        valeur = init.eval();
    }

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int v) {
		valeur = v;
	}

}
