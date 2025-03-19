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

    public int getPosition(){
        return this.position;
    }
}
