import java.util.HashMap;
public class ObservateurFuite extends ObservateurItem {
	
	

    public ObservateurFuite() {
		super();
    }

    @Override
    public void add(Item i) {
		itemAlert.put(i,i.masse());
		i.addObserver(this);
    }

	@Override
    public void alerter(Item i) {
		if(i.masse() != (double) itemAlert.get(i)){
            System.out.println("\nLa masse du Sac " + i.id() + " est passee de " + String.format("%5.1f", (double)itemAlert.get(i)) + " a " + String.format("%5.1f", i.masse()) + ".");
            itemAlert.replace(i, i.masse());
        }
    }
}
