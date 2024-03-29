import java.util.ArrayList;

public class Robot extends Item {

    private double chargeMax;
    private ArrayList<Item> rCharge;

    public Robot(double masse, double max) {
        this(masse, max, Position.positionDefaut());
    }

    public Robot(double masse, double max, Position p) {
	    super(masse, p);
	    this.chargeMax = max;
	    this.rCharge = new ArrayList<>();
    }

    public double chargeMax() { return this.chargeMax; }

    public double charge() {
        double charge = 0.0;
        for (Item i:rCharge)
            charge += i.masseTotale();
        return charge;
    }

    @Override
    public double masseTotale() {
        return this.masse() + this.charge();
    }

    @Override 
	public void movePosition(double dx, double dy){
		super.movePosition(dx,dy);
		for (Item i : rCharge){
			i.movePosition(dx, dy);
		}
	}
	
    public void deplacer(double dx, double dy) throws ErreurRobot {
		if (niveau() != 0.0)
            throw new ErreurRobot("L'objet a charger n'est pas au niveau 0!");
		else{
			movePosition(dx,dy);    // Deplace le robot
        }
    }

    public void charger(Item i) throws ErreurRobot {
        if (this.niveau() != 0.0) // TODO: vérifier que le robot ne se charge pas lui-même(?)
            throw new ErreurRobot("Le robot n'est pas au niveau 0!");
        else if (i.niveau() != 0.0)
            throw new ErreurRobot("L'objet a charger n'est pas au niveau 0!");
        else if ( (i.masseTotale()+this.masseTotale()) > this.chargeMax())
            throw new ErreurRobot("Le robot sera en surcharge!");
        else{
            i.movePosition(position().x()-i.position().x(), position().y()-i.position().y());
            i.levelUp();
            rCharge.add(i);
			
			setChanged();
			notifyObservers();
        }
    }

    public void decharger(Item i) throws ErreurRobot {
        if (this.niveau() != 0.0)
            throw new ErreurRobot("Le robot ne peux pas décharger, il est porté!");
		else if (!(rCharge.contains(i)))
			throw new ErreurRobot("Le robot décharge un objet qu'il ne porte pas !");
        else{
            rCharge.remove(i);
            i.levelDown();
			
			setChanged();
			notifyObservers();
        }
    }

    @Override
    public String toString() {
        String transport;
        if(!rCharge.isEmpty()){
            transport = ", Transporte : " + "\n     " + "-----" + "\n     ";
            for (Item i: rCharge){
                transport += i.toString() + "\n     ";
            }
            transport += "-----";
        }else{ transport = "";}

        return String.format("%-10s %3d", "Robot", id()) + 
        	   String.format(", %s: %5.1f", "Masse", masse()) + 
        	   ", Position " + this.position().toString() + 
        	   ", Niveau " + niveau() + 
        	   String.format(", %s: %5.1f", "Charge actuelle", charge()) + 
               transport;
    }

    @Override
    public void levelUp(){ 
    	super.levelUp(); 		 // +1 au robot
    	for (Item item:rCharge){ // +1 aux items portés et les déplace
    		item.levelUp();
    		item.movePosition(position().x()-item.position().x(), position().y()-item.position().y());
    	}
    }

    @Override
    public void levelDown(){ 
    	super.levelDown();		// -1 au robot
    	for (Item item:rCharge) // -1 aux items portés
    		item.levelDown();
    }

}
