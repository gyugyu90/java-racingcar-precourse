package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameServiceTest {

    private final GameService gameService = new GameService();

    @DisplayName("사용자가 입력한 값을 쉼표로 나누어서 Racing Car를 생성할 수 있어야 함")
    @Test
    void testRegisterRacingCars01() {
        String source = "foo,bar,baz,lorem,ipsum";
        List<RacingCar> racingCars = gameService.registerRacingCars(source);
        assertThat(racingCars).isEqualTo(Arrays.asList(
                new RacingCar("foo"),
                new RacingCar("bar"),
                new RacingCar("baz"),
                new RacingCar("lorem"),
                new RacingCar("ipsum")
        ));
    }

    @DisplayName("사용자가 입력한 값이 5자가 넘으면 예외 발생")
    @Test
    void testRegisterRacingCars02() {
        String source = "abcdef,foo,bar";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> gameService.registerRacingCars(source))
                .withMessageContaining("이름은 5자 이내로 입력 가능합니다.");
    }

    @DisplayName("사용자가 입력한 값이 공백이면 예외 발생")
    @Test
    void testRegisterRacingCars03() {
        String source = "foo,,bar";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> gameService.registerRacingCars(source))
                .withMessageContaining("이름을 빈 문자열로 입력할 수 없습니다.");
    }
}
