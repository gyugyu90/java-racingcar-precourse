package racinggame;

import java.util.Objects;

public class RacingCar {

    private String name;
    private int progress;

    public RacingCar(String name) {
        validate(name);

        this.name = name;
        this.progress = 0;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public void race(int number) {
        if (number < 4) {
            return;
        }
        progress++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return progress == racingCar.progress && Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, progress);
    }

    private void validate(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("이름을 빈 문자열로 입력할 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이내로 입력 가능합니다.");
        }
    }

}
