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

    public String printPosition(){
        String s = name+" : ";
        for (int i = 0; i<this.position; i++){
            s = s+"-";
        }
        return s;
    }

    public int updateTopPosition(int currentTopPosition) {
        if(this.position>currentTopPosition) return this.position;
        return currentTopPosition;
    }

    public boolean isWinner(int currentTopPosition) {
        return this.position==currentTopPosition;
    }
}
