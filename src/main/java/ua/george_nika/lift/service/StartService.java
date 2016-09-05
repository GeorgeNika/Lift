package ua.george_nika.lift.service;

import org.springframework.stereotype.Service;
import ua.george_nika.lift.model.Colors;
import ua.george_nika.lift.model.Pot;
import ua.george_nika.lift.model.Situation;

@Service
public class StartService {

    public Situation getStartSituation() {
        Situation situation = new Situation();

        situation.addPot(new Pot(Colors.Red, Colors.Blue, Colors.Blue, Colors.Yellow));
        situation.addPot(new Pot(Colors.Red, Colors.Red, Colors.Red, Colors.Blue));
        situation.addPot(new Pot(Colors.Green, Colors.Yellow, Colors.Yellow, Colors.Blue));
        situation.addPot(new Pot(Colors.Yellow, Colors.Green, Colors.Green, Colors.Green));
        situation.addPot(getEmptyPot());
        situation.addPot(getEmptyPot());
        return situation;
    }

    private Pot getEmptyPot(){
        Pot pot = new Pot(Colors.None, Colors.None, Colors.None, Colors.None);
        return pot;
    }
}
