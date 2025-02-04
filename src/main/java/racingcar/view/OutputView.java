package racingcar.view;

import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    private final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String ENTER_TRY_TIMES = "시도할 회수는 몇회인가요?";
    private final String FINAL_WINNER = "%s가 최종 우승했습니다.";
    private final String POSITION_BAR = "-";
    private final String NAME_POSITION_DELIMITER = " : ";

    public void printInputCarNamesNotice() {
        System.out.println(ENTER_CAR_NAME);
    }

    public void printInputTryTimesNotice() {
        System.out.println(ENTER_TRY_TIMES);
    }

    public void printSingleRoundResult(final Map<String, Integer> subResult) {
        for (Entry<String, Integer> entry : subResult.entrySet()) {
            System.out.println(entry.getKey()
                + NAME_POSITION_DELIMITER
                + POSITION_BAR.repeat(entry.getValue()));
        }
        System.out.println();
    }

    public void printWinner(final String winners) {
        System.out.printf(FINAL_WINNER, winners);
    }
}
