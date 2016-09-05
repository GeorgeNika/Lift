package ua.george_nika.lift.model;

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

    public Pot(Colors firstFloor, Colors secondFloor, Colors thirdFloor, Colors fourthFloor) {
        this.firstFloor = firstFloor;
        this.secondFloor = secondFloor;
        this.thirdFloor = thirdFloor;
        this.fourthFloor = fourthFloor;
    }

    public Pot(Pot pot) {
        this.firstFloor = pot.getFirstFloor();
        this.secondFloor = pot.getSecondFloor();
        this.thirdFloor = pot.getThirdFloor();
        this.fourthFloor = pot.getFourthFloor();
    }



    public Colors getFirstFloor() {
        return firstFloor;
    }

    public void setFirstFloor(Colors firstFloor) {
        this.firstFloor = firstFloor;
    }

    public Colors getSecondFloor() {
        return secondFloor;
    }

    public void setSecondFloor(Colors secondFloor) {
        this.secondFloor = secondFloor;
    }

    public Colors getThirdFloor() {
        return thirdFloor;
    }

    public void setThirdFloor(Colors thirdFloor) {
        this.thirdFloor = thirdFloor;
    }

    public Colors getFourthFloor() {
        return fourthFloor;
    }

    public void setFourthFloor(Colors fourthFloor) {
        this.fourthFloor = fourthFloor;
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
