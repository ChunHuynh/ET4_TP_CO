import java.util.Observable;

public class ObservateurFuite extends ObservateurItem {

    public ObservateurFuite() {
		super();
    }

    @Override
    public void add(Item i) {
		itemAlert.put(i,i.masse());
    }

   @Override
    public void update(Observable o, Object ignore) {
		Item i = (Item)o;
        if(i.masse() != (double) itemAlert.get(i)){
            System.out.println("\nLa masse du Sac " + i.id() + " est passee de " + String.format("%5.1f", (double)itemAlert.get(i)) + " a " + String.format("%5.1f", i.masse()) + ".");
            itemAlert.replace(i, i.masse());
        }
    }
}
