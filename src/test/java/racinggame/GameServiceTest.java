package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameServiceTest {

    private final GameService gameService = new GameService();

    @DisplayName("사용자가 입력한 값을 쉼표로 나누어서 Racing Car를 생성할 수 있어야 함")
    @Test
    void testRegisterRacingCars01() {
        String source = "foo,bar,baz,lorem,ipsum";
        RacingCars racingCars = gameService.registerRacingCars(source);
        assertThat(racingCars.getRacingCars()).isEqualTo(Arrays.asList(
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

    @DisplayName("사용자가 입력한 값으로 racing car를 생성할 수 없으면 예외 발생")
    @Test
    void testRegisterRacingCars04() {
        String source = ",,,";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> gameService.registerRacingCars(source))
                .withMessageContaining("형식에 맞게 값을 입력해 주세요.");
    }

    @DisplayName("rounds - 사용자가 입력한 값으로 round 값을 파싱")
    @Test
    void testParseRounds01() {
        assertEquals(12, gameService.parseRounds("12"));
    }

    @DisplayName("rounds - 사용자가 입력한 값이 숫자가 아닐 경우 예외 발생")
    @Test
    void testParseRounds02() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> gameService.parseRounds("aaa"))
                .withMessageContaining("숫자 형식에 맞지 않습니다.");
    }

    @DisplayName("rounds - 사용자가 입력한 값이 자연수가 아닐 경우 예외 발생")
    @Test
    void testParseRounds03() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> gameService.parseRounds("0"))
                .withMessageContaining("1 이상의 숫자를 입력해 주세요.");
    }
}
