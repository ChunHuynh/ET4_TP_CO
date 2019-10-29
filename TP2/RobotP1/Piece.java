package com.robot;

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
        itemz.add(i);
    }

    public void enlever(Item i) throws ErreurRobot {
        itemz.remove(i);
    }
}
