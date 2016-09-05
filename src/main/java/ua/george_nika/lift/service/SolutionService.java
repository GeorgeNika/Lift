package ua.george_nika.lift.service;

import org.springframework.stereotype.Service;
import ua.george_nika.lift.exception.NoNextMoveException;
import ua.george_nika.lift.exception.NoSolutionException;
import ua.george_nika.lift.model.NextMove;
import ua.george_nika.lift.model.Pot;
import ua.george_nika.lift.model.Situation;

import java.util.LinkedList;
import java.util.Random;

@Service
public class SolutionService {

    Random random = new Random();

    public LinkedList<Situation> findSolution (Situation startSituation){
        LinkedList<Situation> situationList = new LinkedList<>();
        situationList.add(startSituation);

        Situation currentSituation;
        while(isNotSolved(getCurrentSituation(situationList))){
            try {
                currentSituation = getCurrentSituation(situationList);
                currentSituation.setNextMove(getNextMove(currentSituation));
                Situation nextSituation = getNextSituation(currentSituation, currentSituation.getNextMove());
                situationList.add(nextSituation);
            } catch(NoNextMoveException ex){
                if (situationList.size() > 1){
                    situationList.removeLast();
                } else {
                    throw new NoSolutionException();
                }
            }
        }
        return situationList;
    }

    private Situation getCurrentSituation(LinkedList<Situation> situationList){
        return situationList.getLast();
    }

    private boolean isNotSolved(Situation situation){
        for (int i=0 ; i<situation.getPotSize(); i++){
            if (!situation.getPot(i).isSolvedPot()){
                return false;
            }
        }
        return  true;
    }

    private NextMove getNextMove(Situation situation){
        //todo
        NextMove nextNextMove = new NextMove();
        nextNextMove.setStartPot(0);
        nextNextMove.setEndPot(4);
        if (random.nextInt(10)>3){
            return nextNextMove;
        } else {
            throw new NoNextMoveException();
        }
    }

    private Situation getNextSituation (Situation situation, NextMove nextMove){
        Situation nextSituation = new Situation();
        for (int i=0 ; i<situation.getPotSize(); i++){
            nextSituation.addPot(new Pot(situation.getPot(i)));
        }
        nextSituation.executeMove(nextMove);
        return nextSituation;
    }
}
