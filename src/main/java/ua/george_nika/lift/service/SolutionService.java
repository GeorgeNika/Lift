package ua.george_nika.lift.service;

import org.springframework.stereotype.Service;
import ua.george_nika.lift.exception.NoNextMoveException;
import ua.george_nika.lift.exception.NoSolutionException;
import ua.george_nika.lift.model.MoveStep;
import ua.george_nika.lift.model.Pot;
import ua.george_nika.lift.model.Situation;

import java.util.LinkedList;
import java.util.List;
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
                currentSituation.setMoveStep(getNextMove(currentSituation));
                Situation nextSituation = getNextSituation(currentSituation.getPotList(), currentSituation.getMoveStep());
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
        return  random.nextInt(10)>2;
    }

    private MoveStep getNextMove(Situation situation){
        MoveStep nextMoveStep = new MoveStep();
        nextMoveStep.setStartPot(0);
        nextMoveStep.setEndPot(1);
        if (random.nextInt(10)>4){
            return nextMoveStep;
        } else {
            throw new NoNextMoveException();
        }
    }

    private Situation getNextSituation (List<Pot> potList, MoveStep moveStep){
        Situation nextSituation = new Situation();
        List<Pot> nextPotList = nextSituation.getPotList();
        for (Pot loopPot : potList){
            nextPotList.add(new Pot(loopPot));
        }

// todo применить movestep


        return nextSituation;
    }
}
