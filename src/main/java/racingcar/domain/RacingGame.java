package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingCarDto;
import racingcar.dto.RacingGameResultDto;
import racingcar.utils.powerGenerator.PowerGenerator;
import racingcar.utils.powerGenerator.RandomPowerGenerator;

public class RacingGame {
    private final List<Car> cars;
    private final PowerGenerator powerGenerator;
    private final int playCount;

    public RacingGame(final String[] carNames, final int tryCount) {
        this.powerGenerator = new RandomPowerGenerator();
        this.cars = generateCars(carNames);
        this.playCount = tryCount;
    }

    public void start() {
        int tryCount = playCount;
        while (!isEnd(tryCount--)) {
            moveCars();
        }
    }

    public List<Car> getWinners() {
        final int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private List<Car> generateCars(final String[] carNames) {
        final List<Car> cars = new ArrayList<>();
        for (final String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private boolean isEnd(final int tryCount) {
        return tryCount <= 0;
    }

    private void moveCars() {
        for (final Car car : cars) {
            final int power = powerGenerator.generate();
            car.move(power);
        }
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(0);
    }

    public RacingGameResultDto convertToDto() {
        final List<RacingCarDto> racingCarDtos = cars.stream()
                .map(Car::convertToDto)
                .collect(Collectors.toList());
        final String names = getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));

        return new RacingGameResultDto(names, playCount, racingCarDtos);
    }
}