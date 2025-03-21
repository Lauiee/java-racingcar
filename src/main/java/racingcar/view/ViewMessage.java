package racingcar.view;

public enum ViewMessage {

    // INPUT
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TIMES("시도할 횟수는 몇 회인가요?"),


    // OUTPUT
    RACING_RESULT("실행 결과"),
    WINNER("최종 우승자 : ")
    ;

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
