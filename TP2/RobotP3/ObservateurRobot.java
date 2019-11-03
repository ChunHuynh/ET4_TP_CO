import java.util.Observable;

public class ObservateurRobot extends ObservateurItem  {

    protected ObservateurRobot() {
		super();
    }

	@Override
    public void update(Observable o, Object ignore) {
		Item i = (Item)o;
		System.out.println("Le robot " + i.id() + " a change d etat !");
    }
}
