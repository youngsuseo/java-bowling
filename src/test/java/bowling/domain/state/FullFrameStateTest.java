package bowling.domain.state;

import bowling.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FullFrameStateTest {

    @DisplayName("볼링 점수 상태 (스트라이크, 스페어, 미스, 거터)에 따라 Score 객체 생성")
    @Test
    void createScore_strike() {
        FullFrameState fullFrameState = new FullFrameState();
        fullFrameState.firstBowl(10);
        Score score = fullFrameState.createScore();
        assertThat(score).isEqualTo(new Score(10, 2));
    }

    @DisplayName("볼링 점수 상태 (스트라이크, 스페어, 미스, 거터)에 따라 Score 객체 생성")
    @Test
    void createScore_spare() {
        FullFrameState fullFrameState = new FullFrameState();
        fullFrameState.firstBowl(9);
        fullFrameState.secondBowl(1);
        Score score = fullFrameState.createScore();
        assertThat(score).isEqualTo(new Score(10, 1));
    }

    @DisplayName("볼링 점수 상태 (스트라이크, 스페어, 미스, 거터)에 따라 Score 객체 생성")
    @Test
    void createScore_miss() {
        FullFrameState fullFrameState = new FullFrameState();
        fullFrameState.firstBowl(3);
        fullFrameState.secondBowl(3);
        Score score = fullFrameState.createScore();
        assertThat(score).isEqualTo(new Score(6, 0));
    }
}