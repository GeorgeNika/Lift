package ua.george_nika.lift.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by george on 31.08.2016.
 */
public class Situation {

    List<Pot> potList;
    MoveStep moveStep;


    public Situation() {
        potList = new ArrayList<>();
        moveStep = new MoveStep();
    }

    public List<Pot> getPotList() {
        return potList;
    }

    public void setPotList(List<Pot> potList) {
        this.potList = potList;
    }

    public MoveStep getMoveStep() {
        return moveStep;
    }

    public void setMoveStep(MoveStep moveStep) {
        this.moveStep = moveStep;
    }
}
