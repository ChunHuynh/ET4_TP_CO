import java.util.HashMap;
public class ObservateurNiveau extends ObservateurItem {
	
	
	
    public ObservateurNiveau() {
		super();
    }

    @Override
    public void add(Item i) {
		itemAlert.put(i,i.niveau());
		i.addObserver(this);
    }

    @Override
    public void alerter(Item i) {
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
