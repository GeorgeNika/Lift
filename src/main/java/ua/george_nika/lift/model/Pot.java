package ua.george_nika.lift.model;

import ua.george_nika.lift.exception.WrongMoveException;

/**
 * Created by george on 31.08.2016.
 */
public class Pot {

    protected Colors firstFloor;
    protected Colors secondFloor;
    protected Colors thirdFloor;
    protected Colors fourthFloor;

    public Pot() {
    }

    public Pot(Colors fourthFloor, Colors thirdFloor, Colors secondFloor, Colors firstFloor) {
        this.fourthFloor = fourthFloor;
        this.thirdFloor = thirdFloor;
        this.secondFloor = secondFloor;
        this.firstFloor = firstFloor;
    }

    public Pot(Pot pot) {
        this.firstFloor = pot.getFirstFloor();
        this.secondFloor = pot.getSecondFloor();
        this.thirdFloor = pot.getThirdFloor();
        this.fourthFloor = pot.getFourthFloor();
    }

    private Colors getFirstFloor() {
        return firstFloor;
    }

    private Colors getSecondFloor() {
        return secondFloor;
    }

    private Colors getThirdFloor() {
        return thirdFloor;
    }

    private Colors getFourthFloor() {
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
        } else if (secondFloor == Colors.None) {
            secondFloor = ball;
        } else if (thirdFloor == Colors.None) {
            thirdFloor = ball;
        } else if (fourthFloor == Colors.None) {
            fourthFloor = ball;
        } else {
            throw new WrongMoveException();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pot)) return false;

        Pot pot = (Pot) o;

        if (firstFloor != pot.firstFloor) return false;
        if (secondFloor != pot.secondFloor) return false;
        if (thirdFloor != pot.thirdFloor) return false;
        return fourthFloor == pot.fourthFloor;

    }

    @Override
    public int hashCode() {
        int result = firstFloor != null ? firstFloor.hashCode() : 0;
        result = 31 * result + (secondFloor != null ? secondFloor.hashCode() : 0);
        result = 31 * result + (thirdFloor != null ? thirdFloor.hashCode() : 0);
        result = 31 * result + (fourthFloor != null ? fourthFloor.hashCode() : 0);
        return result;
    }
}
