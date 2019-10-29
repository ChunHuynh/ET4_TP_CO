import java.util.Observable;
import java.util.Observer;

public abstract class ObservateurItem implements Observer {

    protected ObservateurItem() {
    }

    public void update(Observable o, Object ignore) {
    }
}
