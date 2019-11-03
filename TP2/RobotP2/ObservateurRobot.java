import java.util.HashMap;
public class ObservateurRobot extends ObservateurItem {
	
    protected ObservateurRobot() {
		super();
    }

    @Override
    public void alerter(Item i) {
		System.out.println("Le robot " + i.id() + " a change d etat !");
    }
}
