package ua.george_nika.lift.model;

/**
 * Created by george on 04.09.2016.
 */
public class NextMove {

    protected int startPot;
    protected int endPot;

    public NextMove() {
        startPot = 0;
        endPot = 0;
    }

    public int getStartPot() {
        return startPot;
    }

    public void setStartPot(int startPot) {
        this.startPot = startPot;
    }

    public int getEndPot() {
        return endPot;
    }

    public void setEndPot(int endPot) {
        this.endPot = endPot;
    }
}
