	import java.util.ArrayList;
	public abstract class Item {

    private double masse;
    private Position p;
    private int id;
    private int niveau;
    private static int lastId = 0;
	private ArrayList<ObservateurItem> observateurs;
	
	
	private boolean placed;
	private boolean hasChanged;

    protected Item(double masse, Position p) {
        this.masse = masse;
        this.p = p;
        this.niveau = 0;
        lastId++;
        this.id = lastId;
		observateurs = new ArrayList<>();
		hasChanged = false;
		placed = false;
    }

    public void liste() {
        System.out.println(this.toString());
    }
	
	public boolean isPlaced(){return placed;}
	public void setPlaced(){placed = true;}
	public void clearPlaced(){placed = false;}
	
	public boolean hasChanged(){return hasChanged;}
	public void setChanged(){hasChanged = true;}
	public void clearChanged(){hasChanged = false;}

    public int niveau() { return this.niveau; }

    public double masse() { return this.masse; }

    public void setMasse(double newMasse) { masse = newMasse;}

    public int id() { return this.id; }

    /* retourne une copie de la position, pour qu'on ne puisse pas modifier la
     * position d'un objet par effet de bord sur la valeur retournee.
     */
    public Position position() { return new Position(this.p.x(), this.p.y());}
	
	public void addObserver(ObservateurItem obs){observateurs.add(obs);}
	
	public void deleteObserver (ObservateurItem obs){observateurs.remove(obs);}
	
    /**
     * Deplace position (x,y) par (dx,dy)
     * @param dx: deplacement en x
     * @param dy: deplacement en y
     */
    public void movePosition(double dx, double dy){
		p.move(dx,dy);
		setChanged();
		notifyObservers();
	}

    public double masseTotale(){return this.masse();}

    public void levelUp(){ 
		this.niveau++; 
		setChanged();
		notifyObservers();
	}

    public void levelDown(){ 
		this.niveau --; 
		setChanged();
		notifyObservers();
	}
	
	public void notifyObservers(){
        if(hasChanged()) {
            for(ObservateurItem obs: observateurs){
                obs.alerter(this);
            }
        }
        clearChanged();
    }
}
