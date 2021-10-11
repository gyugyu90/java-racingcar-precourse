package racinggame;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private static final String COMMA = ",";

    public List<RacingCar> registerRacingCars(String source) {
        List<RacingCar> list = new ArrayList<>();
        for (String s : source.split(COMMA)) {
            list.add(new RacingCar(s));
        }

        if (list.isEmpty()) {
            throw new IllegalArgumentException("형식에 맞게 값을 입력해 주세요.");
        }
        return list;
    }

    public int parseRounds(String source) {
        try {
            int rounds = Integer.parseInt(source);
            if (rounds < 1) {
                throw new IllegalArgumentException("1 이상의 숫자를 입력해 주세요.");
            }

            return rounds;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자 형식에 맞지 않습니다.");
        }
    }
}
