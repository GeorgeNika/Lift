package ua.george_nika.lift.model;

import ua.george_nika.lift.exception.WrongMoveException;

import java.util.Comparator;

/**
 * Created by george on 31.08.2016.
 */
public class Pot {

    protected Colors fourthFloor;
    protected Colors thirdFloor;
    protected Colors secondFloor;
    protected Colors firstFloor;

    public Pot(Colors fourthFloor, Colors thirdFloor, Colors secondFloor, Colors firstFloor) {
        this.fourthFloor = fourthFloor;
        this.thirdFloor = thirdFloor;
        this.secondFloor = secondFloor;
        this.firstFloor = firstFloor;
    }

    public Pot(Pot pot) {
        this.fourthFloor = pot.getFourthFloor();
        this.thirdFloor = pot.getThirdFloor();
        this.secondFloor = pot.getSecondFloor();
        this.firstFloor = pot.getFirstFloor();

    }

    public Colors getFirstFloor() {
        return firstFloor;
    }

    public Colors getSecondFloor() {
        return secondFloor;
    }

    public Colors getThirdFloor() {
        return thirdFloor;
    }

    public Colors getFourthFloor() {
        return fourthFloor;
    }

    public Colors getTopBallColor() {
        if (fourthFloor != Colors.None){
            return fourthFloor;
        }
        if (thirdFloor != Colors.None){
            return thirdFloor;
        }
        if (secondFloor != Colors.None){
            return secondFloor;
        }
        if (firstFloor != Colors.None){
            return firstFloor;
        }
        return Colors.None;
    }

    public Colors popTopBall() {
        Colors returnedBall;
        if (fourthFloor != Colors.None){
            returnedBall = fourthFloor;
            fourthFloor = Colors.None;
            return returnedBall;
        }
        if (thirdFloor != Colors.None){
            returnedBall = thirdFloor;
            thirdFloor = Colors.None;
            return returnedBall;
        }
        if (secondFloor != Colors.None){
            returnedBall = secondFloor;
            secondFloor = Colors.None;
            return returnedBall;
        }
        if (firstFloor != Colors.None){
            returnedBall = firstFloor;
            firstFloor = Colors.None;
            return returnedBall;
        }
        throw new WrongMoveException();
    }

    protected void pushBall(Colors ball) {
        if (firstFloor == Colors.None) {
            firstFloor = ball;
        } else if (secondFloor == Colors.None && firstFloor == ball) {
            secondFloor = ball;
        } else if (thirdFloor == Colors.None && secondFloor == ball) {
            thirdFloor = ball;
        } else if (fourthFloor == Colors.None && thirdFloor == ball) {
            fourthFloor = ball;
        } else {
            throw new WrongMoveException();
        }
    }

    public boolean isSolvedPot(){
        return (firstFloor == secondFloor) && (thirdFloor == fourthFloor) && (firstFloor == fourthFloor);
    }

    public boolean isCanMove(Colors ball){
        if (fourthFloor != Colors.None){
            return false;
        }
        if (getTopBallColor() == ball || getTopBallColor() == Colors.None){
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pot)) return false;

        Pot pot = (Pot) o;

        if (fourthFloor != pot.fourthFloor) return false;
        if (thirdFloor != pot.thirdFloor) return false;
        if (secondFloor != pot.secondFloor) return false;
        return firstFloor == pot.firstFloor;

    }

    @Override
    public int hashCode() {
        int result = fourthFloor != null ? fourthFloor.hashCode() : 0;
        result = 31 * result + (thirdFloor != null ? thirdFloor.hashCode() : 0);
        result = 31 * result + (secondFloor != null ? secondFloor.hashCode() : 0);
        result = 31 * result + (firstFloor != null ? firstFloor.hashCode() : 0);
        return result;
    }
}

