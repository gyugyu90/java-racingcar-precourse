package racinggame;

import nextstep.utils.Console;

public class GameView {

    public String racingCarsForm() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String roundsForm() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Console.readLine();
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void showRaceStatus(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            System.out.println(racingCar.getStatus());
        }
        System.out.println();
    }

    public void showResultHeader() {
        System.out.println("실행 결과");
    }

    public void showWinners(String winners) {
        System.out.printf("최종 우승자는 %s 입니다.%n", winners);
    }
}
