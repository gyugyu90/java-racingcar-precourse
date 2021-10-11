package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @CsvSource({"0", "1", "2", "3"})
    @ParameterizedTest
    void testRace01(int number) {
        RacingCar racingCar = new RacingCar("tesla");
        racingCar.race(number);
        assertThat(racingCar.getProgress()).isEqualTo(0);
    }

    @CsvSource({"4", "5", "6", "7", "8", "9"})
    @ParameterizedTest
    void testRace02(int number) {
        RacingCar racingCar = new RacingCar("tesla");
        racingCar.race(number);
        assertThat(racingCar.getProgress()).isEqualTo(1);
    }

}
