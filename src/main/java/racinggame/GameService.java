package racinggame;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private static final String COMMA = ",";

    private static final int ZERO = 0;

    private static final String MESSAGE_INPUT_NOT_VALID = "형식에 맞게 값을 입력해 주세요.";
    private static final String MESSAGE_NATURAL_NUMBER = "1 이상의 숫자를 입력해 주세요.";
    private static final String MESSAGE_NUMBER_FORMAT = "숫자 형식에 맞지 않습니다.";

    private RacingCars racingCars;

    public void registerRacingCars(String source) {
        List<RacingCar> list = new ArrayList<>();
        for (String s : source.split(COMMA)) {
            list.add(new RacingCar(s));
        }

        validateNotEmpty(list);
        racingCars = new RacingCars(list);
    }

    public int parseRounds(String source) {
        try {
            int rounds = Integer.parseInt(source);
            validateNaturalNumber(rounds);

            return rounds;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(MESSAGE_NUMBER_FORMAT);
        }
    }

    public List<String> proceedRound() {
        racingCars.race();

        List<String> messages = new ArrayList<>();
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            messages.add(racingCar.getStatus());
        }
        return messages;
    }

    public String calculateWinners() {
        WinnerCalculator winnerCalculator = new WinnerCalculator();
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            winnerCalculator.evaluate(racingCar);
        }

        return String.join(",", winnerCalculator.getWinners());
    }

    RacingCars getCars() {
        return racingCars;
    }

    private void validateNotEmpty(List<RacingCar> list) {
        if (list.size() > 0) {
            return;
        }
        throw new IllegalArgumentException(MESSAGE_INPUT_NOT_VALID);
    }

    private void validateNaturalNumber(int number) {
        if (number > ZERO) {
            return;
        }

        throw new IllegalArgumentException(MESSAGE_NATURAL_NUMBER);
    }
}
