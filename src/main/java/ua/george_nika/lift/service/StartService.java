package ua.george_nika.lift.service;

import org.springframework.stereotype.Service;
import ua.george_nika.lift.model.Colors;
import ua.george_nika.lift.model.Pot;
import ua.george_nika.lift.model.Situation;

import java.util.HashMap;
import java.util.Map;

@Service
public class StartService {


    public Situation getStartSituation() { //150
        Situation situation = new Situation();

        situation.addPot(new Pot(Colors.Yellow, Colors.Orange, Colors.White, Colors.DarkPurple));
        situation.addPot(new Pot(Colors.LightBlue, Colors.LightBlue, Colors.White, Colors.Gray));
        situation.addPot(new Pot(Colors.Gray, Colors.Red, Colors.Salat, Colors.Blue));
        situation.addPot(new Pot(Colors.DarkPurple, Colors.DarkBlue, Colors.White, Colors.Blue));
        situation.addPot(new Pot(Colors.LightPurple, Colors.Blue, Colors.Red, Colors.LightPurple));
        situation.addPot(new Pot(Colors.Yellow, Colors.Yellow, Colors.Green, Colors.LightPurple));
        situation.addPot(new Pot(Colors.Yellow, Colors.Pink, Colors.Gray, Colors.Green));
        situation.addPot(new Pot(Colors.LightBlue, Colors.DarkBlue, Colors.Gray, Colors.White));
        situation.addPot(new Pot(Colors.Salat, Colors.Green, Colors.Pink, Colors.DarkBlue));
        situation.addPot(new Pot(Colors.Red, Colors.Green, Colors.Salat, Colors.Blue));
        situation.addPot(new Pot(Colors.Red, Colors.Pink, Colors.Pink, Colors.DarkPurple));
        situation.addPot(new Pot(Colors.Salat, Colors.Orange, Colors.LightBlue, Colors.DarkPurple));
        situation.addPot(new Pot(Colors.Orange, Colors.DarkBlue, Colors.LightPurple, Colors.Orange));
        situation.addPot(getEmptyPot());
        situation.addPot(getEmptyPot());
        return situation;
    }

    private Pot getEmptyPot(){
        Pot pot = new Pot(Colors.None, Colors.None, Colors.None, Colors.None);
        return pot;
    }

    public boolean checkSituation(Situation situation){
        Map <Colors, Integer> colorsCountMap = new HashMap<>();
        Pot tempPot;
        for (int i = 0; i<situation.getPotSize(); i++){
            tempPot = situation.getPot(i);
            addColorsToMap(colorsCountMap, tempPot.getFirstFloor());
            addColorsToMap(colorsCountMap, tempPot.getSecondFloor());
            addColorsToMap(colorsCountMap, tempPot.getThirdFloor());
            addColorsToMap(colorsCountMap, tempPot.getFourthFloor());
        }
        for (Integer loopInt : colorsCountMap.values()){
            if (loopInt != 4){
                return false;
            }
        }
        return true;
    }

    private void addColorsToMap (Map<Colors,Integer> map, Colors colors){
        if (colors==Colors.None){
            return;
        }
        map.putIfAbsent(colors, 0);
        map.put(colors, map.get(colors)+1);
    }
}
