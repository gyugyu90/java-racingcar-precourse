package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("tesla");
    }

    @CsvSource({"0", "1", "2", "3"})
    @ParameterizedTest
    void testRace01(int number) {
        racingCar.race(number);
        assertThat(racingCar.getProgress()).isEqualTo(0);
    }

    @CsvSource({"4", "5", "6", "7", "8", "9"})
    @ParameterizedTest
    void testRace02(int number) {
        racingCar.race(number);
        assertThat(racingCar.getProgress()).isEqualTo(1);
    }

    @Test
    void testGetStatus() {
        racingCar.race(1);
        racingCar.race(7);
        racingCar.race(8);
        racingCar.race(4);
        racingCar.race(3);

        assertThat(racingCar.getStatus()).isEqualTo("tesla : ---");
    }
}
