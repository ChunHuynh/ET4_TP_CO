import java.util.Observable;

public class ObservateurDeplacement extends ObservateurItem {

    public ObservateurDeplacement() {
		super();
    }

    @Override
    public void add(Item i) {
		itemAlert.put(i, new Position(i.position().x(), i.position().y()));
    }

    @Override
    public void update(Observable o, Object ignore) {
		Item i = (Item)o;
		if(!(i.position().equals(itemAlert.get(i)))){
            System.out.println("L'objet " + i.id() + " a change de position : " + itemAlert.get(i).toString() + " -> " + i.position().toString() + ".");
            itemAlert.replace(i, new Position(i.position().x(), i.position().y()));
        }
    }
}
