package racinggame;

import java.util.Collections;
import java.util.List;

public class GameRound {
    private final List<String> statuses;

    public GameRound(List<String> statuses) {
        this.statuses = statuses;
    }

    public List<String> getStatuses() {
        return Collections.unmodifiableList(statuses);
    }
}
