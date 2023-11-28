package racingcar.view;

public class OutputView {

    private static final String EXECUTION_RESULT_FORMAT = "\n실행 결과";

    public void printExecutionResultFormat() {
        System.out.println(EXECUTION_RESULT_FORMAT);
    }

    public void printProgressInformation(String information) {
        System.out.println(information);
    }
}
