package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerCalculatorTest {

    private static final int SCORE_GETTABLE_NUMBER = 9;

    @DisplayName("winner calculator - evaluate 메소드를 여러번 호출하면 우승자를 저장해 두었다가 확인할 수 있음")
    @Test
    void testEvaluate01() {
        WinnerCalculator winnerCalculator = new WinnerCalculator();
        winnerCalculator.evaluate(createRacingCarWithScore("foo", 5));
        winnerCalculator.evaluate(createRacingCarWithScore("bar", 4));
        winnerCalculator.evaluate(createRacingCarWithScore("baz", 3));

        assertEquals(new HashSet<>(Collections.singletonList("foo")), winnerCalculator.getWinners());
    }

    @DisplayName("winner calculator - 우승자가 한 명 이상일 경우")
    @Test
    void testEvaluate02() {
        WinnerCalculator winnerCalculator = new WinnerCalculator();
        winnerCalculator.evaluate(createRacingCarWithScore("foo", 5));
        winnerCalculator.evaluate(createRacingCarWithScore("bar", 5));
        winnerCalculator.evaluate(createRacingCarWithScore("baz", 3));

        assertEquals(new HashSet<>(Arrays.asList("foo", "bar")), winnerCalculator.getWinners());
    }

    private RacingCar createRacingCarWithScore(String name, int score) {
        RacingCar racingCar = new RacingCar(name);
        for (int i = 0; i < score; i++) {
            racingCar.race(SCORE_GETTABLE_NUMBER);
        }
        return racingCar;
    }

}
