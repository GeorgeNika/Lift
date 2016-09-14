package ua.george_nika.lift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.george_nika.lift.exception.NoNextMoveException;
import ua.george_nika.lift.exception.NoSolutionException;
import ua.george_nika.lift.model.Colors;
import ua.george_nika.lift.model.NextMove;
import ua.george_nika.lift.model.Pot;
import ua.george_nika.lift.model.Situation;

import java.util.LinkedList;

@Service
public class SolutionService {

    @Autowired
    StartService startService;

    private LinkedList<Situation> situationList = new LinkedList<>();
    private LinkedList<Situation> viewedSituationList = new LinkedList<>();


    public LinkedList<Situation> findSolution(Situation startSituation) {
        situationList.clear();
        viewedSituationList.clear();
        situationList.add(startSituation);

        Situation currentSituation;
        NextMove nextMove;
        while (!isSolved(getCurrentSituation(situationList))) {
            try {
                currentSituation = getCurrentSituation(situationList);
                nextMove = getNextMove(currentSituation);
                currentSituation.setNextMove(nextMove);
                Situation nextSituation = getNextSituation(currentSituation, nextMove);
                situationList.add(nextSituation);
                viewedSituationList.add(nextSituation);
            } catch (NoNextMoveException ex) {
                if (situationList.size() > 1) {
                    situationList.removeLast();
                } else {
                    throw new NoSolutionException();
                }
            }
        }
        return situationList;
    }

    private Situation getCurrentSituation(LinkedList<Situation> situationList) {
        return situationList.getLast();
    }

    private boolean isSolved(Situation situation) {
        for (int i = 0; i < situation.getPotSize(); i++) {
            if (!situation.getPot(i).isSolvedPot()) {
                return false;
            }
        }
        return true;
    }

    private NextMove getNextMove(Situation situation) {
        NextMove resultMove = new NextMove();
        int startMove = situation.getNextMove().getStartPot();
        int endMove = situation.getNextMove().getEndPot();
        Colors movedBall;

        while (startMove < situation.getPotSize()){
            resultMove.setStartPot(startMove);
            movedBall = situation.getPot(startMove).getTopBallColor();
            while (endMove < situation.getPotSize()-1){
                endMove ++;
                if (startMove==endMove){
                    continue;
                }
                if (situation.getPot(endMove).isCanMove(movedBall)){
                    resultMove.setEndPot(endMove);
                    if (!viewedSituationList.contains(getNextSituation(situation, resultMove))){
                        return resultMove;
                    }
                }
            }
            startMove ++;
            endMove = -1;
        }
        throw new NoNextMoveException();
    }

    private Situation getNextSituation(Situation situation, NextMove nextMove) {
        Situation nextSituation = new Situation();
        for (int i = 0; i < situation.getPotSize(); i++) {
            nextSituation.addPot(new Pot(situation.getPot(i)));
        }
        nextSituation.executeMove(nextMove);
        return nextSituation;
    }
}
