import java.util.Observable;
import java.util.Observer;
import java.util.HashMap;

public abstract class ObservateurItem implements Observer {
	
	protected HashMap<Item, Object> itemAlert;

    protected ObservateurItem() {
		itemAlert = new HashMap<>();
    }
	
	public void add (Item i){
		itemAlert.put(i, null);
	}

	public void remove (Item i){
		itemAlert.remove(i);
		i.deleteObserver(this);
	}
	
    public void update(Observable o, Object ignore) {
    }
}
