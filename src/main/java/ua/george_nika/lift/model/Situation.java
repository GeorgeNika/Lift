package ua.george_nika.lift.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by george on 31.08.2016.
 */
public class Situation {

    protected List<Pot> potList;
    protected NextMove nextMove;


    public Situation() {
        potList = new ArrayList<>();
        nextMove = new NextMove();
    }

    public NextMove getNextMove() {
        return nextMove;
    }

    public void setNextMove(NextMove nextMove) {
        this.nextMove = nextMove;
    }

    public void addPot(Pot pot){
        potList.add(pot);
    }

    public int getPotSize(){
        return potList.size();
    }

    public Pot getPot(int index){
        return potList.get(index);
    }

    public void executeMove(NextMove nextMove){
        Colors ball = potList.get(nextMove.getStartPot()).popTopBall();
        potList.get(nextMove.getEndPot()).pushBall(ball);
    }

}
