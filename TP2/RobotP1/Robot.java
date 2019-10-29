package com.robot;

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

    public void deplacer(double dx, double dy) throws ErreurRobot {
        // TODO
        movePosition(dx,dy);    // Deplace le robot
        if (rCharge != null) {  // Deplace les items portés
            for (Item i : rCharge) {
                if (i instanceof Robot) // le robot porte un autre robot
                    ((Robot) i).deplacer(dx, dy);
                else
                    i.movePosition(dx,dy);
            }
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
            i.setPosition(this.position().x(), this.position().y()); // Deplace l'item à charger
            i.levelUp();
            if (i instanceof Robot){    // Augmente le niveau et deplace les items qu'il porte
                for (Item item:((Robot) i).rCharge) {
                    item.levelUp();
                    item.setPosition(this.position().x(), this.position().y());
                }
            }
            rCharge.add(i);
        }
    }

    public void decharger(Item i) throws ErreurRobot {
        // TODO: Condition de déchargement
        if (this.niveau() != 0.0)
            throw new ErreurRobot("Le robot ne peux pas décharger, il est porté!");
        else{
            rCharge.remove(i); // TODO: Should probably check if true/false to avoid levelDown not removed item
            i.levelDown();
            if (i instanceof Robot){    // Diminue le niveau des items qu'il porte
                for (Item item:((Robot) i).rCharge)
                    item.levelDown();
            }
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

        return String.format("%-6s %3d", "Robot", id()) + String.format(", %s: %5.1f", "Masse", masse()) + ", Position " + this.position().toString() + ", Niveau " + niveau()
                + transport;
    }

    /* pas nécessaire à mon avis
    @Override
    public void levelUp(){ this.niveau += 1;}

    @Override
    public void levelDown(){ this.niveau += 1;}
    */
}
