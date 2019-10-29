package com.robot;

public class Caisse extends Item {

    public Caisse(double masse) {
        this(masse, Position.positionDefaut());
    }

    public Caisse(double masse, Position p) {
        super(masse, p);
    }

    @Override
    public String toString() { return String.format("%-6s %3d", "Caisse", id()) +
                                      String.format(", %s: %5.1f", "Masse", masse()) +
                                      ", Position " + this.position().toString() +
                                      ", Niveau " + niveau(); }
}
