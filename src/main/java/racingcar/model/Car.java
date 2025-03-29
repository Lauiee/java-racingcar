package racingcar.model;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이내여야 합니다.");
        }
        this.name = name.trim();
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


}
