package racingcar.view;

import static racingcar.utils.ErrorMessage.WRONG_TRY_TIMES_RANGE;
import static racingcar.utils.ErrorMessage.WRONG_TRY_TIMES_TYPE;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final int MIN_TRY_TIMES = 1;
    private final String CAR_NAME_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputCarNames() {
        String carNames = scanner.nextLine();
        return List.of(carNames.split(CAR_NAME_DELIMITER));
    }

    public int inputTryTimes() {
        return validateTryTimes(scanner.nextLine());
    }

    protected int validateTryTimes(final String input) {
        int tryTimes = validateTryTimesType(input);
        validateTryTimesRange(tryTimes);

        return tryTimes;
    }

    private int validateTryTimesType(final String tryTimes) {
        try {
            return Integer.parseInt(tryTimes);
        } catch (Exception e) {
            throw new IllegalArgumentException(WRONG_TRY_TIMES_TYPE.of());
        }
    }

    private void validateTryTimesRange(final int tryTimes) {
        if (tryTimes < MIN_TRY_TIMES) {
            throw new IllegalArgumentException(WRONG_TRY_TIMES_RANGE.of());
        }
    }
}
