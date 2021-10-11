package racinggame;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private static final String COMMA = ",";

    private static final String MESSAGE_INPUT_NOT_VALID = "형식에 맞게 값을 입력해 주세요.";
    private static final String MESSAGE_NATURAL_NUMBER = "1 이상의 숫자를 입력해 주세요.";
    private static final String MESSAGE_NUMBER_FORMAT = "숫자 형식에 맞지 않습니다.";

    public List<RacingCar> registerRacingCars(String source) {
        List<RacingCar> list = new ArrayList<>();
        for (String s : source.split(COMMA)) {
            list.add(new RacingCar(s));
        }

        if (list.isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_INPUT_NOT_VALID);
        }
        return list;
    }

    public int parseRounds(String source) {
        try {
            int rounds = Integer.parseInt(source);
            if (rounds < 1) {
                throw new IllegalArgumentException(MESSAGE_NATURAL_NUMBER);
            }

            return rounds;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(MESSAGE_NUMBER_FORMAT);
        }
    }
}
