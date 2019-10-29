package com.robot;

public abstract class Item {

    private double masse;
    private Position p;
    private int id;
    private int niveau;
    private static int lastId = 0;

    protected Item(double masse, Position p) {
        this.masse = masse;
        this.p = p;
        this.niveau = 0;
        lastId++;
        this.id = lastId;
    }

    public void liste() {
        System.out.println(this.toString());
    }

    public int niveau() { return this.niveau; }

    public double masse() { return this.masse; }

    public int id() { return this.id; }

    /* retourne une copie de la position, pour qu'on ne puisse pas modifier la
     * position d'un objet par effet de bord sur la valeur retournee.
     */
    public Position position() { return new Position(this.p.x(), this.p.y());}

    public void setPosition(double newX, double newY){
        p.setX(newX);
        p.setY(newY);
    }

    /**
     * Deplace position (x,y) par (dx,dy)
     * @param dx: deplacement en x
     * @param dy: deplacement en y
     */
    public void movePosition(double dx, double dy){p.move(dx,dy);}

    public double masseTotale(){
        return this.masse();
    }

    public void levelUp(){ this.niveau++; }

    public void levelDown(){ this.niveau --; }
}
