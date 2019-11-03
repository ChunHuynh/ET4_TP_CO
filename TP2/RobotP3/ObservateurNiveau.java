import java.util.Observable;

public class ObservateurNiveau extends ObservateurItem {

    public ObservateurNiveau() {
		super();
    }

    @Override
    public void add(Item i) {
		itemAlert.put(i,i.niveau());
    }

    @Override
    public void update(Observable o, Object ignore) {
		Item i = (Item)o;
		if(i.niveau() == 1 && (int)itemAlert.get(i) == 0){
            System.out.println("L'objet " + i.id() + " a ete charge du sol.");
            itemAlert.replace(i, i.niveau());
        }
        else if(i.niveau() == 0 && (int)itemAlert.get(i) == 1){
            System.out.println("L'objet " + i.id() + " a ete decharge au sol.");
            itemAlert.replace(i, i.niveau());
        }
    }
}
