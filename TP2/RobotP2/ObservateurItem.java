import java.util.HashMap;
public abstract class ObservateurItem {
	
	protected HashMap<Item, Object> itemAlert;

    protected ObservateurItem() {
		itemAlert = new HashMap<>();
    }

    public void add(Item i) {
		itemAlert.put(i,null);
		i.addObserver(this);
    }

    public void remove(Item i) {
		itemAlert.remove(i);
		i.deleteObserver(this);
    }

    public abstract void alerter(Item i);

}
	