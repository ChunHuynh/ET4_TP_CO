import java.util.HashMap;
public class ObservateurDeplacement extends ObservateurItem {
	
	

    public ObservateurDeplacement() {
		super();
    }

    @Override
    public void add(Item i) {
		itemAlert.put(i, new Position(i.position().x(), i.position().y()));
		i.addObserver(this);
    }

	@Override
	public void alerter(Item i) {
	   if(!(i.position().equals(itemAlert.get(i)))){
            System.out.println("L'objet " + i.id() + " a change de position : " + itemAlert.get(i).toString() + " -> " + i.position().toString() + ".");
            itemAlert.replace(i, new Position(i.position().x(), i.position().y()));
        }
    }
}
