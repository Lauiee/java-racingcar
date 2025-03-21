package racingcar.model;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(){
        this.position++;
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int updateTopPosition(int currentTopPosition) {
        return Math.max(position, currentTopPosition);
    }

    public boolean isWinner(int currentTopPosition) {
        return this.position==currentTopPosition;
    }
}
