import java.util.ArrayList;

public class Piece {

    private ArrayList<Item> itemz;

    public Piece() {
        itemz = new ArrayList<>();
    }

    public void listeTous() {
        for (Item i:this.itemz)
            i.liste();
    }

    public void placer(Item i) throws ErreurRobot {
        if(i.isPlaced())
			throw new ErreurRobot ("L'objet est deja place !");
		else {
			itemz.add(i);
			i.setPlaced();
		}
    }

    public void enlever(Item i) throws ErreurRobot {
        if(!itemz.contains(i))
			throw new ErreurRobot ("L'objet n'existe pas dans la piece !");
		else{
			itemz.remove(i);
			i.clearPlaced();
		}
    }
}
