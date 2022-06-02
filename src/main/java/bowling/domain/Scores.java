package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Scores {
    private static final int NUMBER_OF_FRAMES = 10;

    private List<Score> scores;

    public Scores() {
        initial();
    }

    public Scores(List<Score> scores) {
        this.scores = scores;
    }

    private void initial() {
        scores =  new ArrayList<>();
        for (int frameIndex = 1; frameIndex <= NUMBER_OF_FRAMES; frameIndex++) {
            scores.add(new Score());
        }
    }

    public List<Score> getScores() { // FIXME 필요 없을시 삭제
        return scores;
    }
}
