package racinggame;

import java.util.Objects;

public class RacingCar {

	private static final String HYPHEN = "-";

	private static final int MAX_NAME_LENGTH = 5;

	private static final String MESSAGE_EMPTY_STRING = "이름을 빈 문자열로 입력할 수 없습니다.";
	private static final String MESSAGE_TOO_LONG_STRING = "이름은 5자 이내로 입력 가능합니다.";

	private final String name;
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

	public String getStatus() {
		StringBuilder hyphens = new StringBuilder();
		for (int i = 0; i < progress; i++) {
			hyphens.append(HYPHEN);
		}

		return String.format("%s : %s", name, hyphens);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		RacingCar racingCar = (RacingCar) obj;
		return progress == racingCar.progress && Objects.equals(name, racingCar.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, progress);
	}

	@Override
	public String toString() {
		return "RacingCar{"
			+ "name='" + name + '\''
			+ ", progress=" + progress + '}';
	}

	private void validate(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException(MESSAGE_EMPTY_STRING);
		}

		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(MESSAGE_TOO_LONG_STRING);
		}
	}
}
