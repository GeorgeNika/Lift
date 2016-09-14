package ua.george_nika.lift.model;

import java.util.Comparator;

/**
 * Created by george on 09.09.2016.
 */
public class PotComparator implements Comparator<Pot>{

        @Override
        public int compare(Pot p1, Pot p2) {
            if (p1.fourthFloor != p2.fourthFloor){
                return compareColors(p1.fourthFloor, p2.fourthFloor);
            }else if(p1.thirdFloor != p2.thirdFloor){
                return compareColors(p1.thirdFloor, p2.thirdFloor);
            }else if(p1.secondFloor != p2.secondFloor){
                return compareColors(p1.secondFloor, p2.secondFloor);
            }else if(p1.firstFloor != p2.firstFloor){
                return compareColors(p1.firstFloor, p2.firstFloor);
            }
            return 0;
        }

    private int compareColors(Colors b1, Colors b2){
        return b1.compareTo(b2);
    }
}
