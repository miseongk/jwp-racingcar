package racingcar.strategy;


import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class RandomMovingStrategy implements MovingStrategy {

    private final int MAX_MOVING_NUM = 9;
    private final Random random = new Random();

    @Override
    public int getRandomNumber() {
        return random.nextInt(MAX_MOVING_NUM);
    }
}