package ua.george_nika.lift.service;

import org.springframework.stereotype.Service;
import ua.george_nika.lift.model.Colors;
import ua.george_nika.lift.model.MoveStep;
import ua.george_nika.lift.model.Pot;
import ua.george_nika.lift.model.Situation;

import java.util.ArrayList;
import java.util.List;

@Service
public class StartService {

    public Situation getStartSituation() {
        Situation situation = new Situation();

        List<Pot> potList = situation.getPotList();

        potList.add(get01Pot());
        potList.add(get02Pot());
        potList.add(get03Pot());
        potList.add(get04Pot());
        potList.add(getEmptyPot());
        potList.add(getEmptyPot());
// todo улучшить инкапсул€цию в Situation
        return situation;
    }

    private Pot getEmptyPot(){
        Pot pot = new Pot();
        pot.setFourthFloor(Colors.None);
        pot.setThirdFloor(Colors.None);
        pot.setSecondFloor(Colors.None);
        pot.setFirstFloor(Colors.None);
        return pot;
    }

    private Pot get01Pot(){
        Pot pot = new Pot();
        pot.setFourthFloor(Colors.Red);
        pot.setThirdFloor(Colors.Blue);
        pot.setSecondFloor(Colors.Blue);
        pot.setFirstFloor(Colors.Yellow);
        return pot;
    }

    private Pot get02Pot(){
        Pot pot = new Pot();
        pot.setFourthFloor(Colors.Red);
        pot.setThirdFloor(Colors.Red);
        pot.setSecondFloor(Colors.Red);
        pot.setFirstFloor(Colors.Blue);
        return pot;
    }

    private Pot get03Pot(){
        Pot pot = new Pot();
        pot.setFourthFloor(Colors.Green);
        pot.setThirdFloor(Colors.Yellow);
        pot.setSecondFloor(Colors.Yellow);
        pot.setFirstFloor(Colors.Blue);
        return pot;
    }

    private Pot get04Pot(){
        Pot pot = new Pot();
        pot.setFourthFloor(Colors.Yellow);
        pot.setThirdFloor(Colors.Green);
        pot.setSecondFloor(Colors.Green);
        pot.setFirstFloor(Colors.Green);
        return pot;
    }

}
