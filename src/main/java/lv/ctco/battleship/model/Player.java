package lv.ctco.battleship.model;

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1;

    private String name;
    private final Field myField = new Field();
    private final Field oppositeField = new Field();
    private boolean placementComplete;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Field getMyField() {
        return myField;
    }

    public Field getOppositeField() {
        return oppositeField;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean isPlacementComplete() {
        return placementComplete;
    }

    public void setPlacementComplete(boolean placementComplete) {
        this.placementComplete = placementComplete;
    }
}
